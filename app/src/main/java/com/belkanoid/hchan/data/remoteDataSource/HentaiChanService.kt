package com.belkanoid.hchan.data.remoteDataSource

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Connection
import org.jsoup.Jsoup

object HentaiChanService {

    suspend fun getMangaListByPage(page: Int, sort: String = "newest") =
        withContext(Dispatchers.IO) {
            Log.d("LOLA", mangaPage(page, sort))
            Jsoup.connect(mangaPage(page, sort))
                .method(Connection.Method.GET)
                .execute()
        }

    private const val BASE_URL = "https://hentaichan.live/"
    private fun mangaPage(page: Int, sort: String) = "${BASE_URL}manga/$sort?offset=${page * 20 - 20}"
}