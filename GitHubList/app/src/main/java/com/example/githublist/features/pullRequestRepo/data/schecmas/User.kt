package com.example.githublist.features.pullRequestRepo.data.schecmas

import com.google.gson.annotations.SerializedName

data class User (
        @SerializedName("login") val username:String,
        @SerializedName("avatar_url") val imageurl:String
)