package com.example.contentprovider;

import android.app.ProgressDialog;
import android.database.Cursor;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button obj;
    ListView obj1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        obj=(Button)findViewById(R.id.button);
        obj1=(ListView)findViewById(R.id.listview);
obj.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
     H h=new H();
     h.execute();
    }
});

    }

    public  class  H extends AsyncTask<Void,Void,ArrayList<String>>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected ArrayList<String> doInBackground(Void... voids) {
            ArrayList<String> ad=new ArrayList<>();
            Cursor c=getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
           while (c.moveToNext())
           {
                   String str=c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
               String str1=c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
               ad.add(str+" "+str1);
           }

            return ad;
        }

        @Override
        protected void onPostExecute(ArrayList<String> strings) {
            super.onPostExecute(strings);
            ArrayAdapter ad=new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,strings);
            obj1.setAdapter(ad);
        }
    }
}
