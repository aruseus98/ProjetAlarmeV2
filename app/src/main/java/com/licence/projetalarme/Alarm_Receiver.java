package com.licence.projetalarme;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class Alarm_Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("Nous somme dans le receveur", "Excellent");

        //Création d'un itent pour faire le service de sonnerie
        Intent service_intent = new Intent(context, RingtonePlayingService.class);

        //Lancement du service de sonnerie
        context.startService(service_intent);
    }
}
