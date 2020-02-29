package com.example.musicplayer;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

class MyView extends BaseAdapter{

Context c;
int[] images={R.drawable.jaani,R.drawable.deanlewis};
String[] text={"jaani vi jaani","be alright"};


   MyView(Context c){
       this.c=c;

   }
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       LayoutInflater obj=LayoutInflater.from(c);
       View v=obj.inflate(R.layout.layout,null);
        ImageView obj1=(ImageView)v.findViewById(R.id.imageView);
        TextView obj2=(TextView)v.findViewById(R.id.textView);
        obj1.setImageResource(images[position]);
        obj2.setText(text[position]);
        return v;
}
}

public class MainActivity extends AppCompatActivity {
    GridView obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      obj=(GridView)findViewById(R.id.grid);
      MyView obj1=new MyView(MainActivity.this);
      obj.setAdapter(obj1);

     obj.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                        if (position == 0) {
                                            Intent obj4 = new Intent(MainActivity.this, jaaniActivity.class);

                                            startActivity(obj4);

                                        } else if (position == 1) {
                                            Intent obj5 = new Intent(MainActivity.this, deanLewis.class);
                                            startActivity(obj5);
                                        }
                                    }

                                });





    }

    }




