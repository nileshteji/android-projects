package com.example.customlistviewapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;


class MyAdapter1 extends BaseAdapter{
Context c;
int[] images={R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background};
String[] text={"picture","picture","picture"};
    MyAdapter1(Context c){
        this.c=c;
    }
    @Override
    public int getCount() {
        return text.length;
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
        LayoutInflater obj2=LayoutInflater.from(c);
        View v=obj2.inflate(R.layout.customlayout1,null);
        ImageView image1=(ImageView)v.findViewById(R.id.imageview);
        TextView text1=(TextView)v.findViewById(R.id.textview1);
        image1.setImageResource(images[position]);
        text1.setText(text[position]);
        return v;

    }
}


public class CustomGridViewApp extends AppCompatActivity {
GridView obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_grid_view_app);
        obj=(GridView)findViewById(R.id.grid);
        MyAdapter1 ad=new MyAdapter1(CustomGridViewApp.this);
        obj.setAdapter(ad);
    }
}
