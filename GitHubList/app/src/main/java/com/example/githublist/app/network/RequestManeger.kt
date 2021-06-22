package com.example.githublist.app.network

import android.util.Log
import retrofit2.Response
import java.lang.Exception

object RequestManeger {


    //suspend fun, sao chamadas assincronas vindas do Kotlin corroutines
    suspend fun <T> requestfromApi(request:suspend() -> Response<T>):T?{
        try {
            val response = request()

            if(response.isSuccessful){

                return response.body()
            }else
            {
                Log.e("resultado1",response.code().toString())
                //TODO tratamento de erro

            }
        }catch (e:Exception){
            Log.e("resultado2",e.localizedMessage)

        }

        return null
    }
}