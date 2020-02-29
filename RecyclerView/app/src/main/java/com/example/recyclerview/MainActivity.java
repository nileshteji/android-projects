package com.example.recyclerview;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
RecyclerView obj3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        obj3=findViewById(R.id.id);
        AdapterOne boj=new AdapterOne(MainActivity.this);
        obj3.setAdapter(boj);
        GridLayoutManager obj=new GridLayoutManager(MainActivity.this,2);
obj.setOrientation(GridLayoutManager.HORIZONTAL);
        obj3.setLayoutManager(obj);



    }
}

class AdapterOne extends RecyclerView.Adapter<AdapterOne.HolderOne> {

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
    AdapterOne(Context c){
        this.c=c;
    }
    public HolderOne onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View v=LayoutInflater.from(c).inflate(R.layout.recycle,viewGroup,false);
       HolderOne obj=new HolderOne(v);//why we do this


       return obj;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderOne holderOne, final int i) {
        holderOne.tv.setText(text[i]);
        holderOne.iv.setImageResource(images[i]);
        holderOne.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c, String.valueOf(i), Toast.LENGTH_SHORT).show();
            }
        });



    }



    @Override
    public int getItemCount() {
        return images.length;
    }

    class HolderOne extends RecyclerView.ViewHolder{
TextView tv;
ImageView iv;
LinearLayout ll;

        public HolderOne(@NonNull View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tv);
            iv=itemView.findViewById(R.id.iv);
            ll=itemView.findViewById(R.id.id1);
        }











    }
}






