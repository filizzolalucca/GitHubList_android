package com.example.githublist.features.pullRequestRepo.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.githublist.app.utils.commum.BaseViewModel
import com.example.githublist.features.pullRequestRepo.data.network.PullRepository
import com.example.githublist.features.pullRequestRepo.data.schecmas.PullSchemas

class PullViewModel(private val pullRepository: PullRepository):BaseViewModel(){


    private val _pullinfos = MutableLiveData<List<PullSchemas>>()
    val pullinfo:LiveData<List<PullSchemas>> = _pullinfos


    fun buscarDadosPull(nome:String,repo:String){
        doAsyncWork {
            _pullinfos.value=pullRepository.pegarPullRequests(nome,repo)
        }
    }
}