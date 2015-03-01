package com.andriod.upc.exercici_registre;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;


public class NouRegistre extends Activity {

    public final static String EXTRA_NOM = "com.mycompany.myfirstapp.EXTRA_NOM";
    public final static String EXTRA_COGNOM = "com.mycompany.myfirstapp.EXTRA_COGNOM";
    public final static String EXTRA_GENERE = "com.mycompany.myfirstapp.EXTRA_GENERE";
    public final static String EXTRA_ACTIVITAT_ESTUDIAR = "com.mycompany.myfirstapp.EXTRA_ACTIVITAT_ESTUDIAR";
    public final static String EXTRA_ACTIVITAT_TREBALLAR = "com.mycompany.myfirstapp.EXTRA_ACTIVITAT_TREBALLAR";
    public final static String EXTRA_ESTUDIS = "com.mycompany.myfirstapp.EXTRA_ESTUDIS";
    public final static String EXTRA_PES = "com.mycompany.myfirstapp.EXTRA_PES";
    public final static String EXTRA_NAIXEMENT = "com.mycompany.myfirstapp.EXTRA_NAIXEMENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nou_registre);

        final SeekBar bar = (SeekBar) findViewById(R.id.seekBar);
        final TextView text = (TextView) findViewById(R.id.textView2);

        SeekBar.OnSeekBarChangeListener listener = new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                String f = String.format("Pes: %d", 30+i);
                text.setText(f);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };

        bar.setOnSeekBarChangeListener(listener);
    }

    public void ClickRegistrar(View v) {

        Intent intent = new Intent(this, MostrarResultat.class);


        final EditText wNom = (EditText) findViewById(R.id.editText);
        final EditText wCognom = (EditText) findViewById(R.id.editText2);
        final RadioButton wGenereHome = (RadioButton) findViewById(R.id.radioButton);
        final CheckBox wEstudiar = (CheckBox) findViewById(R.id.checkBox);
        final CheckBox wTreballar = (CheckBox) findViewById(R.id.checkBox2);
        final SeekBar wPes = (SeekBar) findViewById(R.id.seekBar);
        final EditText wNaixament = (EditText) findViewById(R.id.editText3);
        final Switch wCarrera = (Switch) findViewById(R.id.switch1);

        intent.putExtra(EXTRA_NOM, wNom.getText().toString());
        intent.putExtra(EXTRA_COGNOM, wCognom.getText().toString());
        intent.putExtra(EXTRA_GENERE, wGenereHome.isChecked());
        intent.putExtra(EXTRA_ACTIVITAT_ESTUDIAR, wEstudiar.isChecked());
        intent.putExtra(EXTRA_ACTIVITAT_TREBALLAR, wTreballar.isChecked());
        intent.putExtra(EXTRA_PES, wPes.getProgress());
        intent.putExtra(EXTRA_NAIXEMENT, wNaixament.getText().toString());
        intent.putExtra(EXTRA_ESTUDIS, wCarrera.isChecked());

        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_nou_registre, menu);
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
            ClickRegistrar(findViewById(id));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
