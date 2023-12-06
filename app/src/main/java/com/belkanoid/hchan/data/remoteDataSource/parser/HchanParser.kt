package com.belkanoid.hchan.data.remoteDataSource.parser

import android.util.Log
import com.belkanoid.hchan.domain.entity.ExtraInfoStyle
import com.belkanoid.hchan.domain.entity.FameInfoStyle
import com.belkanoid.hchan.domain.entity.MangaInfo
import org.jsoup.nodes.Element

object HchanParser {
    fun fetchManga(element: Element): MangaInfo {
        val preview = element.selectFirst("div.manga_images img")
            ?.attr("src")?.replace("_thumbs", "") ?: ""
        val title = element.selectFirst("div.manga_row1 h2 a").getExtraInfoStyle()
        val parodies = element.selectFirst("div.manga_row2 h3 a").getExtraInfoStyle()
        val translatedBy = element.selectFirst("div.manga_row2 span a").getExtraInfoStyle()
        val author = element.selectFirst("div.manga_row3 h3 a").getExtraInfoStyle()
        val tagList = element.select("div.genre a").map { it.getExtraInfoStyle() }
        val addDate = element.select("div.manga_row4 .row4_right b").text()
        val rawFame = element.select("div.manga_row4 .row4_left").text().split(",")
            .map { it.filterNot(Char::isLetter).trim() }
        val fame = FameInfoStyle(likes = rawFame[0], views = rawFame[1])
        val pageQuantity = rawFame[2]
        return MangaInfo(
            id = 0,
            title = title,
            previewUrl = preview,
            author = author,
            parodies = parodies,
            translatedBy = translatedBy,
            fame =  fame,
            pageQuantity = pageQuantity,
            addDate = addDate,
            tagList = tagList

        )
    }

    private fun Element?.getExtraInfoStyle() = this?.let {
        ExtraInfoStyle(this.text(), this.attr("href"))
    } ?: ExtraInfoStyle("NaN", "")
}