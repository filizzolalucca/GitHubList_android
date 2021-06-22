package com.example.githublist.features.home.data.shecmas

import com.google.gson.annotations.SerializedName

data class Owner (
        val login: String,
        @SerializedName("avatar_url")val imageURL: String
)