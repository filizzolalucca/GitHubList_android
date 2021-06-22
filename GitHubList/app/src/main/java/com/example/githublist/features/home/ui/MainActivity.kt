package com.example.githublist.features.home.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githublist.R
import com.example.githublist.databinding.ActivityMainBinding
import com.example.githublist.features.home.data.shecmas.RepositorioSchema
import com.example.githublist.features.pullRequestRepo.ui.PullRequestListActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val homeViewModel: HomeViewModel by viewModel()
    private var adapterRepositorios: AdapterRepo? = null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        configurarRecyclerView()
        configurarObservables()
        homeViewModel.buscarDados()










    }

    private fun configurarRecyclerView(){
        recylerViewRepo.layoutManager = LinearLayoutManager(this)
        recylerViewRepo.hasFixedSize()
        recylerViewRepo.addItemDecoration(DividerItemDecoration(this,LinearLayout.VERTICAL))
    }

    private fun definirAdpter(repositorioSchema: List<RepositorioSchema>){
        if(adapterRepositorios==null){
            //devo passar a lista por parametro
            adapterRepositorios=AdapterRepo(repositorioSchema,::repoItemClicked)
        }
        recylerViewRepo.adapter = adapterRepositorios
    }

    private fun repoItemClicked(nome:String,repoName:String){
        intent = Intent(this, PullRequestListActivity::class.java)
        intent.putExtra("nome","$nome")
        intent.putExtra("repo","$repoName")
        startActivity(intent)
    }

    private fun configurarObservables(){
        homeViewModel.repoInfo.observe(this, Observer {


            definirAdpter(it.items)


        })


    }

}