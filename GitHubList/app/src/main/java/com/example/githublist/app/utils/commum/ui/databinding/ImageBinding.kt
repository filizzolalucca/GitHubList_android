package com.example.githublist.app.utils.commum.ui.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.githublist.R


object ImageBinding {

    //Função responsável por converter as imagens que recebemos das requisicoes


    @JvmStatic
    @BindingAdapter("imageUrlProfile")
    fun setImageUrlProfile(imageView: ImageView, url: String?) {
        if (!url.isNullOrBlank())
           Glide.with(imageView).load(url).error(R.drawable.ic_baseline_person_48).into(imageView)
        else Glide.with(imageView).load(R.drawable.ic_baseline_person_48).into(imageView)
    }

}