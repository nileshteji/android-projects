package com.tyba.esperapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tyba.common.changeData
import com.tyba.common.data.Feature
import com.tyba.esperapplication.R
import com.tyba.esperapplication.RVListeners.OptionRVClickListener
import kotlinx.android.synthetic.main.recycler_feature_layout.view.*

class FeatureAdapter constructor(var clickListener:OptionRVClickListener) : RecyclerView.Adapter<FeatureAdapter.FeatureHolder>() {

    var featureList: MutableList<Feature> = mutableListOf()


    inner class FeatureHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(featureParam: Feature) {

            itemView.feature_name.text = featureParam.name
            itemView.option_recycler.apply {
                adapter = OptionRVAdapter(featureParam.options,featureParam.id,clickListener)
                layoutManager = LinearLayoutManager(context).apply {
                    orientation = LinearLayoutManager.VERTICAL
                }
            }

            itemView.option_recycler.visibility = View.VISIBLE

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeatureHolder {
        val featureView: View = LayoutInflater.from(parent.context).let {
            it.inflate(R.layout.recycler_feature_layout, parent, false)
        }
        return FeatureHolder(featureView)
    }

    fun submitList(list: List<Feature>) {
        featureList.changeData(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = featureList.size

    override fun onBindViewHolder(holder: FeatureHolder, position: Int) {
        holder.bind(featureList[position])
    }
}