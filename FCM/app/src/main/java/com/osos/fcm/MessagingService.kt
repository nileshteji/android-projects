package com.osos.fcm

import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.media.Ringtone
import android.media.RingtoneManager
import android.net.Uri
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import android.app.NotificationManager as NotificationManager

class MessagingService : FirebaseMessagingService() {

    val TAG:String="Service"
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        sendNotification(remoteMessage.data["message"])

    }

    fun sendNotification(message:String?){
        var a:Intent= Intent(this,MainActivity::class.java);
        a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        var pendingIntent:PendingIntent= PendingIntent.getActivity(this,0,a,PendingIntent.FLAG_ONE_SHOT)
        val b:Uri=RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        var notificationCompat:NotificationCompat.Builder =NotificationCompat.Builder(this)
            .setSmallIcon(R.drawable.common_google_signin_btn_icon_dark)
            .setContentTitle("FCM Messaging")
            .setContentText(message)
            .setSound(b)
        var notificationManager: NotificationManager =  getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(0,notificationCompat.build())
    }
}


