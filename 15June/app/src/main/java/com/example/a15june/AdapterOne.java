package com.example.a15june;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

class AdapterOne extends  RecyclerView.Adapter<AdapterOne.HolderOne> {

Context c;

   ArrayList<String> data;
    AdapterOne(Context c,ArrayList<String> data){
this.c=c;
this.data=data;
    }

    public HolderOne onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View V= LayoutInflater.from(c).inflate(R.layout.rcone,viewGroup,false);
        HolderOne obj=new HolderOne(V);
        return obj;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderOne holderOne, int i) {
//holderOne.tv.setText(boj.);
holderOne.tv.setText(data.get(i));





    }

    @Override
    public int getItemCount() {
       return data.size();
    }

    class HolderOne extends RecyclerView.ViewHolder{
        TextView tv;

        public HolderOne(@NonNull View itemView) {
            super(itemView);

            tv=itemView.findViewById(R.id.tv);

        }
    }
}



