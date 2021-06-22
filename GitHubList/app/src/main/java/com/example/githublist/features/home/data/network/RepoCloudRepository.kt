package com.example.githublist.features.home.data.network

import com.example.githublist.app.network.RequestManeger
import com.example.githublist.features.home.data.shecmas.HomeSchema
import com.example.githublist.features.home.data.shecmas.RepositorioSchema

internal class RepoCloudRepository(private val repoApi:RepoApi):RepoRepository {



    override suspend fun pegarRepositorio(): HomeSchema? {
        return RequestManeger.requestfromApi {  repoApi.pegarRepositorio()}
    }


}