package com.osos.blushed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.osos.blushed.Model.Message;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class Adapter extends RecyclerView.Adapter<Adapter.Holder> {


    ArrayList<Message> list;
    Context c;




    Adapter(Context c, ArrayList<Message> obj){
        this.c=c;
        list=obj;

    }



    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(c).inflate(R.layout.chat,parent,false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

          if(list.get(position).getImage()==1){
            holder.imageView.setVisibility(View.VISIBLE);
              holder.there.setVisibility(View.INVISIBLE);
              holder.me.setVisibility(View.INVISIBLE);
              holder.center.setVisibility(View.INVISIBLE);


        }


       else if(list.get(position).getPerson().equals("Me") && list.get(position).getImage()==0){
            holder.center.setVisibility(View.INVISIBLE);
            holder.imageView.setVisibility(View.INVISIBLE);
            holder.there.setVisibility(View.INVISIBLE);
            holder.me.setText(list.get(position).getData());

        }
        else if(list.get(position).getPerson().equals("They") && list.get(position).getImage()==0){
            holder.center.setVisibility(View.INVISIBLE);
            holder.me.setVisibility(View.INVISIBLE);
            holder.imageView.setVisibility(View.INVISIBLE);
            holder.there.setText(list.get(position).getData());

        }
        else{
            holder.me.setVisibility(View.INVISIBLE);
            holder.imageView.setVisibility(View.INVISIBLE);
            holder.there.setVisibility(View.INVISIBLE);
            holder.center.setText(list.get(position).getData());
        }



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder {

TextView center,there,me;
ConstraintLayout con;
ImageView imageView;

        public Holder(@NonNull View itemView) {
            super(itemView);
            center=itemView.findViewById(R.id.textView);
            me=itemView.findViewById(R.id.textView2);
            imageView=itemView.findViewById(R.id.imageView);
            there=itemView.findViewById(R.id.textView3);
            con=itemView.findViewById(R.id.con1);

            con.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {if(c instanceof MainActivity){
                  ((MainActivity) c).updateUi();
                }

                }
            });



        }

    }
}
