package com.example.json_parser1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListViewAdapter  extends BaseAdapter {
    Context c;
    String[] id;
    String[] name;
    String[] email;
    String[] address;
    String[] mobile;

    ListViewAdapter(Context c,String[] id,String[] name,String[] email,String[] address,String[] mobile){
        this.c=c;
        this.id=id;
        this.name=name;
        this.email=email;
        this.address=address;
        this.mobile=mobile;
    }


    @Override
    public int getCount() {
        return id.length;
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
        View v=obj.inflate(R.layout.lsitviewlayout,null);
        TextView tv=v.findViewById(R.id.textView);
        TextView tv2=v.findViewById(R.id.textView2);
        TextView tv3=v.findViewById(R.id.textView3);
        TextView tv4=v.findViewById(R.id.textView4);
        TextView tv5=v.findViewById(R.id.textView5);
        tv.setText(id[position]);
        tv2.setText(name[position]);
        tv3.setText(email[position]);
        tv4.setText(address[position]);
        tv5.setText(mobile[position]);
        return v;

    }
}
