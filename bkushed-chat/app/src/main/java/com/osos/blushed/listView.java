package com.osos.blushed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.osos.blushed.Model.Message;

import java.util.ArrayList;

public class listView extends BaseAdapter {
    ArrayList<Message> boj;
    Context c;
    listView(ArrayList<Message> boj,Context c){

        this.boj=boj;
        this.c=c;
    }
    @Override
    public int getCount() {
        return boj.size();
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
        View v= LayoutInflater.from(c).inflate(R.layout.chat,parent,false);
        TextView center=v.findViewById(R.id.textView);
        TextView me=v.findViewById(R.id.textView2);
        TextView there=v.findViewById(R.id.textView3);

        if(boj.get(position).getPerson().equals("Me")){
            center.setVisibility(View.INVISIBLE);
            me.setText(boj.get(position).getData());
            there.setVisibility(View.INVISIBLE);
        }
        else if(boj.get(position).getPerson().equals("They")){
            center.setVisibility(View.INVISIBLE);
            there.setText(boj.get(position).getData());
            me.setVisibility(View.INVISIBLE);
        }
        else{
            there.setVisibility(View.INVISIBLE);
            center.setText(boj.get(position).getData());
            me.setVisibility(View.INVISIBLE);
        }

        return v;

    }
}
