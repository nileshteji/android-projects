package com.example.listviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    String data[] = {
            "asdasd","qweqwe","CBITSS","TEchnologies",
            "asdasd","qweqwe","CBITSS","TEchnologies",
            "asdasd","qweqwe","CBITSS","TEchnologies",
            "asdasd","qweqwe","CBITSS","TEchnologies"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);

        ArrayAdapter ad = new ArrayAdapter(MainActivity.this, R.layout.listlayout, data);

        listView.setAdapter(ad);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, data[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
