package com.example.musicplayer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.MediaStore;
import android.widget.Toast;

import java.net.URISyntaxException;

public class PlayService extends Service {
    MediaPlayer mp;

    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        mp=MediaPlayer.create(getApplicationContext(),R.raw.jaanisong);
        mp.setLooping(true);
        mp.start();
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mp.isPlaying()){
            mp.stop();
        }

    }
}
