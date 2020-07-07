/*
 * Copyright (c) 2020 This Code is Written by Nilesh
 */

package com.osos.rxjavausingretrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity2 : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val user:User?=User("1","2","Nlesh","true")
        var intent: Intent? =Intent(this,MainActivity::class.java);
        startActivity(intent)
    }




}