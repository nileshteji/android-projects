package com.osos.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {
    val TAG="MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Dispatchers.Main -> this coroutine runs on the main thread useful when we have to update a UI Element
        // Dispatchers.IO -> this coroutine runs on another thread useful for network and database call
        // Dispatchers.Default -> to Do Complex Calculations
        // Dispatchers.UnConfined -> an run on any thread
        // new SingleThreadedContext -> Create New thread
        // withContext to change the thread of the coroutine



//
//        // very important work
//        GlobalScope.launch(Dispatchers.IO)
//        {
//            var dummy=network();
//            withContext(Dispatchers.Main){
//                text.text=dummy;
//            }
//
//        }


        // this is when the network call is made one after one
        GlobalScope.launch(Dispatchers.IO) {
            val time=measureTimeMillis {
                network();
                network2();
            }
            Log.d(TAG, "Time Taken is $time")
        }

        // making network calls async
        GlobalScope.launch(Dispatchers.IO) {
            val time= measureTimeMillis {
               val job= launch {
                     network()
                }
                val job2=launch {
                    network2()
                }
                job.join()
                job2.join()
            }
            Log.d(TAG, "Time taken for async Jobs $time")
        }




    }

    suspend fun network():String{
        delay(3000)
        return "Nilesh Teji"
    }

    suspend fun network2():String{
        delay(3000)
        return "Nilesh Teji"
    }
}