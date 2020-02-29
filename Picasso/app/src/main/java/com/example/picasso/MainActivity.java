
package com.example.picasso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView obj=findViewById(R.id.imageview);
        Picasso.with(MainActivity.this).load("https://yt3.ggpht.com/a/AGF-l7-BBIcC888A2qYc3rB44rST01IEYDG3uzbU_A=s900-mo-c-c0xffffffff-rj-k-no").into(obj);
    }
}
