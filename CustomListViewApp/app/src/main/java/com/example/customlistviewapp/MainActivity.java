package com.example.customlistviewapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    ListView lv;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView)findViewById(R.id.listView);
        b=(Button)findViewById(R.id.button);

        MyAdapter ad = new MyAdapter(MainActivity.this);

        lv.setAdapter(ad);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj=new Intent(MainActivity.this,CustomGridViewApp.class);
                startActivity(obj);
            }
        });
    }
}
