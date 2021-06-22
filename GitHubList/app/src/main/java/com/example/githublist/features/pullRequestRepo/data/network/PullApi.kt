package com.example.githublist.features.pullRequestRepo.data.network

import com.example.githublist.features.pullRequestRepo.data.schecmas.PullSchemas
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PullApi {
    @GET("repos/{user}/{repo}/pulls")
    suspend fun pegarPullRequest(@Path("user")user:String,@Path("repo")repo:String):Response<List<PullSchemas>>


}