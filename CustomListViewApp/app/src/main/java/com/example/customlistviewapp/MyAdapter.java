package com.example.customlistviewapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

    int image[]={
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher
    };

    String txt[] = {
            "Picture 1",
            "Picture 2",
            "Picture 3",
            "Picture 4",
            "Picture 5",
            "Picture 6"
    };

    Context c;

    MyAdapter(Context c)
    {
        this.c=c;

    }

    @Override
    public int getCount() {
        return txt.length;
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
        LayoutInflater li = LayoutInflater.from(c);

        View v = li.inflate(R.layout.customlayout, null);

        TextView tv = (TextView)v.findViewById(R.id.textView);

        ImageView iv = (ImageView)v.findViewById(R.id.imageview);

        tv.setText(txt[position]);
        iv.setImageResource(image[position]);

        return v;
    }
}
