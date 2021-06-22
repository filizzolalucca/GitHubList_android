package com.example.githublist.features.pullRequestRepo.data.network

import com.example.githublist.app.network.RequestManeger
import com.example.githublist.features.pullRequestRepo.data.schecmas.PullSchemas

class PullRequestCloudRepository(private val repoPullApi: PullApi):PullRepository {
    override suspend fun pegarPullRequests(name: String,repo:String): List<PullSchemas>? {
       return RequestManeger.requestfromApi { repoPullApi.pegarPullRequest(name,repo) }
    }

}