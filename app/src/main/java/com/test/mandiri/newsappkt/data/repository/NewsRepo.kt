package com.test.mandiri.newsappkt.data.repository

import android.util.Log
import com.test.mandiri.newsappkt.data.news.NewsDao
import com.test.mandiri.newsappkt.network.Request
import com.test.mandiri.newsappkt.network.ResponseNews
import com.test.mandiri.newsappkt.network.RetrofitConn
import com.test.mandiri.newsappkt.network.URLManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NewsRepo private constructor(private var newsDao: NewsDao){

    fun getNews() = newsDao.getNews()
    fun printFirstNews() = newsDao.printoneNews()

    companion object{

        @Volatile private var instance: NewsRepo? = null

        fun getInstance(newsDao: NewsDao) =
            instance ?: synchronized(this){
                instance ?: NewsRepo(newsDao).also { instance = it }
            }
    }

    private var request: Request? = null

    init {
        request = RetrofitConn.createService(Request::class.java, URLManager().TOP_HEADLINE)
    }

    fun getNews(category:String?, source: String?, q:String?) {
        request?.getNews(category, source, q)?.enqueue(object : Callback<ResponseNews?> {
            override fun onResponse(
                call: Call<ResponseNews?>?,
                response: Response<ResponseNews?>
            ) {
                if (response.isSuccessful){
                    newsDao.setNews(response.body()?.getArticles())
                }
            }

            override fun onFailure(
                call: Call<ResponseNews?>,
                t: Throwable
            ) {

            }
        })
    }
}