package com.example.githublist.features.home.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githublist.app.utils.commum.BaseViewModel
import com.example.githublist.features.home.data.network.RepoRepository
import com.example.githublist.features.home.data.shecmas.HomeSchema
import com.example.githublist.features.home.data.shecmas.RepositorioSchema

class HomeViewModel(private val repo:RepoRepository):BaseViewModel(){

    private val _repoInfos= MutableLiveData<HomeSchema>()
    val repoInfo: LiveData<HomeSchema> = _repoInfos



     fun buscarDados(){
        doAsyncWork {
            _repoInfos.value = repo.pegarRepositorio()
        }

    }



}