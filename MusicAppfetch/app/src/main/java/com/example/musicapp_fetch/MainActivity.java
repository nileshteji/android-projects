package com.example.musicapp_fetch;

import android.database.Cursor;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView lv;
Button bb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(R.id.listview);
        bb=(Button)findViewById(R.id.button);
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncClass obj=new AsyncClass();
                obj.execute();
            }
        });
    }

    class AsyncClass extends AsyncTask<Void,Void, ArrayList<String>>{


        @Override
        protected void onPreExecute() {

            super.onPreExecute();

        }

        @Override
        protected ArrayList<String> doInBackground(Void... voids) {
            ArrayList<String> ad=new ArrayList<>();
            Cursor c=getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,null,null,null,null);
            while(c.moveToNext()){
                String str=c.getString(c.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME));
                ad.add(str);
            }
            return ad;
        }

        @Override
        protected void onPostExecute(ArrayList<String> strings) {
            super.onPostExecute(strings);
            ArrayAdapter aa=new ArrayAdapter(MainActivity.this,R.layout.layout,strings);
            lv.setAdapter(aa);



        }
    }

}

