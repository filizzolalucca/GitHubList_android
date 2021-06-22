package com.example.githublist.features.pullRequestRepo.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githublist.R
import com.example.githublist.databinding.ActivityPullRequestListBinding
import com.example.githublist.features.pullRequestRepo.data.schecmas.PullSchemas
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_pull_request_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class PullRequestListActivity : AppCompatActivity() {

    private lateinit var binding:ActivityPullRequestListBinding
    private val viewModel:PullViewModel by viewModel()
    private var adpterPull:AdpterPull?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_pull_request_list)
        binding.lifecycleOwner= this
        configurarRecyclerView()
        configurarObservables()
        val dados: Bundle? = intent.extras
        val name:String? = dados?.getString("nome")
        val repo:String? = dados?.getString("repo")


        if (repo != null && name != null) {
            viewModel.buscarDadosPull(name,repo)
        }
        


    }


    private fun configurarRecyclerView(){
        recylerViewPull.layoutManager = LinearLayoutManager(this)
        recylerViewPull.hasFixedSize()
        recylerViewPull.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))
    }
    private fun definirAdapter(listPullRequest:List<PullSchemas>){
        if(adpterPull==null){
            adpterPull = AdpterPull(listPullRequest)
        }
        recylerViewPull.adapter = adpterPull
    }

    private fun setInitialValue(){

    }

    private fun clickItemPull()
    {


    }



    private fun configurarObservables(){
        viewModel.pullinfo.observe(this, Observer {
            definirAdapter(it)
        })
    }
}