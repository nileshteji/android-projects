package com.example.test3;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Fruit1Activity extends AppCompatActivity {
ImageView obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit1);
        obj=(ImageView)findViewById(R.id.imageView);
        Intent ojb=getIntent();
        int i=ojb.getIntExtra("image", -1);

        obj.setImageResource(i);

    }
}
