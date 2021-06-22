package com.example.githublist.features.home.data.network

import com.example.githublist.features.home.data.shecmas.HomeSchema
import com.example.githublist.features.home.data.shecmas.RepositorioSchema
import retrofit2.Response
import retrofit2.http.GET

interface RepoApi{

@GET("search/repositories?q=language:Java&sort=stars&page=1")
    suspend fun pegarRepositorio():Response<HomeSchema>



}