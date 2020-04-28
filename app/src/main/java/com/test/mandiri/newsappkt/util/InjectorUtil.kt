package com.test.mandiri.newsappkt.util

import com.test.mandiri.newsappkt.data.repository.NewsRepo
import com.test.mandiri.newsappkt.data.repository.SourceRepo
import com.test.mandiri.newsappkt.data.storage.NewsStorage
import com.test.mandiri.newsappkt.data.storage.SourceStorage
import com.test.mandiri.newsappkt.ui.ViewModel.NewsViewModelFactory
import com.test.mandiri.newsappkt.ui.ViewModel.SourceViewModelFactory

object InjectorUtil {
    fun provideNewsModelFactory() : NewsViewModelFactory{
        return NewsViewModelFactory(NewsRepo.getInstance(NewsStorage.getInstance().newsDao))
    }

    fun provideSourceModelFactory() : SourceViewModelFactory{
        return  SourceViewModelFactory(SourceRepo.getInstance(SourceStorage.getInstance().sourceDao))
    }
}