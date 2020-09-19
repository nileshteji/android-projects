package com.osos.kotlinapplication.db
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase


@Database(entities = arrayOf(Student::class), version = 2)
abstract class DataBaseStudent : RoomDatabase() {


    abstract fun getDao(): StudentDao;


     companion object {

         fun get(base: Context): DataBaseStudent?{

             return Room.databaseBuilder(base,DataBaseStudent::class.java,"person_Database").build();

         }
     }

}