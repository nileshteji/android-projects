package com.example.fragments4;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      getSupportFragmentManager().beginTransaction().replace(R.id.id1,new BlankFragment()).addToBackStack(null).commit();



    }



    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
