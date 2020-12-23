package com.osos.hiltapplication

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class CustomListAdapter : ListAdapter<Int, CustomListAdapter.ViewHolder>(object : DiffUtil.ItemCallback<Int>() {

    override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean {
        TODO("Not yet implemented")
    }

}) {


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(a:Int){

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        TODO("Not yet implemented")
        holder.bind(position)
    }


}