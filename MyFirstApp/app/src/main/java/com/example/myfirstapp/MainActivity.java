package com.example.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;

    EditText ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.button);
        ed = (EditText)findViewById(R.id.editText);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String a = ed.getText().toString();

                Toast.makeText(MainActivity.this, a, Toast.LENGTH_SHORT).show();

//                Toast.makeText(MainActivity.this, "Hello Android", Toast.LENGTH_LONG).show();
            }
        });
    }
}
