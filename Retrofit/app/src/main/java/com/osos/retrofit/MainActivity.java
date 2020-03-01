package com.osos.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.osos.retrofit.api.getDataInterface;

import com.osos.retrofit.api.ApiClient;
import com.osos.retrofit.api.WeatherCast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiClient obj=new ApiClient();
        Retrofit retrofit = obj.getRetrofit();
        getDataInterface obj1= (getDataInterface) retrofit.create(WeatherCast.class);
        Call<WeatherCast> weatherCastCall=obj1.getWeather("London","Nileshteji");
        weatherCastCall.enqueue(new Callback<WeatherCast>() {
            @Override
            public void onResponse(Call<WeatherCast> call, Response<WeatherCast> response) {
                WeatherCast obj=response.body();
            }

            @Override
            public void onFailure(Call<WeatherCast> call, Throwable t) {

            }
        });




    }
}
