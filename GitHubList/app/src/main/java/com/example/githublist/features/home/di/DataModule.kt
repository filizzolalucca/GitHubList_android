package com.example.githublist.features.home.di

import com.example.githublist.app.network.ApiClientBuilder
import com.example.githublist.features.home.data.network.RepoApi
import com.example.githublist.features.home.data.network.RepoCloudRepository
import com.example.githublist.features.home.data.network.RepoRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule= module {
    //Voce ta criando uma instancia da RepoApi, e criando apenas uma vez para progama inteiro
    single { ApiClientBuilder.createServiceApi(androidApplication(),RepoApi::class.java,forceNetwork = true) }

    //Como voce ja criou a instancia que o RepoCloud repositorio precisava da Api, voce usa o get pois o koin ja criou a depedencia para voce
    factory { RepoCloudRepository(repoApi = get()) as RepoRepository }
    //voce ta criando uma instancia do RepoCloudRepository como se ele fosse um RepoRepository, ai no koin da viewModel ele vai pegar este repositorio normal

}