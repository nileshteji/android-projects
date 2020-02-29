package com.example.fragments4;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 *
 */

public class BlankFragment2 extends Fragment {
    TextView boj,obj;


    public BlankFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_blank_fragment2,container,false);
        boj=(TextView)v.findViewById(R.id.textView);
        obj=(TextView)v.findViewById(R.id.textView2);
        Bundle b=getArguments();
        String a1,a2;
        a1=b.getString("one");
        a2=b.getString("two");
        obj.setText(a1);
        boj.setText(a2);
        return v;
    }

}
