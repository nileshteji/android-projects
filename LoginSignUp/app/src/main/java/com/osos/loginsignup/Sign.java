package com.osos.loginsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Outline;
import android.os.Bundle;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Sign extends AppCompatActivity {
TextView textView;
Button verify;
EditText mobile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        textView=findViewById(R.id.sognup);
        mobile=findViewById(R.id.editText);
        verify=findViewById(R.id.buttonSign);
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(mobile.getText().equals("")|| mobile.length() < 10 || mobile.length() >10){
                  mobile.setError("Enter a valid mobile");
                  mobile.requestFocus();
                    return;
                }
                else {


                    Intent obj = new Intent(Sign.this, Otp.class);
                    obj.putExtra("Value", mobile.getText().toString());
                    startActivity(obj);
                }

            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Sign.this,Signup.class));
            }
        });

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}
