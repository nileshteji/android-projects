package com.example.a17june;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Toast;

public class Main5Activity extends AppCompatActivity {
RatingBar rb;
Button b1,b2;
AlertDialog.Builder builder;
RadioGroup boj;
Button gender;
CheckBox c1,c2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        rb=findViewById(R.id.rb);
        b1=findViewById(R.id.b1);
        boj=findViewById(R.id.rg);
        gender=findViewById(R.id.buttongender);

    boj.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            int a=boj.getCheckedRadioButtonId();
//            RadioButton rb=findViewById(a);
//            Toast.makeText(Main5Activity.this,String.valueOf(rb.getText()),Toast.LENGTH_LONG).show();



            if(a==R.id.rb1){
                RadioButton obj=findViewById(a);
                Toast.makeText(Main5Activity.this,obj.getText().toString(),Toast.LENGTH_LONG).show();


            }
        }
    });






        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float a=rb.getRating();
                Toast.makeText(Main5Activity.this, String.valueOf(a), Toast.LENGTH_SHORT).show();
            }
        });








    }
}
