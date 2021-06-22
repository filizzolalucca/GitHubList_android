package com.example.githublist.features.home.data.network

import com.example.githublist.features.home.data.shecmas.HomeSchema
import com.example.githublist.features.home.data.shecmas.RepositorioSchema

interface RepoRepository {
    suspend fun pegarRepositorio(): HomeSchema?

}