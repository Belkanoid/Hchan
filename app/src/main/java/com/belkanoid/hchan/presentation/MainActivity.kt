package com.belkanoid.hchan.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.belkanoid.hchan.R
import com.belkanoid.hchan.data.remoteDataSource.parser.HchanNavigator
import com.belkanoid.hchan.domain.entity.ExtraInfoStyle
import com.belkanoid.hchan.domain.entity.FameInfoStyle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycleScope.launch(Dispatchers.IO) {
            val response = HchanNavigator().getMangaListByPage(1)
            val rawContent = response.parse().select("div#content")
            val rawMangaList = rawContent.select("div.content_row")
            rawMangaList.map {
                fetchManga(it)
            }
        }
    }

    private fun fetchManga(element: Element) {
        Log.d("MainActivity", element.toString())
        val title = element.selectFirst("div.manga_row1 h2 a").getExtraInfoStyle()
        val parodies = element.selectFirst("div.manga_row2 h3 a").getExtraInfoStyle()
        val translatedBy = element.selectFirst("div.manga_row2 span a").getExtraInfoStyle()
        val author = element.selectFirst("div.manga_row3 h3 a").getExtraInfoStyle()
        val tagList = element.select("div.genre a").map { it.getExtraInfoStyle() }
        val rawFame = element.select("div.manga_row4 .row4_left").text().split(",")
            .map { it.filterNot(Char::isLetter).trim() }
        val fame = FameInfoStyle(likes = rawFame[0], views = rawFame[1])
        val pageQuantity = rawFame[2]


    }

    fun Element?.getExtraInfoStyle() = ExtraInfoStyle(this!!.text(), this.attr("href"))
}