package com.osos.eduwaive;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class FirebaseMessageService extends FirebaseMessagingService {

    //This is the method which is used to catch the Firebase Cloud Messageing Notification
    //So we Can do Anything in this .So Simply I did was make a Toast .But we Can also use
    //Notification using Notification Builder and Manager
    // and Also Some Changes are made in Manifest Because this is Service like a Brodcast Listener
    // So it need to be Defined in the Manifest

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.d("Recieved",remoteMessage.getNotification().getBody()+" "+remoteMessage.getNotification().getTitle());
    }

}
