package com.licence.projetalarme;


import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class RingtonePlayingService extends Service {

    MediaPlayer media_song;
    int startId;
    boolean isRunning;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Log.i("LocalService", "Received start id " + startId + ": " + intent);

        // fetch la valeur extra
        String state = intent.getExtras().getString("extra");

        Log.e("Ringtone state:extra is", state);

        // Converti la valeur extra de intent
        assert  state !=null;
        switch (state){
            case "alarm on" :
                startId = 1;
                break;
            case "alarm off" :
                startId = 0;
                break;
            default:
                startId = 0;
                break;
        }

        //if else statements
        //S'il n'y a pas de sonnerie en cours et que l'utilisateur appuie sur ON
        //La sonnerie se lance
        if (!this.isRunning && startId == 1) {
            Log.e("Il n'y a pas de musique", "Commencé");

            //Création d'une instance de media player
            media_song = MediaPlayer.create(this, R.raw.sonnerie);
            // Lance la sonnerie
            media_song.start();

            this.isRunning = true;
            this.startId = 0;

            //Mise en place du service de notification
            NotificationManager notify_manager = (NotificationManager)
                    getSystemService(NOTIFICATION_SERVICE);

            //Mise en place d'un intent qui ira dans Main activity
            Intent intent_main_activity = new Intent(this.getApplicationContext(), MainActivity.class);

            //Mise en place d'une requête
            PendingIntent pending_intent_main_activity = PendingIntent.getActivity(this, 0,
                    intent_main_activity, 0);

            //Paramètrage des notifications
            Notification notification_popup = new Notification.Builder(this)
                    .setSmallIcon(R.drawable.logo)
                    .setContentTitle("An alarm is going off !")
                    .setContentText("Click me !")
                    .setContentIntent(pending_intent_main_activity)
                    .setAutoCancel(true)
                    .build();

            notify_manager.notify(0, notification_popup);

        }

        //S'il y a une sonnerie en cours et que l'utilisateur appuie sur OFF
        //la sonnerie s'arrête
        else if (this.isRunning && startId == 0) {
            Log.e("Il y a de la musique", "Fin");

            //Arrête la sonnerie
            media_song.stop();
            media_song.reset();

            this.isRunning = false;
            this.startId = 0;
        }

        // Cas où l'utilisateur appuye sur des boutons aléatoirement
        //S'il n'y a pas de sonnerie et que l'utilisateur appuie sur OFF
        // Ne rien faire
        else if (!this.isRunning && startId == 0) {
            Log.e("Il y a de la musique", "Commencé");

            this.isRunning = false;
            this.startId = 0;

        }
        // S'il y a une sonnerie en cours et que l'utilisateur appuie sur ON
        // Ne rien faire
        else if (this.isRunning && startId == 1) {
            Log.e("Il y a de la musique", "Fin");

            this.isRunning = true;
            this.startId = 1;
        }
        // Récupère les événements
        else {
            Log.e("Il y a de la musique", "Fin");
        }



        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy(){
        //Fermeture de l'application

        super.onDestroy();
        this.isRunning = false;
    }



}
