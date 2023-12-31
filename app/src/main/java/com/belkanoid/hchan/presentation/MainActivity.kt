package com.belkanoid.hchan.presentation

import android.graphics.Canvas
import android.graphics.Rect
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.belkanoid.hchan.data.remoteDataSource.HentaiChanService
import com.belkanoid.hchan.data.remoteDataSource.parser.HchanParser
import com.belkanoid.hchan.databinding.ActivityMainBinding
import com.belkanoid.hchan.domain.entity.MangaInfo
import com.belkanoid.hchan.presentation.adapter.HchanAdapter
import com.belkanoid.hchan.presentation.adapter.HchanViewHolder
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity : AppCompatActivity() {


    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var adapter: HchanAdapter
    private var page = 1

    private val ch = CoroutineExceptionHandler { coroutineContext, throwable ->
        Handler(mainLooper).post {
            Toast.makeText(this@MainActivity, "error", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        adapter = HchanAdapter()
        binding.rvMangaList.adapter = adapter
        binding.floatNext.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO + ch) {
                val list = mangaInfos(++page)
                withContext(Dispatchers.Main) {
                    adapter.submitList(list)
                }
            }
        }

        lifecycleScope.launch(Dispatchers.IO + ch) {
            val list = mangaInfos(page)
            withContext(Dispatchers.Main) {
                adapter.submitList(list)
            }
        }
    }

    private suspend fun mangaInfos(page: Int): List<MangaInfo> {
        val response = HentaiChanService.getMangaListByPage(page)
        val rawContent = response.parse().select("div#content")
        val rawMangaList = rawContent.select("div.content_row")
        val list = rawMangaList.map {
            lifecycleScope.async {
                HchanParser.fetchManga(it)
            }.await()
        }
        return list
    }


}