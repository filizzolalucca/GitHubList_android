package com.example.githublist.features.pullRequestRepo.di

import com.example.githublist.features.pullRequestRepo.ui.PullViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiPullModule = module {

    viewModel {
        PullViewModel(pullRepository = get())
    }
}