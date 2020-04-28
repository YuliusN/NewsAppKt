package com.test.mandiri.newsappkt.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitConn() {

    companion object{

        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(12, TimeUnit.SECONDS)
            .connectTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .addInterceptor(com.test.mandiri.newsappkt.network.Interceptor.CustomInterceptors())
            .followRedirects(false)
            .followSslRedirects(false)
            .retryOnConnectionFailure(false)
            .cache(null) //new Cache
            .build()

        fun <S> createService(serviceClass: Class<S>, url:String): S {
            return Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
                .create(serviceClass)
        }

    }



}