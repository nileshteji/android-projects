/*
 * Copyright (c) 2020 This Code is Written by Nilesh
 */

package com.osos.rxjavausingretrofit

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(context: Context): RecyclerView.Adapter<RecyclerHolder>() {

    val context:Context=context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerHolder {
        var layoutInflater: View = LayoutInflater.from(context).inflate(R.layout.activity_main,parent,false)
        return RecyclerHolder(layoutInflater)
    }

    override fun getItemCount(): Int {
    return 1
    }

    override fun onBindViewHolder(holder: RecyclerHolder, position: Int) {

    }

}