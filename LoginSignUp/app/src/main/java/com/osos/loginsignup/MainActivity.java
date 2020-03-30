package com.osos.loginsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.image);
        imageView.setAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.heartbeat));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
              startActivity(new Intent(MainActivity.this,Sign.class));


            }
        },2000);
    }
}
