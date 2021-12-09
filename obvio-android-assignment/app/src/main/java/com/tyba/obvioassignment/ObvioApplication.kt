package com.tyba.obvioassignment

import android.app.Application
import android.content.Context

class ObvioApplication : Application() {

    companion object {
        private lateinit var context: Context
        fun getIntance(): Context = context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }


}