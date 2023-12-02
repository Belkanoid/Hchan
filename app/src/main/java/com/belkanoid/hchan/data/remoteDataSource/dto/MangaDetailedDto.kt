package com.belkanoid.hchan.data.remoteDataSource.dto

data class MangaDetailedDto(
    val id: Long,
    val title: String,
    val author: String,
    val addDate: String,
    val popularity: Int,
    val pageQuantity: Int,
    val pagesList: List<String>,
    val chapterList: List<String>,
    val tagList: List<String>,
    val translatedBy: String,
    val parodies: String
)