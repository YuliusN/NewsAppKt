package com.test.mandiri.newsappkt.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.test.mandiri.newsappkt.data.source.SourceDao
import com.test.mandiri.newsappkt.data.source.SourceModel
import com.test.mandiri.newsappkt.network.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SourceRepo private constructor(private val sourceDao: SourceDao){

    fun getSources() = sourceDao.getSource()

    companion object{

        @Volatile private var instance: SourceRepo? = null

        fun getInstance(sourceDao: SourceDao) =
            instance ?: synchronized(this){
                instance ?: SourceRepo(sourceDao).also { instance = it }
            }
    }

    private var request: Request? = null

    init {
        request = RetrofitConn.createService(Request::class.java, URLManager().SOURCES)
    }

    fun getSourceOnline(language:String?) {
        request?.getSource(language)?.enqueue(object : Callback<ResponseSource?> {
            override fun onResponse(
                call: Call<ResponseSource?>?,
                response: Response<ResponseSource?>
            ) {
                if (response.isSuccessful){
                    sourceDao.setSource(response.body()?.getSources())
                }
            }

            override fun onFailure(
                call: Call<ResponseSource?>,
                t: Throwable
            ) {

            }
        })
    }

    fun searchSource(string: String){
    }
}