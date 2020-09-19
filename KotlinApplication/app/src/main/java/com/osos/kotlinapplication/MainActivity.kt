package com.osos.kotlinapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.osos.kotlinapplication.databinding.ActivityMainBinding

import com.osos.kotlinapplication.db.DataBaseStudent
import com.osos.kotlinapplication.db.Student
import com.osos.kotlinapplication.db.StudentDao
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {


    lateinit var main: ActivityMainBinding;
    lateinit var data:DataBaseStudent;
    lateinit var dao: StudentDao;
    var viewModel:NileshViewModel= NileshViewModel();
    lateinit var a:Student;



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        main=ActivityMainBinding.inflate(layoutInflater)
        setContentView(main.root)
        data= DataBaseStudent.get(applicationContext)!!
        dao=data!!.getDao();



     GlobalScope.launch {
         dao.insert(Student(1,"Nilesh","teji"));
         a=dao.get().get(0);
         Log.d("Room", "onCreate: "+a.name+" "+a.lastName); 

     }









    }


    }







