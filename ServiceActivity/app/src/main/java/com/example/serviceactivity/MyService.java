package com.example.serviceactivity;


import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyService extends Service {

    MediaPlayer mp;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
        public int onStartCommand(Intent intent, int flags, int startId) {
        mp = MediaPlayer.create(getApplicationContext(), R.raw.ringtone);
        mp.setLooping(true);
        mp.start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
     public void onDestroy() {
        super.onDestroy();

        if(mp.isPlaying())
        {
            mp.stop();
        }

    }
}

