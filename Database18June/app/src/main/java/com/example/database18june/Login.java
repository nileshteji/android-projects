package com.example.database18june;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class Login extends AppCompatActivity implements View.OnClickListener {
EditText boj;
Button obj;
ListView boj2;
DataBaseAdapter boj1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        boj=findViewById(R.id.username1);
        obj=findViewById(R.id.LOGIN1);
        boj2=findViewById(R.id.lv);
        obj.setOnClickListener(this);
        boj1=new DataBaseAdapter(Login.this);
    }

    @Override
    public void onClick(View v) {
if(v==obj){
    

    ArrayList<String> data=boj1.get(String.valueOf(boj.getText()));
    ArrayAdapter obj=new ArrayAdapter(Login.this,R.layout.layout,data);
    boj2.setAdapter(obj);


}
    }
}
