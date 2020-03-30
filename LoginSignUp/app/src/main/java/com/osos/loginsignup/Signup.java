package com.osos.loginsignup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class Signup extends AppCompatActivity {
Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        toolbar=findViewById(R.id.toolbar);
        getSupportActionBar();
        toolbar.setNavigationIcon(R.drawable.ic_arrow_forward_black_24dp);
    }
}
