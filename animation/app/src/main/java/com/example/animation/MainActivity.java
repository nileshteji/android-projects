package com.example.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
    ImageView obj;
    Button b1,b2,b3,b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void blink(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.blink);
        ImageView iv = (ImageView)findViewById(R.id.iv);
        iv.startAnimation(animation);
    }

    public void fade(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.fade);
        ImageView iv = (ImageView)findViewById(R.id.iv);
        iv.startAnimation(animation);
    }

    public void slide(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.slide);
        ImageView iv = (ImageView)findViewById(R.id.iv);
        iv.startAnimation(animation);
    }

    public void rotate(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        ImageView iv = (ImageView)findViewById(R.id.iv);
        iv.startAnimation(animation);
    }
}
