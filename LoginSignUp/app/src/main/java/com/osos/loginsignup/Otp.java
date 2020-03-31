package com.osos.loginsignup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class Otp extends AppCompatActivity {
Toolbar toolbar;
TextView details,otpError,resendOtp;
EditText otp;
FirebaseAuth mAuth;
String mVerify;

Button submit;
PhoneAuthProvider.ForceResendingToken forceResendingToken;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        toolbar=findViewById(R.id.toolbar2);
        details=findViewById(R.id.textView4);
        getSupportActionBar();
        submit=findViewById(R.id.submit);
        otp=findViewById(R.id.editText5);
        resendOtp=findViewById(R.id.textView5);


        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        final Intent intent=getIntent();
        otpError=findViewById(R.id.textView6);
        mAuth=FirebaseAuth.getInstance();
        details.setText("We have sent you an SMS on "+
                intent.getStringExtra("Value")+" with 6 Digit verification code");


        String mobile=intent.getStringExtra("Value");
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "+91"+mobile,
                60,
                TimeUnit.SECONDS
               , Otp.this,
                mCallbacks);


        resendOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             {
                 String mobile =intent.getStringExtra("Value");
                    PhoneAuthProvider.getInstance().verifyPhoneNumber(
                            mobile ,
                            60,
                            TimeUnit.SECONDS,
                            Otp.this,
                            mCallbacks,
                            forceResendingToken);
                }

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhoneAuthCredential credential=PhoneAuthProvider.getCredential(mVerify,otp.getText().toString());
                signInWithPhoneAuthCredential(credential);
            }
        });





    }




   PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onVerificationCompleted(PhoneAuthCredential credential) {
            String code = credential.getSmsCode();


            if (code != null) {
                otp.setText(code);
          PhoneAuthCredential phoneAuthCredential=PhoneAuthProvider.getCredential(mVerify,code);
          signInWithPhoneAuthCredential(phoneAuthCredential);
            }


        }

       @Override
        public void onVerificationFailed(FirebaseException e) {

            Log.w("Error", "onVerificationFailed", e);


        }

        @Override
        public void onCodeSent(@NonNull String verificationId,
                @NonNull PhoneAuthProvider.ForceResendingToken token) {
            Log.d("Value", "onCodeSent:" + verificationId);
            mVerify=verificationId;
            forceResendingToken=token;



        }
    };




    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                            Toast.makeText(Otp.this, "Welcome", Toast.LENGTH_SHORT).show();


                        else {
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                            otpError.setVisibility(View.VISIBLE);
                        }
                        }





                    }
                });
    }










}
