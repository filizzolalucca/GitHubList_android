package com.example.githublist.features.pullRequestRepo.di

import com.example.githublist.app.network.ApiClientBuilder
import com.example.githublist.features.pullRequestRepo.data.network.PullApi
import com.example.githublist.features.pullRequestRepo.data.network.PullRepository
import com.example.githublist.features.pullRequestRepo.data.network.PullRequestCloudRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataPullModule = module {

    //Agora voce ta criando uma instancia da pull api que vai ser usada no PullRequestCloudRepository
    single { ApiClientBuilder.createServiceApi(androidApplication(),PullApi::class.java,forceNetwork = true) }

    //Criando a instancia do CloudRepository que a viewModel Precisa
    factory { PullRequestCloudRepository(repoPullApi = get()) as PullRepository }
}
