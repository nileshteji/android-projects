package com.example.test2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
Button obj;
EditText obj2;
EditText obj3;
EditText obj4;
EditText obj5;
EditText obj6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        obj=(Button)findViewById(R.id.button);
        obj2=(EditText)findViewById(R.id.editText);
        obj3=(EditText)findViewById(R.id.editText3);
        obj4=(EditText)findViewById(R.id.EmailAddress);
        obj5=(EditText)findViewById(R.id.Password);
        obj6=(EditText)findViewById(R.id.Confirm);




        obj.setOnClickListener(new View.OnClickListener()


                               {
                                   public void onClick(View v){

                                       Intent obj1=new Intent(MainActivity.this,Test2Inner.class);
                                       String a=String.valueOf(obj2.getText());
                                       String b=String.valueOf(obj3.getText());
                                       String c=String.valueOf(obj4.getText());
                                       String d=String.valueOf(obj5.getText());
                                       String e=String.valueOf(obj6.getText());
                                       obj1.putExtra("Name",a);
                                       obj1.putExtra("phone",b);
                                       obj1.putExtra("Email",c);
                                       obj1.putExtra("Password",d);
                                       obj1.putExtra("Confirm",e);
                                       startActivity(obj1);




                                   }
                               }

        );
    }
}
