
package com.osos.rxjavausingretrofit;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.osos.rxjavausingretrofit.databinding.ActivityMainBinding;
import com.osos.rxjavausingretrofit.network.ApiBase;
import com.osos.rxjavausingretrofit.network.ApiInterFace;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    final String TAG = "MainActivity";
    ApiBase retrofit;
    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View v = mainBinding.getRoot();
        setContentView(v);
        ApiInterFace calling = ApiBase.getRetrofit().create(ApiInterFace.class);
        mainBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calling.getSingleEmployee(2).toObservable().subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<User>() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {
                                Log.d(TAG, "onSubscribe: ");

                            }

                            @Override
                            public void onNext(@NonNull User user) {
                                Log.d(TAG, "onNext: " + user.getTitle());

                            }

                            @Override
                            public void onError(@NonNull Throwable e) {
                                Log.d(TAG, "onError: " + e.getLocalizedMessage());

                            }

                            @Override
                            public void onComplete() {
                                Log.d(TAG, "onComplete: ");
                            }
                        });
            }
        });


    }
}
