package com.tyba.esperapplication

import android.app.Application

class EsperApplication: Application() {



    companion object{
        fun getInstance() = this
    }
}