package com.osos.roomimplementation;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.osos.roomimplementation.adapter.Adapter;
import com.osos.roomimplementation.database.Person;
import com.osos.roomimplementation.database.PersonDao;
import com.osos.roomimplementation.database.PersonDatabase;
import com.osos.roomimplementation.databinding.ActivityMainBinding;

import java.util.List;


import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mainBinding;
    List<Person> list;
    PersonDatabase personDatabase;
    PersonDao dao;

    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);
        personDatabase = PersonDatabase.getInstance(getApplicationContext());
        dao = personDatabase.personDao();




         // Display
        dao.getAll().toObservable().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<List<Person>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<Person> people) {
                        list=people;
                        Adapter adapter=new Adapter(getApplicationContext(),people);
                        mainBinding.recycler.setAdapter(adapter);
                        GridLayoutManager gridLayoutManager=new GridLayoutManager(getApplicationContext(),3);
                        mainBinding.recycler.setLayoutManager(gridLayoutManager);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });





                mainBinding.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new insert().execute(new Person(0, "Nilesh", "Teji"));

            }
        });


    }



    class insert extends AsyncTask<Person, Void, Void> {

        @Override
        protected Void doInBackground(Person... people) {
            list.add(people[0]);
            PersonDatabase personDatabase = PersonDatabase.getInstance(getApplicationContext());
            personDatabase.personDao().insert(people[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            new Adapter(getApplicationContext(), list).notifyDataSetChanged();
            Toast.makeText(MainActivity.this, String.valueOf(list.size()), Toast.LENGTH_SHORT).show();

        }
    }
}
