package com.osos.kotlinapplication

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.osos.kotlinapplication.databinding.ActivityMainBinding

import com.osos.kotlinapplication.db.DataBaseStudent
import com.osos.kotlinapplication.db.Student
import com.osos.kotlinapplication.db.StudentDao
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {







    @SuppressLint("WrongConstant", "CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainBinding:ActivityMainBinding= ActivityMainBinding.inflate(layoutInflater);
        setContentView(mainBinding.root)
        val nileshViewModel=ViewModelProvider(this@MainActivity,nileshFactory("Nilesh Teji is Setting"))
            .get(NileshViewModel::class.java)



        nileshViewModel.getUser().observe(this, Observer {
            nilesh.text=it
        })









    }



    }







