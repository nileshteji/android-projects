package com.example.menu;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.data,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.s)
        {
            Toast.makeText(this, "Seetings", Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId()==R.id.d) {
            Toast.makeText(this, "delete", Toast.LENGTH_SHORT).show();
        }


        else if(item.getItemId()==R.id.Next){
            Intent obj=new Intent(MainActivity.this,Main2Activity.class);
            startActivity(obj);
        }

        else
        {
            Toast.makeText(this, "Edit", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
