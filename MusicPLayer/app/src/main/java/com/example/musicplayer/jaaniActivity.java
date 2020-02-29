package com.example.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class jaaniActivity extends AppCompatActivity {
Button obj1,obj2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_activiti);
        obj1=(Button)findViewById(R.id.button);
        obj2=(Button)findViewById(R.id.button2);


obj1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent obj=new Intent(jaaniActivity.this,PlayService.class);
startService(obj);
    }
});


obj2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent obj1=new Intent(jaaniActivity.this,PlayService.class);
        stopService(obj1);
    }
});


    }
}
