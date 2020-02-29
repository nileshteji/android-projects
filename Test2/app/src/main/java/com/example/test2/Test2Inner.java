package com.example.test2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Test2Inner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2_inner);
        Intent i=getIntent();
        String a=i.getStringExtra("Name");
        String b=i.getStringExtra("phone");
        String c=i.getStringExtra("Email");
        String d=i.getStringExtra("Password");
        String e=i.getStringExtra("Confirm");
        if(!a.isEmpty()&&!b.isEmpty()&&!c.isEmpty()&&!d.isEmpty()&&!e.isEmpty()){

            if(c.contains("@")){
                if(d.equals(e)){
                    Toast.makeText(this,a+"\n"+b+"\n"+c+"\n"+d+"\n"+e,Toast.LENGTH_LONG).show();

                }
            }
            else{
                Toast.makeText(this, "please enter valid email address", Toast.LENGTH_SHORT).show();
            }
        }



        else{
            Toast.makeText(this, "Please fill all the inputs", Toast.LENGTH_SHORT).show();
        }

    }


}

