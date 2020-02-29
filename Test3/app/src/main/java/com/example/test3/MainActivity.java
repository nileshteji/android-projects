package com.example.test3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
ListView obj;
String[] list={"fruits","cars","phones","laptops"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        obj=(ListView)findViewById(R.id.listview);
        ArrayAdapter obj1=new ArrayAdapter(MainActivity.this,R.layout.customlayout1,list);
        obj.setAdapter(obj1);
        obj.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                if(position==0){
                 Intent obj2=new Intent(MainActivity.this,FruitActivity.class);
                 startActivity(obj2);
              }
                else if(position==1){
                  Intent obj2=new Intent(MainActivity.this,CarsActivity.class);
                  startActivity(obj2);
                }
                else if(position==2){
                    Intent obj2=new Intent(MainActivity.this,PhoneActivity.class);
                    startActivity(obj2);
                }
//
                else if(position==3){
                    Intent obj2=new Intent(MainActivity.this,LaptopActivity.class);
                    startActivity(obj2);
                }
            }
        });
    }
}
