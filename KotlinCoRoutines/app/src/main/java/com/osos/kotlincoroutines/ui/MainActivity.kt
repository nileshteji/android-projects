package com.osos.kotlincoroutines.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.osos.kotlincoroutines.R
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Dispatchers.Main -> this coroutine runs on the main thread useful when we have to update a UI Element
        // Dispatchers.IO -> this coroutine runs on another thread useful for network and database call
        // Dispatchers.Default -> to Do Complex Calculations
        // Dispatchers.UnConfined -> an run on any thread
        // new SingleThreadedContext -> Create New thread
        // withContext to change the thread of the coroutine


        val channel = Channel<String>()

        lifecycleScope.launch(Dispatchers.IO) {
            channel.send("Nilesh")
            channel.send("Teji")
            channel.send("is")
            channel.send("in")
            channel.send("the")
            channel.send("channel")
        }

        lifecycleScope.launch(Dispatchers.IO) {
           repeat(6){
             println(channel.receive())
           }
        }

    }






//    fun timeOut() {
//
//        lifecycleScope.launch {
//            val job = withTimeoutOrNull(2000) {
//                timeOutOne();
//            }
//
//            when (job) {
//                null -> withContext(Dispatchers.Main) {
//                    Toast.makeText(this@MainActivity, "Time Out", LENGTH_LONG).show()
//                }
//                else -> withContext(Dispatchers.Main) {
//                    Toast.makeText(this@MainActivity, "CoRoutine Done", LENGTH_LONG).show()
//                }
//            }
//        }
//
//    }
//
//
//    suspend fun timeOutOne() {
//        delay(1000)
//
//    }
//
//
//    fun exceptionHandle() {
//        var handler: CoroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
//            println("Exceptions is Thrown")
//        }
//
//        CoroutineScope(Dispatchers.IO).launch(handler) {
//            //JOB----1
//
//            val JOB = withTimeoutOrNull(2000){
//                var nilesh: String = network2();
//                Log.d(TAG, "main:$nilesh ")
//            }
//
//
//        }
//    }
//
//
//    suspend fun network2(): String {
//        delay(3000)
//        return "Nilesh Teji"
//    }
}