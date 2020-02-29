package com.example.database18june;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DataBaseAdapter extends SQLiteOpenHelper {
    public static final String DB_NAME = "PersonsDB";
    public static final String TABLE_NAME = "DATA";
    public static final String COLUMN_USERNAME = "USERNAME";
    public static final String COLUMN_NAME ="PASSWORD";
    public static final String COLUMN_EMAIL = "EMAIL";
    private static final int DB_VERSION = 1;


    public DataBaseAdapter(Context context) {
        super(context,DB_NAME,null,DB_VERSION);
    }


SQLiteDatabase db;
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = " CREATE TABLE " +TABLE_NAME
                +"(" +COLUMN_USERNAME+
                " VARCHAR, " +COLUMN_NAME+
                " VARCHAR, " +COLUMN_EMAIL+
                " VARCHAR);";
        db.execSQL(sql);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql="DROP TABLE IF EXISTS "+TABLE_NAME+";";
        db.execSQL(sql);
        onCreate(db);

    }


    public boolean Insertion(String username,String name,String email){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues obj=new ContentValues();
        obj.put(COLUMN_USERNAME,username);
        obj.put(COLUMN_NAME,name);
        obj.put(COLUMN_EMAIL,email);
        db.insert(TABLE_NAME,null,obj);
        db.close();

      //  String sql="INSERT INTO "+TABLE_NAME+" VALUES "+ '"+username+"' +"'+name+'"+"'+email+'"+";";

        return true;
    }

    public ArrayList<String> get(String name) {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<String> obj = new ArrayList<>();
        String sql = "SELECT * FROM DATA WHERE USERNAME='"+name+"';";

        Cursor c = db.rawQuery(sql, null);
        if (c.moveToFirst()) {
            do {
                obj.add(c.getString(c.getColumnIndex(COLUMN_USERNAME)) + " " + c.getString(c.getColumnIndex(COLUMN_NAME)) + " " + c.getString(c.getColumnIndex(COLUMN_EMAIL)));

            }while (c.moveToNext());

        }
        return  obj;
    }


}
