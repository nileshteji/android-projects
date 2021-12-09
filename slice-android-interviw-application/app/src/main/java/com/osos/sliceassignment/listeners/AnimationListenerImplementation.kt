package com.osos.sliceassignment.listeners

import android.animation.Animator
import android.content.Intent
import android.widget.Toast
import com.osos.sliceassignment.R
import com.osos.sliceassignment.search.SearchActivity
import com.osos.sliceassignment.SplashActivity




class AnimationListenerImplementation(var splashActivity: SplashActivity) : Animator.AnimatorListener {
    override fun onAnimationStart(p0: Animator?) {
        Toast.makeText(splashActivity, R.string.welcome,Toast.LENGTH_LONG).show();

    }
    override fun onAnimationEnd(p0: Animator?) {
        Intent(splashActivity, SearchActivity::class.java).apply {
            splashActivity.startActivity(this)
        }
    }

    override fun onAnimationCancel(p0: Animator?) {
    }
    override fun onAnimationRepeat(p0: Animator?) {

    }
}