package com.osos.appdeskservice.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.osos.appdeskservice.R
import com.osos.appdeskservice.preferences.PreferenceClass
import kotlinx.android.synthetic.main.activity_main.*

class WelcomeActivity : AppCompatActivity() {


    lateinit var preferenceClass: PreferenceClass


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        preferenceClass = PreferenceClass(this)


        if (preferenceClass.getUsername() != null) {
            move()
        }

        // click listeners
        submit_username.setOnClickListener() {
            if (user_name.text.isNullOrEmpty()) {
                user_name.setError("Please Enter Some User Name to Continue")
            } else {
                preferenceClass.insertUserName(user_name.text.toString())
                move()
            }

        }

    }

    fun move() {
        Intent(this, MainActivity::class.java).apply {
            startActivity(this)
        }
    }

}