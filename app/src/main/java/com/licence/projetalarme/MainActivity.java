package com.licence.projetalarme;

import android.app.AlarmManager;
import android.content.Context;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    //Pour faire notre alarme manager
    AlarmManager alarm_manager;
    TimePicker alarm_timepicker;
    TextView update_text;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.context = this;

        // Initialisation de notre gestionnaire d'alarme
        alarm_manager = (AlarmManager) getSystemService(ALARM_SERVICE);

        // Initialisation de notre horloge
        alarm_timepicker = (TimePicker) findViewById(R.id.timePicker);

        // Initialisation du champ de texte qui se met à jour
        update_text = (TextView) findViewById(R.id.update_text);

        // Création d'une instance d'un calendrier
        Calendar calendar = Calendar.getInstance();

        //Initialisation du bouton start
        Button start_alarm = (Button) findViewById(R.id.alarm_on);
        //Création d'un onClick listener pour lancer l'alarme


        //Initialisation du bouton stop
        Button alarm_off = (Button) findViewById(R.id.alarm_off);
        //Création d'un onClick listener pour stopper l'alarme
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}