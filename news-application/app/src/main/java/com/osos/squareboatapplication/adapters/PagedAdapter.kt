package com.osos.squareboatapplication.adapters

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.transition.Hold
import com.osos.squareboatapplication.R
import com.osos.squareboatapplication.core.welcome.MainActivity
import com.osos.squareboatapplication.model.Article
import kotlinx.android.synthetic.main.recycler_view.view.*


class PagedAdapter(val mainActivity: MainActivity) : PagedListAdapter<Article, PagedAdapter.Holder> (diffCallback) {


    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.layout.setOnClickListener {
            mainActivity.click(getItem(position)!!)
        }

        holder.itemView.source_text.text = getItem(position)!!.source?.name
        holder.itemView.content_text.text = getItem(position)!!.title

        try {
            Glide.with(mainActivity).load(Uri.parse( getItem(position)!!.image) )
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.itemView.newImage)
        } catch (e: Exception) {

        }
    }

    companion object {

        val diffCallback = object : DiffUtil.ItemCallback<Article>() {
            override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
                return true
            }

        }
    }



}

