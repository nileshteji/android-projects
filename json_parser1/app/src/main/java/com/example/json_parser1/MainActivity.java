package com.example.json_parser1;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ListView obj;
    Button obj1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        obj = findViewById(R.id.listvirw);
        obj1=findViewById(R.id.button);
        obj1.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        final ProgressDialog boj=new ProgressDialog(MainActivity.this);
        boj.setMessage("Loading Your Data");
        boj.setCancelable(false);
        boj.show();
        if (v == obj1) {
            StringRequest obj = new StringRequest(Request.Method.POST, "https://api.androidhive.info/contacts/", new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    showResult(response);
                    boj.dismiss();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    boj.dismiss();
                }
            }



            );

            RequestQueue boj1= Volley.newRequestQueue(this);
            boj1.add(obj);
        }
    }

    public void showResult(String json) {
        ParseJson boj = new ParseJson(json);
        try {
            boj.parse();
            ListViewAdapter lv=new ListViewAdapter(MainActivity.this,ParseJson.id,ParseJson.name,ParseJson.email,ParseJson.password,ParseJson.mobile);
            obj.setAdapter(lv);

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }


    }


}
