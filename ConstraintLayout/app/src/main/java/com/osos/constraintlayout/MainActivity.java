package com.osos.constraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.osos.constraintlayout.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

private ActivityMainBinding mainBinding;


// activity_main -> ActivityMainBinding

    // Data Binding



    //{

    // No Compile Time Error Safety  // mainBinding.
    // it works for two way binding
    // For exampel

    //Data Binding was not Good go

    //


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding=ActivityMainBinding.inflate(getLayoutInflater());
        View v=mainBinding.getRoot();
        setContentView(v);

        mainBinding.textView.setText("Nilesh");

        mainBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainBinding.textView.setText("Rahul");

            }
        });






    }
}
