package com.android.viewmodelfactory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;

import com.android.viewmodelfactory.databinding.ActivityMainBinding;
import com.android.viewmodelfactory.viewModel.MainViewModel;
import com.android.viewmodelfactory.viewModel.ViewModelFacotry;

public class MainActivity extends AppCompatActivity {
MainViewModel mainViewModel;
ActivityMainBinding mainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding=ActivityMainBinding.inflate(getLayoutInflater());
        ViewModelFacotry viewModelFacotry=new ViewModelFacotry("Nilesh Teji");

        setContentView(mainBinding.getRoot());

        mainViewModel= new ViewModelProvider(this,viewModelFacotry).get(MainViewModel.class);

        mainViewModel.getString().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
             mainBinding.textView.setText(s);
    
            }
        });



    }
}