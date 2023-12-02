package com.belkanoid.hchan.data.repository

import com.belkanoid.hchan.data.remoteDataSource.HentaiChanService
import com.belkanoid.hchan.domain.entity.MangaDetailed
import com.belkanoid.hchan.domain.entity.MangaInfo
import com.belkanoid.hchan.domain.repository.MangaRepository

class MangaRepositoryImpl(
    val service: HentaiChanService
): MangaRepository {
    override suspend fun getManga(id: String): MangaDetailed {
        TODO("Not yet implemented")
    }

    override suspend fun getPageManga(page: Int): List<MangaInfo> {
        TODO("Not yet implemented")
    }

    override suspend fun getTranslatedMangaBy(id: String): List<MangaInfo> {
        TODO("Not yet implemented")
    }

    override suspend fun getRelated(id: String): List<MangaInfo> {
        TODO("Not yet implemented")
    }
}