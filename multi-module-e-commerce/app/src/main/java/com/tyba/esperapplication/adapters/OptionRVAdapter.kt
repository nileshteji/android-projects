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
import kotlinx.android.synthetic.main.recycler_option_layout.view.*

class OptionRVAdapter constructor(
    var listData: List<Option>,
    var feature_id: String,
    var clickListener: OptionRVClickListener
) :
    RecyclerView.Adapter<OptionRVAdapter.OptionRVHolder>() {

    inner class OptionRVHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(option: Option) {
            var featureSelected = feature_id + "|" + option.id
            itemView.option_name.text = option.name
            Glide.with(itemView).load(option.icon)
                .error(R.drawable.ic_launcher_foreground)
                .into(itemView.option_icon)

            itemView.option_switch.setOnCheckedChangeListener { buttonView, isChecked ->

                if(isChecked) {
                    if (!clickListener.checkIfFeatureIncluded(featureSelected,option)) {
                        buttonView.isChecked = false
                        Log.d("Detach", "bind: false ")
                    } else {
                        Log.d("Detach", "bind: true ")
                    }
                }
                else{
                    clickListener.removeSelectedItem(featureSelected,option)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionRVHolder {
        val viewOptions = LayoutInflater.from(parent.context).let {
            it.inflate(R.layout.recycler_option_layout, parent, false)
        }
        return OptionRVHolder(viewOptions)
    }

    override fun getItemCount(): Int = listData.size

    override fun onBindViewHolder(holder: OptionRVHolder, position: Int) {
        holder.bind(option = listData[position])
    }
}