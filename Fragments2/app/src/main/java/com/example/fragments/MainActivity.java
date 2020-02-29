package com.example.fragments;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BlankFragment obj1=new BlankFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.id1, obj1).addToBackStack(null).commit();


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
