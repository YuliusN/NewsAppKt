package com.test.mandiri.newsappkt.ui.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.mandiri.newsappkt.data.repository.NewsRepo

class NewsViewModelFactory(private val newsRepo: NewsRepo) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(newsRepo) as T
    }
}