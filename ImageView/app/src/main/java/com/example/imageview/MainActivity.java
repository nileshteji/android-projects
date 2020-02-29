package com.example.imageview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

 class CustomAdapter extends BaseAdapter {
    Context c;

    CustomAdapter(Context c) {
        this.c = c;
    }

    int[] images = {R.drawable.abcd, R.drawable.abcde};

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
        ImageView obj = new ImageView(c);
        obj.setLayoutParams(new ViewGroup.LayoutParams(350, 350));
        obj.setImageResource(images[position]);
        return obj;
    }
}


 class MainActivity extends AppCompatActivity {
 GridView obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        obj=(GridView)findViewById(R.id.Grid);
      CustomAdapter ob=new CustomAdapter(MainActivity.this);
        obj.setAdapter(ob);

        obj.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, ""+position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
