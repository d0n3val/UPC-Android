package com.example.done.fragment_test;


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements OnFragmentMessage {

    boolean showing_frag1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            return;
        }

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container1, new Frag1())
                .commit();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container2, new Frag2())
                .commit();

        showing_frag1 = true;
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
        if (id == R.id.action_switch) {
            /*
            if(showing_frag1 == true)
            {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container1, new Frag1())
                        .commit();

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container2, new Frag2())
                        .commit();
            }
            else
            {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container2, new Frag1())
                        .commit();

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container1, new Frag2())
                        .commit();
            }
            showing_frag1 = !showing_frag1;
            */
        }

        return super.onOptionsItemSelected(item);
    }

    public void Button1(View v)
    {
        Frag1 f = (Frag1) getSupportFragmentManager().findFragmentById(R.id.fragment_container1);
        if(f != null) {
            f.ShowMessage("Message to Frag1!");
        }
    }

    public void Button2(View v)
    {
        Frag2 f = (Frag2) getSupportFragmentManager().findFragmentById(R.id.fragment_container2);
        if(f != null) {
            f.ShowMessage("Message to Frag2!");
        }
    }

    @Override
    public void onFragmentMessage(String message) {
        TextView t = (TextView) findViewById(R.id.hello_world);
        t.setText(message);
    }
}
