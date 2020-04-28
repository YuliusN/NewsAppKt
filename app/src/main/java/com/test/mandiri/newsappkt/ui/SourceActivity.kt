package com.test.mandiri.newsappkt.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.mandiri.newsappkt.R
import com.test.mandiri.newsappkt.data.source.SourceModel
import com.test.mandiri.newsappkt.ui.ViewModel.SourceViewModel
import com.test.mandiri.newsappkt.ui.adapter.SourceAdapter
import com.test.mandiri.newsappkt.util.InjectorUtil
import kotlinx.android.synthetic.main.activity_news.*
import kotlinx.android.synthetic.main.activity_source.*

class SourceActivity : AppCompatActivity() {

    lateinit var sourceAdapter: SourceAdapter
    var listsource = ArrayList<SourceModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_source)
        setTitle("Choose source")

        sourceAdapter = SourceAdapter(this, listsource)
        list_sources.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        list_sources.adapter = sourceAdapter

        initializeUI()
    }

    private fun initializeUI(){
        val factory = InjectorUtil.provideSourceModelFactory()
        val viewModel = ViewModelProvider(this, factory).get(SourceViewModel::class.java)

        viewModel.getSourceOnline("en")
        viewModel.getSource().observe(this, Observer { source ->
            listsource.addAll(source)
            sourceAdapter.notifyDataSetChanged()
        })
    }
}