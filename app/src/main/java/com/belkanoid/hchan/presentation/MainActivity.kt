package com.belkanoid.hchan.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.belkanoid.hchan.R
import com.belkanoid.hchan.data.remoteDataSource.HentaiChanService
import com.belkanoid.hchan.data.remoteDataSource.parser.HchanParser
import com.belkanoid.hchan.databinding.ActivityMainBinding
import com.belkanoid.hchan.presentation.adapter.HchanAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {


    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    lateinit var adapter: HchanAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        adapter = HchanAdapter()
        binding.rvMangaList.adapter = adapter
        lifecycleScope.launch(Dispatchers.IO) {
            val response = HentaiChanService.getMangaListByPage(4)
            val rawContent = response.parse().select("div#content")
            val rawMangaList = rawContent.select("div.content_row")
            val list = rawMangaList.map {
                lifecycleScope.async {
                    HchanParser.fetchManga(it)
                }.await()
            }
            withContext(Dispatchers.Main){
                adapter.submitList(list)
            }
            Log.d("LOL", list.joinToString())
        }
    }


}