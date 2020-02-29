package com.example.booksshelf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
TextView boj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        boj=(TextView)findViewById(R.id.textView);

        Intent obj=getIntent();

String a=        obj.getStringExtra("position");
boj.setText(a);

    }
}
