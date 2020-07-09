package com.android.debouncefunctionality;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.CursorAdapter;
import android.widget.SearchView;
import android.widget.Toast;

import com.android.debouncefunctionality.databinding.ActivityMainBinding;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mainBinding;
    final String TAG = "MainActivity";
   static Observable<String> searchText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        mainBinding.searchBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainBinding.searchBar.onActionViewExpanded();
            }
        });
      mainBinding.searchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
          @Override
          public boolean onQueryTextSubmit(String query) {
              return false;
          }

          @Override
          public boolean onQueryTextChange(String newText) {

              Log.d(TAG, "onQueryTextChange: " + newText);
              search(newText);
              return false;
          }
      });





    }


    public void search(String s){
   Observable.just(s).subscribeOn(Schedulers.io())
           .observeOn(AndroidSchedulers.mainThread())
           .debounce(500,TimeUnit.MILLISECONDS)
           .subscribe(new Observer<String>() {
               @Override
               public void onSubscribe(@NonNull Disposable d) {

               }

               @Override
               public void onNext(@NonNull String s) {
                   Log.d(TAG, "onNext: " + s + " debounciing Technique" );
               }

               @Override
               public void onError(@NonNull Throwable e) {

               }

               @Override
               public void onComplete() {

               }
           });
    }




}
