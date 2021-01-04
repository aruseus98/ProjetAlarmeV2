package com.licence.projetalarme;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class RingtonePlayingService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Log.i("LocalService", "Received start id " + startdId + ": " + intent);
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy(){
        //Dit à l'utilisateur que la notification a été stoppée
        Toast.makeText(this, "on Destroy call", Toast.LENGTH_SHORT).show();
    }



}
