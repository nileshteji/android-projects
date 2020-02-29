package com.example.test1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class testinner2 extends AppCompatActivity {
TextView obj1;
TextView obj2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testinner2);
        obj1=(TextView)findViewById(R.id.textView);
        obj2=(TextView)findViewById(R.id.textView2);
        Intent i=getIntent();
        String str=i.getStringExtra("name");
        String str1=i.getStringExtra("pass");
        obj1.setText(str);
        obj2.setText(str1);

    }
}
