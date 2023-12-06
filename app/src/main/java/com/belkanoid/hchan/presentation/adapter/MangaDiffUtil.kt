package com.belkanoid.hchan.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.belkanoid.hchan.domain.entity.MangaInfo

class MangaDiffUtil: DiffUtil.ItemCallback<MangaInfo>() {
    override fun areItemsTheSame(oldItem: MangaInfo, newItem: MangaInfo): Boolean {
        return oldItem.title.value == newItem.title.value
    }

    override fun areContentsTheSame(oldItem: MangaInfo, newItem: MangaInfo): Boolean {
        return oldItem == newItem
    }
}