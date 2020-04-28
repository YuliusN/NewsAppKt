package com.test.mandiri.newsappkt.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.test.mandiri.newsappkt.data.news.NewsModel

data class ResponseNews (
    @SerializedName("status")
    private var status: String? = null,

    @SerializedName("totalResults")
    private val totalResults: Int? = null,

    @SerializedName("articles")
    private var articles: ArrayList<NewsModel?>? = null

){
    fun getArticles() : ArrayList<NewsModel?>? {
        return this.articles
    }
}