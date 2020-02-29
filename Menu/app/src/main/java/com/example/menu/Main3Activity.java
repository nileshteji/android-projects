package com.example.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
Button obj2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        obj2=(Button)findViewById(R.id.button);
        obj2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu pop=new PopupMenu(Main3Activity.this,obj2);
                getMenuInflater().inflate(R.menu.data,pop.getMenu());
                pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(Main3Activity.this, String.valueOf(item.getTitle()), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });pop.show();
            }
        });
    }






}
