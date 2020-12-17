package com.osos.flowoperator

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Runnable
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class MainActivity : AppCompatActivity() {
    var a: String = "Nilesh Teji"
    val TAG = "MainActivityLog"
    lateinit var flow: Flow<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        flow = kotlinx.coroutines.flow.flow {
            for (i in 1 until 10 step 2) {
                if (i == 3) {
                    throw CancellationException()
                }
                emit(0)
            }
        }


    }

    suspend fun networkCallOne(): String {
        delay(2000)
        Log.d(TAG, "networkCallOne: Done with Network Call One")
        return "Network Call One"
    }

    suspend fun networkCallTwo(): String {
        delay(2000)
        Log.d(TAG, "networkCallTwo:Done with Network Call Two")
        return "Network Call Two"
    }

    fun getObservable(i: Int): Observable<Int> {
        return Observable.just(i);
    }

    private fun doLongRunningTask(): Flow<Int> {
        return flow {
            
            delay(2000)

            val randomNumber = (0..2).random()

            if (randomNumber == 0) {
                Log.d(TAG, "doLongRunningTask: $randomNumber")
                throw IOException()

            } else if (randomNumber == 1) {
                Log.d(TAG, "doLongRunningTask: $randomNumber")
                throw IndexOutOfBoundsException()
            }

            delay(2000)
            emit(0)
        }
    }
}


class Thread : Runnable {
    override fun run() {
        TODO("Not yet implemented")
    }

}