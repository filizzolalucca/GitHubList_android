package com.example.githublist.features.pullRequestRepo.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githublist.databinding.PullItemBinding
import com.example.githublist.features.pullRequestRepo.data.schecmas.PullSchemas

class AdpterPull(private val pulls:List<PullSchemas>):RecyclerView.Adapter<AdpterPull.AdpterPullVH>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdpterPullVH {
        //criado para que possamos criar as nossas vizualizaçoes, mas nao vizualizalas de fato
        val itemBinding = PullItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return AdpterPullVH(itemBinding)
    }

    override fun getItemCount(): Int {
        return pulls.size
    }

    override fun onBindViewHolder(holder: AdpterPullVH, position: Int) {
        holder.binding.pullrequest=pulls[position]
    }



//criacao dov iew Holder
    class AdpterPullVH(itemBinding: PullItemBinding):RecyclerView.ViewHolder(itemBinding.root){
        val binding = itemBinding
    }

}