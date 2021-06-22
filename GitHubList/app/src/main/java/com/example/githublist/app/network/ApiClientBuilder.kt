package com.example.githublist.app.network

import android.app.Application
import com.google.gson.GsonBuilder
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClientBuilder {
    const val GIT_API_URL = "https://api.github.com/"

    private val baseClient = OkHttpClient()
    private val defaultUrl = this.GIT_API_URL
    private val cacheSize = 100

    /**
     * create a service api to consume via retrofit
     *
     * @param serviceClass the the api definition interface
     * @param baseUrl the base url of the api (or use default)
     * @param gson the gson configuration (or use default)
     * @param readTimeout the read timeout in seconds (or use default)
     * @param useMetadataInterceptor indicates if should add the [MetadataInterceptor] (will be the first interceptor)
     * @param useAuthInterceptor indicates if should add the [AuthInterceptor]
     * @param interceptors aditional interceptors
     * */
    fun <S> createServiceApi(
            application: Application,
            serviceClass: Class<S>,
            baseUrl: String = defaultUrl,
            readTimeout: Long = 35,
            useMetadataInterceptor: Boolean = true,
            useAuthInterceptor: Boolean = true,
            vararg interceptors: Interceptor,
            gsonConverter: Boolean = true,
            forceNetwork: Boolean = false
    ): S {
        val myCache = Cache(application.cacheDir, (cacheSize * 1024 * 1024).toLong())
        val gson = GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create()
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val builder = baseClient.newBuilder()
                .connectTimeout(readTimeout, TimeUnit.SECONDS)
                .readTimeout(readTimeout, TimeUnit.SECONDS)
                .writeTimeout(readTimeout, TimeUnit.SECONDS)
                .cache(myCache)


        //interceptors - verificação de token
        interceptors.forEach { builder.addInterceptor(it) }
        builder.addInterceptor(logging)
        val client = builder.build()
        val retrofit = Retrofit.Builder()
                .client(client)
                .baseUrl(baseUrl)
        if (gsonConverter) retrofit.addConverterFactory(GsonConverterFactory.create(gson))
        return retrofit.build().create(serviceClass)
    }
}

class ConnectivityInterceptor(val application: Application) :
        Interceptor {
    // NetworkStateHelper is some class we have that checks if we are online or not.


    @Throws(Exception::class)
    private fun getResponseFromCache(
            chain: Interceptor.Chain,
            request: Request
    ): Response {
        // We just create a new request out of the old one and set cache headers to it with the cache control.
        // The CacheControl.FORCE_CACHE is already provided by OkHttp3
        var requestAux: Request = request
        requestAux = request.newBuilder().header(
                "Cache-Control",
                "public, only-if-cached, max-stale=${60 * 60 * 24 * 7}"
        ).build()

        // Now we proceed with the request and OkHttp should automatically fetch the response from cache or return
        // a failure if it is not there, some 5xx status code
        return chain.proceed(requestAux)
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()

        if (request.method == "GET") {
            val x = getResponseFromCache(chain, request)
            if (x.code == 504) {
                request.newBuilder().header("Cache-Control", "public, max-age=604800").build()
                val response = chain.proceed(request)
                return response
            }
            return x
        } else {
            request.newBuilder().header("Cache-Control", "public, max-age=5").build()
            val response = chain.proceed(request)
            return response
        }
    }
}
