package com.test.mandiri.newsappkt.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.mandiri.newsappkt.R
import com.test.mandiri.newsappkt.ui.ViewModel.NewsViewModel
import com.test.mandiri.newsappkt.ui.adapter.CategoryAdapter
import com.test.mandiri.newsappkt.util.InjectorUtil
import kotlinx.android.synthetic.main.activity_category.*

class CategoryActivity : AppCompatActivity() {

    lateinit var catAdapter : CategoryAdapter
    var listCat = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        setTitle("Category")

        setupAdapter()
    }

    private fun setupAdapter(){
        listCat.add("General")
        listCat.add("Business")
        listCat.add("Entertainment")
        listCat.add("Health")
        listCat.add("Science")
        listCat.add("Sport")
        listCat.add("Technology")
        catAdapter = CategoryAdapter(this, listCat)
        list_cat.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        list_cat.adapter = catAdapter
    }





}