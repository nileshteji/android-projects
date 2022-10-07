package com.tyba.esperapplication.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tyba.common.data.Option
import com.tyba.esperapplication.R
import com.tyba.esperapplication.RVListeners.OptionRVClickListener
import kotlinx.android.synthetic.main.recycler_display_layout.view.*
import kotlinx.android.synthetic.main.recycler_option_layout.view.*

class DisplayAdapter constructor(
    var listData: List<Option>
) :
    RecyclerView.Adapter<DisplayAdapter.DisplayRVHolder>() {

    inner class DisplayRVHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(option: Option) {
            itemView.display_name.text = option.name
            Glide.with(itemView).load(option.icon)
                .error(R.drawable.ic_launcher_foreground)
                .into(itemView.display_icon)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DisplayRVHolder  {
        val viewOptions = LayoutInflater.from(parent.context).let {
            it.inflate(R.layout.recycler_display_layout, parent, false)
        }
        return DisplayRVHolder(viewOptions)
    }

    override fun getItemCount(): Int = listData.size

    override fun onBindViewHolder(holder: DisplayRVHolder, position: Int) {
        holder.bind(option = listData[position])
    }
}