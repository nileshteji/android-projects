package com.osos.roomapi.db

import androidx.room.Entity
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey


@Entity
data class Word(  @PrimaryKey
                  var words : String)
