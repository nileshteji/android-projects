package com.osos.loginsignup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Otp extends AppCompatActivity {
Toolbar toolbar;
TextView details;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        toolbar=findViewById(R.id.toolbar2);
        details=findViewById(R.id.textView4);
        getSupportActionBar();
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        Intent intent=getIntent();
        details.setText("We have sent you an SMS on "+intent.getStringExtra("Value")+" with 4 Digit verification code");
    }
}
