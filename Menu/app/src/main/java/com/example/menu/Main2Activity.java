package com.example.menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv=(TextView)findViewById(R.id.da);
        registerForContextMenu(tv);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0,v.getId(),0,"call");
        menu.add(0,v.getId(),1,"sms");
        menu.add(0,v.getId(),2,"mail");
        menu.add(0,v.getId(),3,"next");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getTitle().equals("call"))
        {
            Toast.makeText(this, "call", Toast.LENGTH_SHORT).show();
        }
        else if(item.getTitle().equals("sms"))
        {
            Toast.makeText(this, "sms", Toast.LENGTH_SHORT).show();
        }
        else if(item.getTitle().equals("next")){
            Intent obj1=new Intent(Main2Activity.this,Main3Activity.class);
            startActivity(obj1);
        }
        else {
            Toast.makeText(this, "email", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }
}
