package com.example.test3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;


class FruitAdapter extends BaseAdapter{

Context c;
int[] images={R.drawable.apple,R.drawable.banana,R.drawable.mango,R.drawable.pear,R.drawable.strwaberry};

    FruitAdapter(Context c)
        {
      this.c=c;

    }
    @Override
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
        ImageView obj2=new ImageView(c);
        obj2.setLayoutParams(new ViewGroup.LayoutParams(400,400));
        obj2.setImageResource(images[position]);
        return obj2;

    }
}
public class
FruitActivity extends AppCompatActivity {
GridView obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);
        obj=(GridView)findViewById(R.id.grid);
        FruitAdapter obj1=new FruitAdapter(FruitActivity.this);
        obj.setAdapter(obj1);
    obj.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if(position==0){
                Intent obj=new Intent(FruitActivity.this,Fruit1Activity.class);
                obj.putExtra("image",R.drawable.apple);
                startActivity(obj);

            }
        }
    });


    }
}
