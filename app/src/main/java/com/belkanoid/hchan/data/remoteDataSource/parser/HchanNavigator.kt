package com.belkanoid.hchan.data.remoteDataSource.parser

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Connection
import org.jsoup.Jsoup

class HchanNavigator {

    suspend fun getMangaListByPage(page: Int, sort: String = "newest") = withContext(Dispatchers.IO) {
        Jsoup.connect(mangaPage(page, sort))
            .method(Connection.Method.GET)
            .execute()
    }

    companion object {
        private const val BASE_URL = "https://hentaichan.live/"
        fun mangaPage(page: Int, sort: String) = "$BASE_URL/manga/$sort?${page*20 - 20}"
    }
}