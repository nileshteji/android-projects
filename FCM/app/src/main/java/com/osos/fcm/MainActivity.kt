package com.osos.fcm

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.messaging.FirebaseMessagingService
import java.net.Authenticator

class MainActivity : AppCompatActivity() {




  lateinit var authentication: FirebaseAuth;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        authentication=FirebaseAuth.getInstance()

            authentication.createUserWithEmailAndPassword("kumar.nilesh023@gmai.com", "Nilesh@123")
                .addOnCompleteListener(this@MainActivity) {
                    if (it.isSuccessful) {
                         TODO("Login the User")
                    } else {
                       TODO("Give a Error")
                    }
                }


        clickActivity(this@MainActivity,{
            it -> print("Nilesh")
        })

        var int:Intent=Intent(this,MessagingService::class.java).also{
           startService(it)
       }






    }


    fun clickActivity(context:Context,onClick: OnClick){
        onClick.clickMe(2);
    }
}