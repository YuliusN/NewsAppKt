package com.test.mandiri.newsappkt.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.mandiri.newsappkt.R
import com.test.mandiri.newsappkt.data.source.SourceModel
import com.test.mandiri.newsappkt.ui.NewsActivity
import kotlinx.android.synthetic.main.category_name.view.*

class SourceAdapter(val context: Context, var list:ArrayList<SourceModel>) : RecyclerView.Adapter<SourceAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.category_name, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binditems(list.get(position))
        holder.itemView.setOnClickListener(View.OnClickListener {
            val intent = Intent(context, NewsActivity::class.java)
            intent.putExtra("source", list.get(position).id);
            intent.putExtra("name", list.get(position).name);
            context.startActivity(intent)
        })

    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        fun binditems(sourceModel: SourceModel){
            itemView.category_name.setText(sourceModel.name)
        }
    }


}