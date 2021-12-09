package com.osos.eduwaive.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.osos.eduwaive.Model.Message;
import com.osos.eduwaive.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageHolder> {

Context c;
ArrayList<Message> boj;
public MessageAdapter(){

}

    public MessageAdapter(Context c, ArrayList<Message> list){
this.c=c;
boj=list;
    }


    @NonNull
    @Override
    public MessageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(c).inflate(R.layout.chatres,parent,false);
        return new MessageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageHolder holder, int position) {
        holder.message.setText(boj.get(position).getMessage());
        holder.username.setText(boj.get(position).getUsername());

    }

    @Override
    public int getItemCount() {
        return boj.size();
    }

    class MessageHolder extends RecyclerView.ViewHolder{
        TextView username;
        TextView message;

        public MessageHolder(@NonNull View itemView) {
            super(itemView);
            username=itemView.findViewById(R.id.username);
            message=itemView.findViewById(R.id.message_body);

        }
    }
}
