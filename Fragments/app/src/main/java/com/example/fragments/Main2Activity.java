package com.example.fragments;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;

public class Main2Activity extends AppCompatActivity {
Toolbar obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        obj=(Toolbar)findViewById(R.id.toolbar);
        obj.setTitle("Fragment Click");
        obj.setTitleTextColor(Color.BLACK);
        obj.setNavigationIcon(R.drawable.ic_apps_black_24dp);
        setSupportActionBar(obj);
        obj.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BlankFragment obj1=new BlankFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.id1, obj1).addToBackStack(null).commit();


            }
        });

    }
}
