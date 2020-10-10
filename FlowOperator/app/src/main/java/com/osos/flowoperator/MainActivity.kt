package com.osos.flowoperator

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {
    lateinit var flow: Flow<Int>
    val TAG = "Main"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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

        val int=System.currentTimeMillis()
        CoroutineScope(Dispatchers.IO).launch {

          val time=  measureTimeMillis {
                launch {
                    void(1)
                }.join()
                launch {
                    void2(2)
                }.join()
            }

            Log.d(TAG, "onCreate: $time")


        }.invokeOnCompletion {
            if(it==null){
                Log.d(TAG, "Time taken ${System.currentTimeMillis()-int}")
            }
        }


    }
    suspend fun void(a:Int){
        delay(3000)

        Log.d(TAG, "void: Done Job $a")
    }
    suspend fun void2(a:Int) {
        delay(3000)
        Log.d(TAG,"Done Job $a")
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