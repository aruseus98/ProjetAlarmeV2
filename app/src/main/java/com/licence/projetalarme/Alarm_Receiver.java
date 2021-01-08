package com.licence.projetalarme;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class Alarm_Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("Nous somme receveur", "Excellent");

        // Fetch extra strings from the intent
        String get_your_string = intent.getExtras().getString("extra");

        Log.e("Quel est la clé ?", get_your_string);

        //Création d'un intent pour faire le service de sonnerie
        Intent service_intent = new Intent(context, RingtonePlayingService.class);

        // passe l'extra string du main activity au Ringtone Playing service
        service_intent.putExtra("extra", get_your_string);

        //Lancement du service de sonnerie
        context.startService(service_intent);
    }
}
