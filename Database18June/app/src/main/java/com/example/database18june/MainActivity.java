package com.example.database18june;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button obj,obj1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        obj=findViewById(R.id.login);
        obj1=findViewById(R.id.register);
        obj.setOnClickListener(this);
        obj1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
if(v==obj){
    Intent obj3=new Intent(MainActivity.this,Login.class);
    startActivity(obj3);
}

else if(v==obj1){
    Intent obj4=new Intent(MainActivity.this,Register.class);
    startActivity(obj4);
}
    }
}
