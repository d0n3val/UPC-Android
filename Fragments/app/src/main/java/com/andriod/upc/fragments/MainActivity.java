package com.andriod.upc.fragments;

import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container1, new Frag1())
                    .commit();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container2, new Frag2())
                    .commit();
        }
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

        if (id == R.id.action_frag1) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container2, new Frag1()).commit();
            getSupportFragmentManager().beginTransaction().replace(R.id.container1, new Frag2()).commit();
            return true;
        }

        if (id == R.id.action_frag2) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container1, new Frag1()).commit();
            getSupportFragmentManager().beginTransaction().replace(R.id.container2, new Frag2()).commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Frag1
     */
    public static class Frag1 extends Fragment {

        public Frag1() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

    /**
     * Frag2
     */
    public static class Frag2 extends Fragment {

        public Frag2() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_frag2, container, false);
            return rootView;
        }
    }
}
