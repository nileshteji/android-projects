package com.osos.loginsignup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Signup extends AppCompatActivity {
Toolbar toolbar;
EditText Numberl;
Button obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        toolbar=findViewById(R.id.toolbar);
        getSupportActionBar();

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        Numberl=findViewById(R.id.editText3);
        obj=findViewById(R.id.button10);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj=new Intent(Signup.this,Sign.class);
                obj.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(obj);
            }
        });
        obj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent forwared=new Intent(Signup.this,Otp.class);
                forwared.putExtra("Value",Numberl.getText().toString());
                startActivity(forwared);
            }
        });


    }
}
