package com.osos.roomimplementation.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = Person.class,version = 3,exportSchema = false)
public abstract class PersonDatabase extends RoomDatabase {

public static final String DB_NAME="person_DB";
public static PersonDatabase INSTANCE;
public static synchronized PersonDatabase getInstance(Context context){
    if(INSTANCE==null){
        INSTANCE= Room.databaseBuilder(context,PersonDatabase.class,DB_NAME).fallbackToDestructiveMigration().build();
    }
    return INSTANCE;

}

public abstract PersonDao personDao();







}
