package com.belkanoid.hchan.presentation.adapter

import android.service.credentials.Action
import android.util.Log
import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.belkanoid.hchan.R
import com.belkanoid.hchan.databinding.MangaItemBinding
import com.belkanoid.hchan.domain.entity.MangaInfo
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class HchanViewHolder(val binding: MangaItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun onBind(mangaInfo: MangaInfo,) {
        Glide.with(binding.root.context)
            .load(mangaInfo.previewUrl)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.imageView)


        binding.imageView.setOnLongClickListener {
            binding.hover.visibility = View.VISIBLE
            true
        }

        with(binding) {
            textView.text = mangaInfo.title.value
            tvAddDate.text = mangaInfo.addDate
            tvAuthor.text = mangaInfo.author.value
            tvParodies.text = mangaInfo.parodies.value
            tvTags.text = mangaInfo.tagList.map {it.value.replace("_", " ")}
                .reduce{acc, s -> acc.plus(", ") + s }
        }
    }
}