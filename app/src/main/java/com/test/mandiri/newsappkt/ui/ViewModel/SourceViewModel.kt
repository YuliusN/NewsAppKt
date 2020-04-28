package com.test.mandiri.newsappkt.ui.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.mandiri.newsappkt.data.repository.SourceRepo
import com.test.mandiri.newsappkt.data.source.SourceModel

class SourceViewModel (private val sourceRepo: SourceRepo) : ViewModel() {

    lateinit var searchList : MutableLiveData<List<SourceModel>>

    fun getSourceOnline(language:String) = sourceRepo.getSourceOnline(language)
    fun getSource() = sourceRepo.getSources()
//
//    }
}