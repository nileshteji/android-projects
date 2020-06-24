package com.android.smartreply;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.smartreply.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.mlkit.nl.smartreply.SmartReply;
import com.google.mlkit.nl.smartreply.SmartReplyGenerator;
import com.google.mlkit.nl.smartreply.SmartReplySuggestionResult;
import com.google.mlkit.nl.smartreply.TextMessage;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
List<TextMessage> list;
final String userID="Teji";
final String TAG="MainActivity";
ActivityMainBinding mainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        list=new ArrayList<>();
        list.add(TextMessage.createForRemoteUser("Hello",System.currentTimeMillis(),userID));

        final SmartReplyGenerator smartReplyGenerator= SmartReply.getClient();
        smartReplyGenerator.suggestReplies(list)
                .addOnSuccessListener(new OnSuccessListener<SmartReplySuggestionResult>() {
                    @Override
                    public void onSuccess(SmartReplySuggestionResult smartReplySuggestionResult) {
                        if(smartReplySuggestionResult.getStatus()==SmartReplySuggestionResult.STATUS_SUCCESS){
                              mainBinding.text.setText(smartReplySuggestionResult.getSuggestions().get(0).getText());
                            Log.d(TAG, "onSuccess: "+ smartReplySuggestionResult.getSuggestions());
                        }
                        else if(smartReplySuggestionResult.getStatus()==SmartReplySuggestionResult.STATUS_NO_REPLY){
                            mainBinding.text.setText("No Reply");
                        }
                        else if(smartReplySuggestionResult.getStatus()==SmartReplySuggestionResult.STATUS_NOT_SUPPORTED_LANGUAGE){
                            mainBinding.text.setText("Not Suppourted");
                        }
                        else{
                            mainBinding.text.setText("Else");

                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                     mainBinding.text.setText(e.getClass().getSimpleName());
                    }
                });






    }
}