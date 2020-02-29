package com.example.fragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id=(Button)findViewById(R.id.button);
        id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(obj);
            }
        });

    }
}
