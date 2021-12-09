package com.osos.sliceassignment

import android.animation.Animator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.osos.sliceassignment.databinding.ActivitySplashBinding
import com.osos.sliceassignment.listeners.AnimationListenerImplementation

class SplashActivity : AppCompatActivity() {

    lateinit var splashBinding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(splashBinding.root)
        splashBinding.lottieSearch
            .addAnimatorListener(AnimationListenerImplementation(this@SplashActivity))


    }
}