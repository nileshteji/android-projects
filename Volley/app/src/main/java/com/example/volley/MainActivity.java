package com.example.volley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText boj, obj1, obj2, obj3;
    Button boj4;
    ProgressBar boj1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boj = findViewById(R.id.name);
        obj1 = findViewById(R.id.username);
        obj2 = findViewById(R.id.password);
        obj3 = findViewById(R.id.email);
        boj4 = findViewById(R.id.button1);
      //g  boj1=findViewById(R.id.progressbar);
        boj4.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v == boj4) {
            final String a = boj.getText().toString();
            final String b = obj1.getText().toString();
            final String c = obj2.getText().toString();
            final String d = obj3.getText().toString();

            StringRequest sr = new StringRequest(Request.Method.POST, "https://surrounding-wingnut.000webhostapp.com/registration.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            ;
                            Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(MainActivity.this, ""+error.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
            {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> m = new HashMap<>();
                    m.put("name", a);
                    m.put("username", b);
                    m.put("email", c);
                    m.put("password", d);

                    return m;
                }
            };

            RequestQueue r = Volley.newRequestQueue(MainActivity.this);
            r.add(sr);


        }
    }
}
