package com.osos.appdeskservice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.osos.appdeskservice.R
import com.osos.appdeskservice.data.Daily
import kotlinx.android.synthetic.main.report_layout.view.*
import java.util.*

class SevenReport(var list: List<Daily>) : RecyclerView.Adapter<SevenReport.Holder>() {

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            LayoutInflater.from(parent.context).inflate(R.layout.report_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        val sdf = java.text.SimpleDateFormat("dd-MM-yyyy")
        val date = Date(list.get(position).dt * 1000)
        holder.itemView.date.text = sdf.format(date)
        holder.itemView.temp.text = list.get(position).temp.day.toString() + "°"
    }

    override fun getItemCount(): Int {
        return list.size
    }

}