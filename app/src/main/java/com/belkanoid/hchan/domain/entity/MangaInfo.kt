package com.belkanoid.hchan.domain.entity

data class MangaInfo(
    val id: Long,
    val title: ExtraInfoStyle,
    val previewUrl: String,
    val author: ExtraInfoStyle,
    val parodies: ExtraInfoStyle,
    val translatedBy: ExtraInfoStyle,
    val fame: FameInfoStyle,
    val pageQuantity: String,
    val addDate: String,
    val tagList: List<ExtraInfoStyle>
)
