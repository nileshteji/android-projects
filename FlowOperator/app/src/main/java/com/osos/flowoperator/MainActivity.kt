package com.osos.flowoperator

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var flow: Flow<Int>
    val TAG = "Main"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text.setText("Nilesh")
        //setUpFlows()
//
//
//        Observable.just("Nilesh","Teji","Taheem","Singh","Hi")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({},{},{})
//
//
//        CoroutineScope(Dispatchers.IO).launch {
//           flow.collect {
//
//           }
//        }

        val int = System.currentTimeMillis()
        CoroutineScope(Dispatchers.IO).launch {

            launch {
                void(1)
            }
            launch {
                void2(2)
            }

        }.invokeOnCompletion {
            if (it == null) {
                Log.d(TAG, "Time taken ${System.currentTimeMillis() - int}")
            }
        }


    }

    suspend fun void(a: Int) {
        delay(3000)
        Log.d(TAG, "void: Done Job $a")
    }

    suspend fun void2(a: Int) {
        delay(3000)
        Log.d(TAG, "Done Job $a")
    }

    fun setUpFlows(): Unit {

        flow = flow<Int> {
            (0..10).forEach {
                delay(100)
                emit(it)
            }
        }
    }
}