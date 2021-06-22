package com.example.githublist.features.home.di

import org.koin.core.module.Module

object HomeModules {
    fun getModules():Array<Module> = arrayOf(uiModule, dataModule)
}