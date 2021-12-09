package com.osos.squareboatapplication.adapters

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.osos.squareboatapplication.R
import com.osos.squareboatapplication.core.welcome.MainActivity
import com.osos.squareboatapplication.model.Article
import kotlinx.android.synthetic.main.recycler_view.view.*

class NewsAdapter(var list: List<Article>, var mainActivity: MainActivity) :
    RecyclerView.Adapter<NewsAdapter.NewsHolder>() {


    class NewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        return NewsHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view, parent, false)
        )
    }


    override fun onBindViewHolder(holder: NewsHolder, position: Int) {

        holder.itemView.layout.setOnClickListener {
            mainActivity.click(list.get(position))
        }

        holder.itemView.source_text.text = list.get(position).source?.name
        holder.itemView.content_text.text = list.get(position).title

        try {
            Glide.with(mainActivity).load(Uri.parse(list.get(position).image))
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.itemView.newImage)
        } catch (e: Exception) {

        }
    }


    override fun getItemCount(): Int {
        return list.size
    }

}