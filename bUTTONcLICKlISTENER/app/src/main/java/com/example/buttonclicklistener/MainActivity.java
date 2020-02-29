package com.example.buttonclicklistener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button obj, obj1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        obj = findViewById(R.id.button);
        obj1 = findViewById(R.id.button2);

        obj.setOnClickListener(this);
        obj1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==obj)
        {
            Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();
        }
        if(v==obj1)
        {
            Toast.makeText(this, "bye", Toast.LENGTH_SHORT).show();
        }
    }
}
