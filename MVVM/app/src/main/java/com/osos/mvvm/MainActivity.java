package com.osos.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       NileshViewModel viewModel=ViewModelProviders.of(this).get(NileshViewModel.class);
 viewModel.getData().observe(this, new Observer<String>() {
     @Override
     public void onChanged(String s) {
         Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT).show();
     }
 });


    }
}
