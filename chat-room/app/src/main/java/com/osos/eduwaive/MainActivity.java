package com.osos.eduwaive;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Nilesh";
    SignInButton googleButton;
FirebaseAuth auth;
GoogleSignInClient sign;
final int REQ_CODE=1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        googleButton=findViewById(R.id.GoogleSign);
        auth=FirebaseAuth.getInstance();
        GoogleSignInOptions googleSignInOptions=new
                GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        //This is Giving A verifier Error I don't Know why 
//        sign=GoogleSignIn.getClient(this,googleSignInOptions);
        sign=GoogleSignIn.getClient(MainActivity.this,googleSignInOptions);




        googleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(sign.getSignInIntent()),REQ_CODE);

            }
        });


    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==REQ_CODE){
            Task<GoogleSignInAccount> googleSignInAccountTask= GoogleSignIn.getSignedInAccountFromIntent(data);

            try{
                GoogleSignInAccount account= googleSignInAccountTask.getResult();
                firebaseLogin(account);
            }

            catch (Exception e){
                Log.d(TAG, "onActivityResult: "+e);
            }


        }
    }



    private void firebaseLogin(GoogleSignInAccount account)

    {
        AuthCredential credential= GoogleAuthProvider.getCredential(account.getIdToken(),null);
        auth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                   startActivity(new Intent(MainActivity.this,Main2Activity.class));
                }
                else {
                    Toast.makeText(MainActivity.this, "Bye Bitches", Toast.LENGTH_SHORT).show();
                }

            }



        });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}
