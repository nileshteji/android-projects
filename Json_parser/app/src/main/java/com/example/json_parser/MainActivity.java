package com.example.json_parser;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button obj;

    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        obj = findViewById(R.id.button);
        obj.setOnClickListener(this);
        lv = findViewById(R.id.listView);
    }

    @Override
    public void onClick(View v) {
        if (v == obj) {
            sendrequest();
        }
    }


    public void sendrequest() {

        final ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("Please Wait...");
        pd.setCancelable(false);
        pd.show();

        StringRequest obj12 = new StringRequest(Request.Method.POST, "https://surrounding-wingnut.000webhostapp.com/json.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        showjson(response);
                        pd.dismiss();
                    }
                }
                ,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                        pd.dismiss();
                    }
                }
        );
        RequestQueue obj= Volley.newRequestQueue(this);
        obj.add(obj12);

    }


    public void showjson(String json) {
        ParserJSON pj = new ParserJSON(json);
        pj.parseJSON();
        CustomList cl = new CustomList(this, ParserJSON.name, ParserJSON.email, ParserJSON.username, ParserJSON.password);
        lv.setAdapter(cl);
    }

}
