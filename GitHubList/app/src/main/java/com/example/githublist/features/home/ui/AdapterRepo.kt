package com.example.githublist.features.home.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githublist.app.utils.commum.extensions.setOnSingleClickListener
import com.example.githublist.databinding.RepoItemBinding
import com.example.githublist.features.home.data.shecmas.RepositorioSchema

class AdapterRepo(private val repositorios:List<RepositorioSchema>,
                  private val itemClicked:(String,String) -> Unit
):RecyclerView.Adapter<AdapterRepo.AdapterVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterVH {
        //criado para que possamos criar as nossas vizualizaçoes, mas nao vizualizalas de fato
        var itemBinding = RepoItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        val repoHV = AdapterVH(itemBinding)
        itemBinding.root.setOnSingleClickListener {
                itemClicked(repositorios[repoHV.adapterPosition].owner.login,repositorios[repoHV.adapterPosition].name)



        }
        return repoHV

    }

    override fun getItemCount(): Int {
        return repositorios.size
    }

    override fun onBindViewHolder(holder: AdapterVH, position: Int) {
        holder.binding.repositorio = repositorios[position]
    }
    class AdapterVH(itemBinding: RepoItemBinding):RecyclerView.ViewHolder(itemBinding.root){
        val binding = itemBinding

    }


}


