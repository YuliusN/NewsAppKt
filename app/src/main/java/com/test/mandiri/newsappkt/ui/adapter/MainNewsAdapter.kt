package com.test.mandiri.newsappkt.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.test.mandiri.newsappkt.R
import com.test.mandiri.newsappkt.data.news.NewsModel
import com.test.mandiri.newsappkt.ui.MainWebView
import kotlinx.android.synthetic.main.adapter_news.view.*
import java.util.*

class MainNewsAdapter(
    var context: Context,
    var list: ArrayList<NewsModel>) : RecyclerView.Adapter<MainNewsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.adapter_news, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val news: NewsModel = list.get(position)
        holder.bindItems(list.get(position))
        holder.itemView.setOnClickListener(View.OnClickListener {
            val i = Intent(context, MainWebView::class.java)
            i.putExtra("url", news.url)
            i.putExtra("title", news.title)
            context.startActivity(i)
        })
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        fun bindItems(news: NewsModel){
            Glide.with(context).load(news.urlToImage).into(itemView.image_news)
            itemView.tv_title.setText(news.title)
            itemView.tv_description.setText(news.description)
            itemView.tv_source.setText(news.newsSource?.name)
        }
    }



}
