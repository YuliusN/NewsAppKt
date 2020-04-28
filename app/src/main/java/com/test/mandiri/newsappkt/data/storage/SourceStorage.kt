package com.test.mandiri.newsappkt.data.storage

import com.test.mandiri.newsappkt.data.source.SourceDao

class SourceStorage private constructor(){

    val sourceDao = SourceDao()

    companion object{

        @Volatile private var instance: SourceStorage? = null

        fun getInstance() =
            instance ?: synchronized(this){
                instance ?: SourceStorage().also { instance = it }
            }
    }

}
