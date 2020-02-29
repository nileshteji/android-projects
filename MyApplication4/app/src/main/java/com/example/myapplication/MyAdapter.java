package com.example.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

    int images[] = {
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher
    };

    String text[] = {
            "Abcd 1",
            "Abcd 2",
            "Abcd 3",
            "Abcd 4",
            "Abcd 5",
            "Abcd 6",
            "Abcd 7",
            "Abcd 8"
    };

    Context c;

    MyAdapter(Context c)
    {
        this.c=c;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(c).inflate(R.layout.mylayout, viewGroup, false);
        MyHolder h = new MyHolder(v);

        return h;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
        myHolder.tv.setText(text[i]);
        myHolder.im.setLayoutParams(new ViewGroup.LayoutParams(300,150));
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    class MyHolder extends RecyclerView.ViewHolder
    {
        ImageView im;
        TextView tv;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            im = (ImageView)itemView.findViewById(R.id.image1);
            tv = (TextView)itemView.findViewById(R.id.text1);
        }
    }
}
