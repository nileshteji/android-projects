package com.osos.loginsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Content extends AppCompatActivity {
FirebaseAuth obj;
Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        obj=FirebaseAuth.getInstance();
        logout=findViewById(R.id.button);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    obj.signOut();
                Intent back=new Intent(Content.this,Sign.class);
                back.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(back);

            }
        });



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent back=new Intent(Content.this,Sign.class);
        back.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(back);

    }
}
