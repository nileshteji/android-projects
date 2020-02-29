package com.example.sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.Inet4Address;

public class MainActivity extends AppCompatActivity {
EditText obj,obj1;
Button obj2,obj3;
TextView obj4,obj5;

SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        obj=findViewById(R.id.editText);
        obj1=findViewById(R.id.editText2);
        obj2=findViewById(R.id.button);
        obj3=findViewById(R.id.button2);
        obj4=findViewById(R.id.textView);
        obj5=findViewById(R.id.textView2);

        sp = getApplicationContext().getSharedPreferences("file1", MODE_PRIVATE);


        obj2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=String.valueOf(obj.getText());
                String b=String.valueOf(obj1.getText());

                SharedPreferences.Editor ed = sp.edit();

                ed.putString("one", a);
                ed.putString("two", b);

                ed.commit();
                Toast.makeText(MainActivity.this, a+"\n"+b, Toast.LENGTH_SHORT).show();
            }
        });

        obj3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor ed = sp.edit();
                ed.clear();
                ed.commit();
            }
        });


        String a, b;
        a = sp.getString("one", "");
        b = sp.getString("two", "");

        obj4.setText(a);
        obj5.setText(b);
    }
}
