package com.example.database;

import android.content.Intent;
import android.provider.ContactsContract;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextName;
    private EditText editTextAdd;
    private Button btnSave;
    private Button btnView;

    private DatabaseHelper db;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = (EditText)findViewById(R.id.editTextName);
        editTextAdd = (EditText)findViewById(R.id.editTextAddress);

        btnSave = (Button)findViewById(R.id.btnSave);
        btnView = (Button)findViewById(R.id.btnView);

        db = new DatabaseHelper(this);

        btnSave.setOnClickListener(this);
        btnView.setOnClickListener(this);
    }

    private void insert(){
        String name = editTextName.getText().toString().trim();
        String add = editTextAdd.getText().toString().trim();
        db.addPerson(name,add);
        Toast.makeText(this,"Inserted Successfully",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        if(v==btnSave){
            insert();
        }
        if(v==btnView){
            Intent intent = new Intent(this,ViewPersons.class);
            startActivity(intent);
        }
    }
}