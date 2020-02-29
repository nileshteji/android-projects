package com.example.booksshelf;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

class MyAdapter extends BaseAdapter{
Context c;
String[] text={"Effective java","clean code" };
int[] images={R.raw.download1,R.raw.download};


  MyAdapter(Context c){
       this.c=c;
  }
    public int getCount() {
        return text.length;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater obj1=LayoutInflater.from(c);
        View obj2=obj1.inflate(R.layout.layout1,null);
        ImageView obj3=(ImageView) obj2.findViewById(R.id.imageView);
        Button obj4=(Button)obj2.findViewById(R.id.button);

        obj3.setImageResource(images[position]);
        obj4.setText(text[position]);
        obj4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c, text[position], Toast.LENGTH_SHORT).show();
            }
        });
           return obj2;

    }
}

public class MainActivity extends AppCompatActivity {
    GridView obj;

    Button obj1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        obj = (GridView) findViewById(R.id.grid);
        obj1=(Button)findViewById(R.id.button);
        MyAdapter obj1 = new MyAdapter(MainActivity.this);
        obj.setAdapter(obj1);
        obj.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent obj3 = new Intent(MainActivity.this, Main2Activity.class);
                    String a = "java";
                    obj3.putExtra("position", a);
                    startActivity(obj3);

                } else if (position == 1) {
                    Intent obj4 = new Intent(MainActivity.this, Main2Activity.class);
                    String b = "effecgtive code";
                    obj4.putExtra("position", b);
                    startActivity(obj4);

                }

            }
        });
    }
}


