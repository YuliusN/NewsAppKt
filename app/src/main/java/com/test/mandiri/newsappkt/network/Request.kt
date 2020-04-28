package com.test.mandiri.newsappkt.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Request {
    @GET(".")
    fun getNews(
        @Query("category") category: String?,
        @Query("sources") sources: String?,
        @Query("q") text: String?
    ): Call<ResponseNews>

    @GET(".")
    fun getSource(
        @Query("language") input: String?
    ): Call<ResponseSource?>?
}