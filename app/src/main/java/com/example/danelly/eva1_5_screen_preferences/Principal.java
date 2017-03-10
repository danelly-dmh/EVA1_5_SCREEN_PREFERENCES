package com.example.danelly.eva1_5_screen_preferences;

import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Principal extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_principal);
        getFragmentManager().beginTransaction().replace(android.R.id.content,//que reemplazamos
                new Configuracion()).commit();//con lo que reemplazamos
        SharedPreferences spMisPref = PreferenceManager.getDefaultSharedPreferences(this);
        String sNombre = spMisPref.getString("NOMBRE", null);
        Toast.makeText(this, sNombre, Toast.LENGTH_SHORT).show();
    }

    public static class Configuracion extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferencias);
        }
    }
}