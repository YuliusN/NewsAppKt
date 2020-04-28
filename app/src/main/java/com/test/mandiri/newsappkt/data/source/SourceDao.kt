package com.test.mandiri.newsappkt.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class SourceDao {
    private val sourceList = mutableListOf<SourceModel>()
    private val sources = MutableLiveData<List<SourceModel>>()

    init {
        sources.value = sourceList
    }

    fun getSource() = sources as LiveData<List<SourceModel>>

    fun setSource(list: ArrayList<SourceModel?>?) {
        sourceList.clear()
        list?.forEach { item ->
            if (item != null) {
                sourceList.add(item)
            }
        }
        sources.value = sourceList
    }


    fun addSource(sourceModel: SourceModel) {
        sourceList.add(sourceModel)
        sources.value = sourceList
    }

    fun clearSource() {
        sourceList.clear()
        sources.value = sourceList
    }

//    fun searchbyString(string: String) : LiveData<List<SourceModel>>{
//
//    }
}