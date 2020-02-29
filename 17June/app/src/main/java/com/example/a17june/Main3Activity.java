package com.example.a17june;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class Main3Activity extends AppCompatActivity {
TimePicker obj;
TextView boj1;
Button boj2;
Button boj4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        obj=findViewById(R.id.id);
        boj1=findViewById(R.id.id1);
        boj2=findViewById(R.id.id2);
        boj4=findViewById(R.id.id3);
obj.setIs24HourView(true);
        boj2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a=obj.getHour();
                int b=obj.getMinute();
            boj1.setText(a+"is the hour"+b+"is the minute");
            }
        });
        boj4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj=new Intent(Main3Activity.this,Main4Activity.class);
                startActivity(obj);

            }
        });




    }
}
