package com.example.githublist.features.pullRequestRepo.di


import org.koin.core.module.Module

object PullModules {

        fun getModules():Array<Module> = arrayOf(uiPullModule, dataPullModule)

}