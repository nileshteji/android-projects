package com.example.a17june;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
WebView boj;
Button boj1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boj=findViewById(R.id.id1);

        boj1 = findViewById(R.id.id2);


        boj.loadUrl("https://www.google.com");
        boj.setWebViewClient(new ClassOne());
        boj.getSettings().setJavaScriptEnabled(true);

        boj.getSettings().setLoadsImagesAutomatically(true);

        boj1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj1=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(obj1);
            }
        });


    }

    @Override
    public void onBackPressed() {

      if(  boj.canGoBack()){
          boj.goBack();
      }
      else{
          super.onBackPressed();
      }
    }



    class ClassOne extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl("https://www.google.com");
            return super.shouldOverrideUrlLoading(view, request);
        }
    }
}




