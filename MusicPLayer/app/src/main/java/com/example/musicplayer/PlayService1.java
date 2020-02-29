package com.example.musicplayer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class PlayService1 extends Service  {
    MediaPlayer mp1;
    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mp1.isPlaying()){
            mp1.stop();
        }


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mp1=MediaPlayer.create(getApplicationContext(),R.raw.dean);
        mp1.setLooping(true);
        mp1.start();

        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }
}
