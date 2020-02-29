package com.example.popmenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView obj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final ArrayList<String> data=new ArrayList<>();

        data.add("Tech-Companies");
        data.add("Car-Companies");
        data.add("Cities");
        data.add("Union-territories");
        data.add("Countries");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        obj=(ListView)findViewById(R.id.list_view);
        final ArrayAdapter ad=new ArrayAdapter(MainActivity.this,R.layout.listview,data);
        obj.setAdapter(ad);
       obj.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
               PopupMenu popmenu=new PopupMenu(MainActivity.this,obj);
               getMenuInflater().inflate(R.menu.popmenu,popmenu.getMenu());
              if(position==0){
                  popmenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                      @Override
                      public boolean onMenuItemClick(MenuItem item) {

                        if(item.getItemId()==R.id.v){
                            Intent obj=new Intent(MainActivity.this,ViewPage.class);
                            obj.putExtra("id",data.get(position));
                            startActivity(obj);
                        }
                        else{
                            data.remove(position);
                            ad.notifyDataSetChanged();
                        }
                          return true;
                      }
                  });popmenu.show();

              }
              else if (position==1){
                  popmenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                      @Override
                      public boolean onMenuItemClick(MenuItem item) {

                          if(item.getItemId()==R.id.v){
                              Intent obj=new Intent(MainActivity.this,ViewPage.class);
                              obj.putExtra("id",data.get(position));
                              startActivity(obj);
                          }
                          else{
                              data.remove(position);
                              ad.notifyDataSetChanged();
                          }
                          return true;
                      }
                  });popmenu.show();


              }


              else if(position==2){
                  popmenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                      @Override
                      public boolean onMenuItemClick(MenuItem item) {

                          if(item.getItemId()==R.id.v){
                              Intent obj=new Intent(MainActivity.this,ViewPage.class);
                              obj.putExtra("id",data.get(position));
                              startActivity(obj);
                          }
                          else{
                              data.remove(position);
                              ad.notifyDataSetChanged();
                          }
                          return true;
                      }
                  });popmenu.show();



              }
              else if(position==3){
                  popmenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                      @Override
                      public boolean onMenuItemClick(MenuItem item) {

                          if(item.getItemId()==R.id.v){
                              Intent obj=new Intent(MainActivity.this,ViewPage.class);
                              obj.putExtra("id",data.get(position));
                              startActivity(obj);
                          }
                          else{
                              data.remove(position);
                              ad.notifyDataSetChanged();
                          }
                          return true;
                      }
                  });popmenu.show();



              }

              else if(position==4){


                  popmenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                      @Override
                      public boolean onMenuItemClick(MenuItem item) {

                          if(item.getItemId()==R.id.v){
                              Intent obj=new Intent(MainActivity.this,ViewPage.class);
                              obj.putExtra("id",data.get(position));
                              startActivity(obj);
                          }
                          else{
                              data.remove(position);
                              ad.notifyDataSetChanged();
                          }
                          return true;
                      }
                  });popmenu.show();


              }




           }
       });


    }





}

