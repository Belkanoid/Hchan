package com.belkanoid.hchan.domain.entity

data class MangaDetailed(
    val id: Long,
    val title: String,
    val author: ExtraInfoStyle,
    val parodies: ExtraInfoStyle,
    val translatedBy: ExtraInfoStyle,
    val fame: FameInfoStyle,
    val addDate: String,
    val tagList: List<String>,
    val pageQuantity: Int,
    val pagesList: List<String>,
    val relatedMangaList: List<String>,
)