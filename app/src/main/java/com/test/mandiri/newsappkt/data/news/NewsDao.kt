package com.test.mandiri.newsappkt.data.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class NewsDao {
    private val newsList = mutableListOf<NewsModel>()
    private val news = MutableLiveData<List<NewsModel>>()

    init {
        news.value = newsList
    }

    fun getNews() = news as LiveData<List<NewsModel>>
    fun setNews(listnews: ArrayList<NewsModel?>?){
        newsList.clear()
        listnews?.forEach { item ->
            if (item != null) {
                newsList.add(item)
            }
        }
        news.value = newsList
    }
    fun addNews(newsItem : NewsModel){
        newsList.add(newsItem)
        news.value = newsList
    }
    fun printoneNews(): String? {
        return newsList[0].title
    }
}