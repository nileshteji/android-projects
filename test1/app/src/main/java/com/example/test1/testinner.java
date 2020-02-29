package com.example.test1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import  android.widget.*;

public class testinner extends AppCompatActivity {
Button obj;
EditText obj1;
EditText obj2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testinner);
        obj=(Button)findViewById(R.id.button2);
        obj1=(EditText)findViewById(R.id.editText);
        obj2=(EditText)findViewById(R.id.editText);

        obj.setOnClickListener(new View.OnClickListener() {

            String a=obj1.getText().toString();
            String b=obj2.getText().toString();
            public void onClick(View v) {
                Intent obj9=new Intent(testinner.this,testinner2.class);
                obj9.putExtra("name",a);
                obj9.putExtra("pass",b);
              startActivity(obj9);

            }
        });


    }
}
