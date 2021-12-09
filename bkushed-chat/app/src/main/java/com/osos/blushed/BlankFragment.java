package com.osos.blushed;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


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
        Button button;
      View v=  inflater.inflate(R.layout.fragment_blank, container, false);
     button =v.findViewById(R.id.button);
     button.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            if(isConnected()==true){
//                Intent boj=new Intent(getActivity(),MainActivity.class);
//                boj.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(boj);
                getView().setVisibility(View.GONE);


            }
            else{
                Toast.makeText(getActivity(), "No Internet", Toast.LENGTH_SHORT).show();
            }
         }
     });
        return v;
    }



    public boolean isConnected() {
        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            connected = true;
            return connected;
        } else
            connected = false;
        return connected;

    }



}
