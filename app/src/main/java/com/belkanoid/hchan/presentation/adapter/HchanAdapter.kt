package com.belkanoid.hchan.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.belkanoid.hchan.R
import com.belkanoid.hchan.databinding.MangaItemBinding
import com.belkanoid.hchan.domain.entity.MangaInfo
import com.bumptech.glide.Glide

class HchanAdapter: ListAdapter<MangaInfo, HchanViewHolder>(MangaDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HchanViewHolder {
        val hcanViewBinding = MangaItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HchanViewHolder(hcanViewBinding)
    }

    override fun onBindViewHolder(holder: HchanViewHolder, position: Int) {
        val mangaInfo = getItem(position)
        holder.onBind(mangaInfo)
    }

    override fun onViewRecycled(holder: HchanViewHolder) {
        super.onViewRecycled(holder)
        Glide.with(holder.binding.root.context).clear(holder.binding.imageView)
    }
}