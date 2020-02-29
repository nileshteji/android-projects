package com.example.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class deanLewis extends AppCompatActivity {
Button obj5,obj6;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dean_lewis);
        obj5=(Button)findViewById(R.id.button3);
        obj6=(Button)findViewById(R.id.button4);
        obj5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj=new Intent(deanLewis.this,PlayService1.class);
                startService(obj);
            }
        });


        obj6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj1=new Intent(deanLewis.this,PlayService1.class);
                stopService(obj1);
            }
        });
    }
}
