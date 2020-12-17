package com.arcore.dependencyinjection.di

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arcore.dependencyinjection.R
import dagger.Component

import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
   lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)



    }
}