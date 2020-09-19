package com.osos.kotlinapplication.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user")
data class Student(
    @PrimaryKey
    val roll:Int,
    @ColumnInfo(name = "Name")
    val name:String,
    @ColumnInfo(name="Last_Name")
    val lastName:String
)