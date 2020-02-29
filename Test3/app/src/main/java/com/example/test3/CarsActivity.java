package com.example.test3;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

class CarAdapter extends BaseAdapter{
Context context;
int[] List={R.drawable.car1,R.drawable.car2,R.drawable.car3,R.drawable.car5,R.drawable.car6};

    CarAdapter(Context context){
        this.context=context;

    }
    public int getCount() {
        return List.length;
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
        ImageView obj2=new ImageView(context);
        obj2.setLayoutParams(new ViewGroup.LayoutParams(600,600));
        obj2.setImageResource(List[position]);
        return obj2;

    }
}

public class CarsActivity extends AppCompatActivity {
GridView obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars);
        obj=(GridView)findViewById(R.id.grid);
        CarAdapter obj1=new CarAdapter(CarsActivity.this);
        obj.setAdapter(obj1);




    }
}
