package com.belkanoid.hchan.domain.repository

import com.belkanoid.hchan.domain.entity.MangaDetailed
import com.belkanoid.hchan.domain.entity.MangaInfo

interface MangaRepository {
    //Remote
    suspend fun getManga(id: String): MangaDetailed

    suspend fun getPageManga(page: Int): List<MangaInfo>

    suspend fun getTranslatedMangaBy(id: String): List<MangaInfo>

    suspend fun getRelated(id: String): List<MangaInfo>

    //Local
//    suspend fun cacheManga(manga: MangaDetailed): Boolean
//
//    suspend fun getCachedManga(id: String): MangaDetailed
}