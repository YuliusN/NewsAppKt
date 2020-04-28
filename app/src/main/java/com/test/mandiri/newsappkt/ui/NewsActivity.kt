package com.test.mandiri.newsappkt.ui

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.mandiri.newsappkt.R
import com.test.mandiri.newsappkt.data.news.NewsModel
import com.test.mandiri.newsappkt.ui.ViewModel.NewsViewModel
import com.test.mandiri.newsappkt.ui.ViewModel.NewsViewModelFactory
import com.test.mandiri.newsappkt.ui.adapter.MainNewsAdapter
import com.test.mandiri.newsappkt.util.InjectorUtil
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity() {

    lateinit var newsAdapter: MainNewsAdapter
    var listdata = ArrayList<NewsModel>()
    var category:String? = null
    var source:String? = null
    var nameSource: String? = null
    var factory : NewsViewModelFactory? = null
    var viewModel: NewsViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        if (intent.hasExtra("category")) category = intent.getStringExtra("category")
        if (intent.hasExtra("source")) {
            source = intent.getStringExtra("source")
            nameSource = intent.getStringExtra("name")
        }

        if (category == null) {
            setTitle(nameSource)
        } else {
            title = category
            category = category!!.toLowerCase()
        }


        newsAdapter = MainNewsAdapter(this, listdata)
        list_news.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        list_news.adapter = newsAdapter


        factory = InjectorUtil.provideNewsModelFactory()
        viewModel = ViewModelProvider(this, factory!!).get(NewsViewModel::class.java)

        Log.i("click", "create " + search_text.text.toString())
        initializeUI()

        search_text.setOnKeyListener{view, i, keyEvent ->
            Log.i("click", "sebelum dsini= " + search_text.text.toString())
            if (keyEvent.action == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_ENTER){
                Log.i("click", "isi = " + search_text.text.toString())
                viewModel?.getNewsOnline(category, source, search_text.text.toString())
                true
            }
            else {
                false
            }
        }
    }

    private fun initializeUI(){

        viewModel?.getNewsOnline(category, source, "")
        viewModel?.getNews()?.observe(this, Observer { news ->
            news.forEach { item ->
                listdata.add(listdata.size, item)
                newsAdapter.notifyDataSetChanged()
            }
        })
    }
}