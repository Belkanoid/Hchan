package com.belkanoid.hchan.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.belkanoid.hchan.R
import com.belkanoid.hchan.databinding.MangaItemBinding
import com.belkanoid.hchan.domain.entity.MangaInfo
import com.bumptech.glide.Glide

class HchanViewHolder(val binding: MangaItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun onBind(mangaInfo: MangaInfo) {
        Glide.with(binding.root.context)
            .load(mangaInfo.previewUrl)
            .into(binding.imageView)
        binding.textView.text = mangaInfo.title.value
    }
}