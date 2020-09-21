package com.osos.kotlinapplication.db

import androidx.room.*

@Dao
abstract class StudentDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(item:Student);

    @Delete
    abstract suspend fun delete(item: Student)

    @Query("SELECT * FROM user")
    abstract suspend fun get():List<Student>





}