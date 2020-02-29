package com.example.database18june;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity implements View.OnClickListener {
EditText obj,obj1,obj2;
Button obj3,obj4;
    DataBaseAdapter boj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        obj=findViewById(R.id.username);
        obj1=findViewById(R.id.password);
        obj2=findViewById(R.id.email2);
        obj3=findViewById(R.id.Insert);
        obj4=findViewById(R.id.LOGIN);
        obj3.setOnClickListener(this);
        obj4.setOnClickListener(this);
  boj=new DataBaseAdapter(Register.this);

    }

    @Override
    public void onClick(View v) {
if(v==obj3){
    String a=obj.getText().toString();
    String b=obj1.getText().toString();
    String c=obj2.getText().toString();

boolean d=boj.Insertion(a,b,c);
if(d) {
    Toast.makeText(Register.this,"SUCCESFULL",Toast.LENGTH_LONG).show();
}
else{
    Toast.makeText(Register.this,"SORRY",Toast.LENGTH_LONG).show();
}


}



else if(v==obj4){
    Intent obj5=new Intent(Register.this,Login.class);
    startActivity(obj5);
}
    }
}
