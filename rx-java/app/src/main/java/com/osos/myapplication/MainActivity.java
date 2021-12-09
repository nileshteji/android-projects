package com.osos.myapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableList;

import com.osos.myapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    final static String TAG = "Debugging";
    Observable<String> observable;
    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Nilesh","Teji","vineet","savita"));

        // this example of flatmap

        observable.fromIterable(list).flatMap(new Function<String, ObservableSource<?>>() {
            @Override
            public ObservableSource<Integer> apply(String s) throws Throwable {
                return ApiImplementation.getAmout(s);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object integer) {
                        System.out.println(integer);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });



        

        // this example of map
        observable.fromIterable(list).map(new Function<String, Object>() {
            @Override
            public String apply(String s) throws Throwable {
                return s.toUpperCase();
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object o) {
                        System.out.println(o);
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




class ApiImplementation{

    static Observable<Integer> getAmout(String s){

        HashMap<String,Integer> hashMap = new HashMap<>();
        hashMap.put("Nilesh",200);
        hashMap.put("Teji",300);
        hashMap.put("vineet",500);
        hashMap.put("savita",600);
        return Observable.just(hashMap.get(s));
    }
    }

