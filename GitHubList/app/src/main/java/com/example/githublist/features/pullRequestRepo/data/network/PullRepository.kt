package com.example.githublist.features.pullRequestRepo.data.network

import com.example.githublist.features.pullRequestRepo.data.schecmas.PullSchemas

interface PullRepository {
    suspend fun pegarPullRequests(name:String,repo:String) :List<PullSchemas>?
}