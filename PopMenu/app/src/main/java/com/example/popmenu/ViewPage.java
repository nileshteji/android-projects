package com.example.popmenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ViewPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page);
        Intent obj = getIntent();
        String a = obj.getStringExtra("id");

        if (a.equals("Tech-Companies")) {
            Toast.makeText(ViewPage.this, "TECH-COMPANIES", Toast.LENGTH_LONG).show();
        }
        else if (a.equals("Car-Companies")) {
            Toast.makeText(ViewPage.this, "Car-companies", Toast.LENGTH_LONG).show();
        }
        else if (a.equals("Cities")) {
            Toast.makeText(ViewPage.this, "Cities", Toast.LENGTH_LONG).show();
        }
        else if(a.equals("Union-territories")){
            Toast.makeText(ViewPage.this, "Union-territories", Toast.LENGTH_LONG).show();

        }
        else if(a.equals("Countries")){
            Toast.makeText(ViewPage.this, "Countries", Toast.LENGTH_LONG).show();
        }
    }

}
