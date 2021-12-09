package com.osos.blushed;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.osos.blushed.Model.Message;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;



import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewOutlineProvider;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
 ConstraintLayout constraintLayout;
 ListView list;
 RecyclerView recyclerView;
    Adapter boj;
 ArrayList<Message> newList;
 ArrayList<Message> getNewList1;




    int index=0;



    public void updateUi(){
        if(index<=new Data().getSize()-1) {
            if (isConnected() == true) {
                newList.add(new Data().getData(index));
              //  Toast.makeText(this, newList.get(index).getData()+" "+newList.get(index).getPerson(), Toast.LENGTH_SHORT).show();
//               if(boj==null){
//                   Log.d("TAG","Null Adapter");
//               }
//               else{
                 //  boj=new Adapter(this,newList);
                   Log.d("TAG1","notifyItem");
                   boj.notifyItemInserted(newList.size()-1);
                   recyclerView.smoothScrollToPosition(index);
                   index++;


            }
            else {
              getSupportFragmentManager().beginTransaction().replace(R.id.con,new BlankFragment()).commit();
                //  Toast.makeText(this, "Sorry No internet Connection", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this, "Sorry no more chats ", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=findViewById(R.id.list_item);
        constraintLayout=findViewById(R.id.con);
        recyclerView=findViewById(R.id.rec);
        newList=new ArrayList<>();
        getNewList1=new ArrayList<>();


       // list.setAdapter(new listView(newList,MainActivity.this));
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              updateUi();
            }
        });


        if(isConnected()==true){
            newList.add(new Data().getData(index));
            index++;
          boj=new Adapter(this,newList);
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.getRecycledViewPool().setMaxRecycledViews(0,0);

            recyclerView.setAdapter(boj);


        }
        else{
            getSupportFragmentManager().beginTransaction().replace(R.id.con,new BlankFragment()).commit();
        }





    }




    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Destroy","Done");
        newList.clear();
        index=0;

    }

public boolean isConnected() {
        boolean connected = false;
    ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
            connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
        connected = true;
        return connected;
    } else
        connected = false;
        return connected;

}


}
