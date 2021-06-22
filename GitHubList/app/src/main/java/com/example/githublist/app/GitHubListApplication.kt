package com.example.githublist.app

import android.app.Application
import com.example.githublist.app.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GitHubListApplication:Application(){

    override fun onCreate() {
        super.onCreate()
        configureKoin()


    }

    private fun configureKoin(){
        startKoin {
            androidContext(this@GitHubListApplication)
            modules(AppModule.getModules())
        }

    }


}