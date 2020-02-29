package com.example.toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
Toolbar obj;
Button obj1;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        obj1=(Button)findViewById(R.id.button);
        obj=(Toolbar)findViewById(R.id.toolbar);
        obj.setTitle("Potentional-Giggle");
        obj.setTitleTextColor(Color.RED);
        obj.setSubtitle("A Potentional Company");
        obj.setSubtitleTextColor(Color.RED);
        obj.setNavigationIcon(R.drawable.arr);
        obj.setNavigationIcon(R.drawable.ic_delete_black_24dp);
        setSupportActionBar(obj);//Support action bar
        obj.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(obj);
            }
        });




    }
}
