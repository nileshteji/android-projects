package com.osos.hiltapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject
import javax.inject.Singleton


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    @Inject
    lateinit var someClass: SomeClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: ${someClass.doThing()}")

    }
}



class SomeClass @Inject constructor(private val getDependency: getDependency ) {
     fun doThing() = "Look I did Thing ${getDependency.get()}"
}



class serviceIMP @Inject constructor(): service {
    override fun doThing(): String {
        TODO("Not yet implemented")
    }

}

interface service {
    fun doThing():String
}


class getDependency @Inject constructor(){
    fun get() =" Nilesh Teji"
}



