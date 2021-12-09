package com.osos.eduwaive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class Splash extends AppCompatActivity {
    FirebaseAuth auth;
    ImageView boj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        boj=findViewById(R.id.image);

        auth=FirebaseAuth.getInstance();
        Animation rotate = AnimationUtils.loadAnimation(this, R.anim.round);
        boj.startAnimation(rotate);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                          if(auth.getCurrentUser()==null){
                              startActivity(new Intent(Splash.this,MainActivity.class));
                          }
                          else{
                              startActivity(new Intent(Splash.this,Main2Activity.class));
                          }


            }
            },2000);






    }
}
