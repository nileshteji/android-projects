package com.osos.kotlincoroutines

import android.content.Context
import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.osos.kotlincoroutines.databinding.RecyclerBinding


public class RecyclerView(context: Context): RecyclerView.Adapter<com.osos.kotlincoroutines.RecyclerView.Holder>() {

    val context:Context=context;



    class Holder(val recyclerBinding: RecyclerBinding) :RecyclerView.ViewHolder(recyclerBinding.root){
       var _recyclerBinding=recyclerBinding;
    }






    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val recyclerBinding=RecyclerBinding.inflate(LayoutInflater.from(context),parent,false);
        Holder(recyclerBinding)
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder._recyclerBinding.imageView


        TODO("Not yet implemented")
    }
}

