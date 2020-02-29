package com.example.gridviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    GridView obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        obj=(GridView)findViewById(R.id.gridview);

        MyAdapter ad = new MyAdapter(MainActivity.this);

        obj.setAdapter(ad);
    }
}
