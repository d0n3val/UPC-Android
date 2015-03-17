package com.andriod.upc.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.List;


public class EnterNewNote extends ActionBarActivity {

    long editing_id = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = getIntent();
        editing_id = i.getLongExtra("id", -1);

        TextView title = (TextView) findViewById(R.id.title);
        TextView body = (TextView) findViewById(R.id.body);

        title.setText("");
        body.setText("");

        if(editing_id >= 0)
        {
            title.setText(i.getStringExtra("title"));
            body.setText(i.getStringExtra("body"));
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPause()
    {
        super.onPause();

        TextView title = (TextView) findViewById(R.id.title);
        TextView body = (TextView) findViewById(R.id.body);

        if(editing_id < 0) {
            ListAllNotes.db.addNote(title.getText().toString(), body.getText().toString());
        }
        else
        {
            ListAllNotes.db.updateNote(editing_id, title.getText().toString(), body.getText().toString());
        }
    }
}
