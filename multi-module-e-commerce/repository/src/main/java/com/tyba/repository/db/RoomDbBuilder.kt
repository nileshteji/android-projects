package com.tyba.repository.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.tyba.common.data.ExclusionBaseObject
import com.tyba.common.data.Feature
import com.tyba.common.data.Option
import com.tyba.repository.convertors.RoomConvertors


@Database(entities = arrayOf(Feature::class, Option::class, ExclusionBaseObject::class), version = 3)
@TypeConverters(RoomConvertors::class)
abstract class RoomDbBuilder : RoomDatabase() {

    abstract fun featureDao(): FeaturesDao

}


object ImplRoomBuilder {
    fun getDatabaseObj(context: Context) =
        Room.databaseBuilder(context, RoomDbBuilder::class.java, "Esper")
            .fallbackToDestructiveMigration()
            .build()
}