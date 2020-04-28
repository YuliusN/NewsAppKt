package com.test.mandiri.newsappkt.network

class URLManager {
    private val BASE_URL = "http://newsapi.org/"
    private val v2 = "v2/"

    val TOP_HEADLINE = BASE_URL + v2 + "top-headlines/"

    val SOURCES = BASE_URL + v2 + "sources/"
}