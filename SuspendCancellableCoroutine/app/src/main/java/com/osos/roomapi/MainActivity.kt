package com.osos.roomapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.*
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class MainActivity : AppCompatActivity() {

    lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()



        // How to Convert a CallBack to Coroutine

        CoroutineScope(Dispatchers.IO).launch {
            var result = getResult()
           when(result){
               is Result.Success -> println(result.a)
               is Result.Error -> println(result.b)
           }
        }










    }




    suspend fun getResult(): Result{
       return suspendCancellableCoroutine<Result> {continuation ->
            mAuth.signInWithEmailAndPassword("xyz@gmail.com","abc")
                    .addOnSuccessListener {
                        continuation.resume(Result.Success("Nilesh"))
                    }
                    .addOnFailureListener {
                        continuation.resume(Result.Error(it.localizedMessage))
                    }
        }
    }
}