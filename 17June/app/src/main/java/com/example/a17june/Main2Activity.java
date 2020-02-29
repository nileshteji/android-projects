package com.example.a17june;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {
    DatePicker boj;
    TextView boj1;
    Button boj2;
    Button boj3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        boj = findViewById(R.id.id3);
        boj1 = findViewById(R.id.id4);
        boj2 = findViewById(R.id.id5);
        boj3=findViewById(R.id.id6);
        String a = String.valueOf(boj.getDayOfMonth());
        String b = String.valueOf(boj.getMonth());
        String c = String.valueOf(boj.getYear());

        boj1.setText(a + " " + b + " " + c);

        boj2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = String.valueOf(boj.getDayOfMonth());
                String b = String.valueOf(boj.getMonth());
                String c = String.valueOf(boj.getYear());
                boj1.setText(a + " " + b + " " + c);

            }
        });



        boj3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj=new Intent(Main2Activity.this,Main3Activity.class);
                startActivity(obj);
            }
        });
    }

}
