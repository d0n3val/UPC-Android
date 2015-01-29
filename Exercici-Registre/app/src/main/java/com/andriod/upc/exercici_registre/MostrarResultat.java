package com.andriod.upc.exercici_registre;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MostrarResultat extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i = getIntent();

        String r = "--- Resultats ---\n";

        String genere = "Masculi";
        if(i.getBooleanExtra(NouRegistre.EXTRA_GENERE, false) == false)
            genere = "Femeni";

        r += String.format("Nom: %s\n", i.getStringExtra(NouRegistre.EXTRA_NOM));
        r += String.format("Cognom: %s\n", i.getStringExtra(NouRegistre.EXTRA_COGNOM));
        r += String.format("Genere: %s\n", genere);
        r += String.format("Activitat: %s %s\n",
                (i.getBooleanExtra(NouRegistre.EXTRA_ACTIVITAT_ESTUDIAR, false)) ? "Estudia" : "",
                (i.getBooleanExtra(NouRegistre.EXTRA_ACTIVITAT_TREBALLAR, false)) ? "Treballa" : "");
        r += String.format("Naixament: %s\n", i.getStringExtra(NouRegistre.EXTRA_NAIXEMENT));
        r += String.format("Pes: %d\n", i.getIntExtra(NouRegistre.EXTRA_PES, 0));
        r += String.format("Estudis: %s\n", (i.getBooleanExtra(NouRegistre.EXTRA_ESTUDIS, false)) ? "Carrera" : "Cap");

        setContentView(R.layout.activity_mostrar_resultat);

        TextView text = (TextView) findViewById(R.id.textView3);
        text.setText(r);
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
