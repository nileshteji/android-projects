package com.example.toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
Toolbar obj;
Button obj1;
ActionMode obj3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        obj=(Toolbar)findViewById(R.id.toolbar2);
        obj1=(Button)findViewById(R.id.button2);
        obj.setTitle("Potentional-Giggle");
        obj.setTitleTextColor(Color.RED);

      setSupportActionBar(obj);
      obj1.setOnLongClickListener(new View.OnLongClickListener() {
          @Override
          public boolean onLongClick(View v) {
              obj3=startActionMode(new nilesh());
              obj1.setBackgroundColor(Color.BLACK);
              return true;
          }
      });
    }



    class nilesh implements ActionMode.Callback{ //Contextual toolbar

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.setTitle("HI");

        mode.getMenuInflater().inflate(R.menu.data,menu);






            return  true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {


            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            obj1    .setBackgroundColor(Color.WHITE);
            Intent obj=new Intent(Main2Activity.this,MainActivity.class);
            startActivity(obj);

        }
    }
}
