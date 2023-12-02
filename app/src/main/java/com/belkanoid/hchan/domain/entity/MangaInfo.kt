package com.belkanoid.hchan.domain.entity

data class MangaInfo(
    val id: Long,
    val title: String,
    val author: String,
    val addDate: String,
    val popularity: Int,
    val tagList: List<String>,
    val translatedBy: String,
    val parodies: String
)
