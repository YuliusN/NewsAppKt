package com.test.mandiri.newsappkt.data.storage

import com.test.mandiri.newsappkt.data.news.NewsDao

class NewsStorage private constructor(){

    val newsDao = NewsDao()

    companion object{

        @Volatile private var instance: NewsStorage? = null

        fun getInstance() =
            instance ?: synchronized(this){
                instance ?: NewsStorage().also { instance = it }
            }
    }

}