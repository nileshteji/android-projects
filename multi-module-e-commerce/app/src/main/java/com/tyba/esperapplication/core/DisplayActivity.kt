package com.tyba.esperapplication.core

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.tyba.common.constants.Constants
import com.tyba.common.data.Option
import com.tyba.esperapplication.R
import com.tyba.esperapplication.adapters.DisplayAdapter
import kotlinx.android.synthetic.main.activity_display.*

class DisplayActivity : AppCompatActivity() {
    private val TAG = "DisplayActivity"
    lateinit  var selectedOption: List<Option>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        selectedOption = intent.getParcelableArrayListExtra<Option>(Constants.INTENT_KEY)!!

        display_recycler.apply {
            adapter = DisplayAdapter(selectedOption)
            layoutManager = LinearLayoutManager(context).apply {
                orientation = LinearLayoutManager.VERTICAL
            }
        }
    }
}