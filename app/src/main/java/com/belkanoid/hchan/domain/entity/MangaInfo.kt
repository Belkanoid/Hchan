package com.belkanoid.hchan.domain.entity

data class MangaInfo(
    val id: Long,
    val title: String,
    val author: ExtraInfoStyle,
    val parodies: ExtraInfoStyle,
    val translatedBy: ExtraInfoStyle,
    val fame: FameInfoStyle,
    val pageQuantity: Int,
    val addDate: String,
    val tagList: List<String>
)
