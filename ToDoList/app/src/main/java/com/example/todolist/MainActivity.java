package com.example.todolist;

import android.content.Intent;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ListView obj;
String[] obj1={"nilesh ,teji","nilesh" ,"teji","nilesh" ,"teji"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        obj=(ListView)findViewById(R.id.ListView);
        ArrayAdapter obj2=new ArrayAdapter(MainActivity.this,R.layout.custom,obj1);
        obj.setAdapter(obj2);
        obj.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, String.valueOf(id), Toast.LENGTH_SHORT).show();
                Intent obj3=new Intent(MainActivity.this,Inner.class);
                obj3.putExtra("Value",obj1[position]);
                startActivity(obj3);
            }
        });



    }
}
