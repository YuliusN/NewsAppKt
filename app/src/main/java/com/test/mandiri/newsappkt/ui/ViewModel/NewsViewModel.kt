package com.test.mandiri.newsappkt.ui.ViewModel

import androidx.lifecycle.ViewModel
import com.test.mandiri.newsappkt.data.repository.NewsRepo

class NewsViewModel (private val newsRepo: NewsRepo)  : ViewModel(){

    fun getNewsOnline(category: String?, source:String?, q:String?) = newsRepo.getNews(category, source, q)
    fun getNews() = newsRepo.getNews()
}