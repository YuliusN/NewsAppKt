package com.test.mandiri.newsappkt.ui.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.mandiri.newsappkt.data.repository.SourceRepo

class SourceViewModelFactory (private val sourceRepo: SourceRepo) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SourceViewModel(sourceRepo) as T
    }
}