package com.example.githublist.features.home.data.shecmas

import com.google.gson.annotations.SerializedName


//TODO implementar a gson neh


// Nome do repositório, Descrição do Repositório, Nome / Foto do autor, Número de Stars, Número de Forks

data class RepositorioSchema(
        val name:String,
        val description:String,
        val fullName: String,
        val owner: Owner,
        @SerializedName("stargazers_count")val startNumber:Long,
        @SerializedName("forks")val numForks:Long

)
