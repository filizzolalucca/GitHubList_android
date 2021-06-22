package com.example.githublist.features.home.data.shecmas

data class HomeSchema(
        val totalCount: Long,
        val incompleteResults: Boolean,
        val items: List<RepositorioSchema>
)