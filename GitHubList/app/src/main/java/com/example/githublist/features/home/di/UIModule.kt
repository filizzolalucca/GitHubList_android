package com.example.githublist.features.home.di

import com.example.githublist.features.home.ui.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val uiModule = module{

    //O Koin vai entregar a depedencia que voce precisa que foi criada como um facotry no DataModule,
    // isto é toda vez que a viewModel precisar, vai ser criada uma nova dependecia.
    viewModel {
        HomeViewModel(repo = get())
    }
}