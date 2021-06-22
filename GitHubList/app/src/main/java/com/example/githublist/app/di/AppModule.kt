package com.example.githublist.app.di

import com.example.githublist.features.home.di.HomeModules
import com.example.githublist.features.home.di.uiModule
import com.example.githublist.features.pullRequestRepo.di.PullModules
import org.koin.core.module.Module

object AppModule {

    // Funcao responsavel por pegar todos os modulos do app, ela é chamada na Application do Projeto
    fun getModules():List<Module> = listOf(
        *HomeModules.getModules(),
        *PullModules.getModules()
    )


}