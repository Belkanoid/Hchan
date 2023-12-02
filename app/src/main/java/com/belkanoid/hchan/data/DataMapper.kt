package com.belkanoid.hchan.data

import com.belkanoid.hchan.data.remoteDataSource.dto.MangaDetailedDto
import com.belkanoid.hchan.data.remoteDataSource.dto.MangaInfoDto
import com.belkanoid.hchan.domain.entity.MangaDetailed
import com.belkanoid.hchan.domain.entity.MangaInfo

object DataMapper {

    fun MangaInfoDto.mapMangaInfoDtoToMangaInfo() = MangaInfo(
        id = this.id,
        title = this.title,
        author = this.author,
        addDate = this.addDate,
        popularity = this.popularity,
        tagList = this.tagList,
        translatedBy = this.translatedBy,
        parodies = this.parodies,
    )

    fun MangaDetailedDto.mapMangaDetailedDtoToMangaDetailed() = MangaDetailed(
        id = this.id,
        title = this.title,
        author = this.author,
        addDate = this.addDate,
        popularity = this.popularity,
        pageQuantity = this.pageQuantity,
        pagesList = this.pagesList,
        chapterList = this.chapterList,
        tagList = this.tagList,
        translatedBy = this.translatedBy,
        parodies = this.parodies,
    )
}