package com.tyba.obvioassignment.core.Home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.tyba.obvioassignment.R
import com.tyba.obvioassignment.adapters.ImageAdapter
import com.tyba.obvioassignment.core.detail.DetailActivity
import com.tyba.obvioassignment.data.JsonData
import com.tyba.obvioassignment.utils.rvClicListener
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() , rvClicListener {

    val homeViewModel : HomeViewModel by viewModels()

    lateinit var rv : ImageAdapter
    lateinit var jsonList: List<JsonData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        homeViewModel.getJsonList()

        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = linearLayoutManager

        homeViewModel.JsonList.observe(this){ listJson ->
            jsonList = listJson
            rv = ImageAdapter(this,listJson)
            recyclerView.adapter = rv
        }

    }

    override fun click(a: Int) {
        Log.d("Detail", "${jsonList[a]}")
        Intent(this,DetailActivity::class.java).apply {
            putExtra("object",jsonList[a])
            startActivity(this)
        }
    }

    override fun bookMark(position: Int,isBookMark:Boolean) {
        homeViewModel.bookMarkTheItem(position,isBookMark)
    }


}