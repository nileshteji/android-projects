package com.example.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
       Button obj;
       EditText obj1;
       EditText obj2;
       EditText obj3;
       EditText obj4;
       EditText obj5;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        obj=(Button)findViewById(R.id.button);
        obj1=(EditText)findViewById(R.id.editText);
        obj2=(EditText)findViewById(R.id.editText3);
        obj3=(EditText)findViewById(R.id.editText4);
        obj4=(EditText)findViewById(R.id.editText5);
        obj5=(EditText)findViewById(R.id.editText6);
        obj.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
              String a=obj1.getText().toString();
              String b=obj2.getText().toString();
              String c=obj3.getText().toString();
              String d=obj4.getText().toString();
              String e=obj5.getText().toString();

              if(!a.isEmpty()||!b.isEmpty()||!c.isEmpty()||!d.isEmpty()||!e.isEmpty()){

                      if(b.contains("@")){
                          if(d.equals(e)){
                              Toast.makeText(MainActivity.this,a+"\n"+b+"\n"+c+"\n"+d+"\n"+e,Toast.LENGTH_LONG).show();

                          }
                      }
                      else{
                          Toast.makeText(MainActivity.this, "please enter valid email address", Toast.LENGTH_SHORT).show();
                      }
                  }



              else{
                  Toast.makeText(MainActivity.this, "Please fill all the inputs", Toast.LENGTH_SHORT).show();
              }

              }


        });


    }
}
