package com.osos.roomimplementation;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.osos.roomimplementation.adapter.Adapter;
import com.osos.roomimplementation.database.Person;
import com.osos.roomimplementation.database.PersonDatabase;
import com.osos.roomimplementation.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding mainBinding;
List<Person> list;
String a="Nilesh",b="Teji";
int index=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding= DataBindingUtil.setContentView(MainActivity.this,R.layout.activity_main);

        new Display().execute();



        mainBinding.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });









    }
    class Display extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            PersonDatabase personDatabase=PersonDatabase.getInstance(getApplicationContext());
            list=personDatabase.personDao().getAll();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            mainBinding.recycler.setAdapter(new Adapter(getApplicationContext(),list));
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            mainBinding.recycler.setLayoutManager(linearLayoutManager);
        }
    }

    class insert extends AsyncTask<Person,Void,Void>{

        @Override
        protected Void doInBackground(Person... people) {
            PersonDatabase personDatabase=PersonDatabase.getInstance(getApplicationContext());
            personDatabase.personDao().insert(people[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            new Adapter(getApplicationContext(),list).notifyDataSetChanged();

        }
    }
}
