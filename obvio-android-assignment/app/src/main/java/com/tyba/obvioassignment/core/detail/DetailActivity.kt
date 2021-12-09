package com.tyba.obvioassignment.core.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.squareup.picasso.Picasso
import com.tyba.obvioassignment.R
import com.tyba.obvioassignment.data.JsonData
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    var jsonData: JsonData? = null
    private  val TAG = "DetailActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        jsonData = intent.getParcelableExtra<JsonData>("object")

        Log.d(TAG, "onCreate: ${jsonData}")

        Picasso.get().load(jsonData?.url).error(R.drawable.ic_launcher_background).into(detailImage)
        detailTitle.text = jsonData?.title
        detail.text = jsonData?.explanation
        copyright.text = jsonData?.copyright


    }
}