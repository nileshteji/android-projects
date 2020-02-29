package com.example.fragments3;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener {
EditText obj;
EditText obj2;
Button obj3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        obj=(EditText)findViewById(R.id.editText1);
        obj2=(EditText)findViewById(R.id.editText2);
        obj3=(Button)findViewById(R.id.button);


        obj3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String a=String.valueOf(obj.getText());
               String b=String.valueOf(obj2.getText());

               Bundle bu = new Bundle();
               bu.putString("one", a);
               bu.putString("tne", b);

               BlankFragment obj=new BlankFragment();

               obj.setArguments(bu);

               getSupportFragmentManager().beginTransaction().replace(R.id.id1, obj).addToBackStack(null).commit();



                obj3.setVisibility(View.GONE);

            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        obj3.setVisibility(View.VISIBLE);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
