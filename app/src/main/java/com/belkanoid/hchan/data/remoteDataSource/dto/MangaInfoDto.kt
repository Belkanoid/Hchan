package com.belkanoid.hchan.data.remoteDataSource.dto

data class MangaInfoDto(
    val id: Long,
    val title: String,
    val author: String,
    val addDate: String,
    val popularity: Int,
    val tagList: List<String>,
    val translatedBy: String,
    val parodies: String
)