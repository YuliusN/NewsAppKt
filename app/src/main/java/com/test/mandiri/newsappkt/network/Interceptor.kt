package com.test.mandiri.newsappkt.network

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class Interceptor {
    class CustomInterceptors : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request()
            val newRequest: Request
            newRequest = request.newBuilder()
                .header("Authorization", "3903fd22efab43ea84000aeecebc6cd0")
                .build()
            return chain.proceed(newRequest)
        }
    }
}