package com.example.myapplication;


import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {



    public BlankFragment() {
        // Required empty public constructor


    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v=inflater.inflate(R.layout.fragment_blank,container,false);
        //FloatingActionButton fb=(FloatingActionButton)v.findViewById(R.id.fab);
        //fb.setImageResource(R.drawable.ic_mode_edit_black_24dp);
       return v;
    }

}
