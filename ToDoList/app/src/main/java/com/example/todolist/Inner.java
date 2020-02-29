package com.example.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Inner extends AppCompatActivity {
   TextView obj1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inner);
        obj1=(TextView)findViewById(R.id.textView);
        Intent obj=getIntent();
        String a=obj.getStringExtra("Value");
         obj1.setText(a);

    }
}
