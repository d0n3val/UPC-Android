package com.andriod.upc.myapplication;

import android.app.ActionBar;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TableRow;
import android.widget.TextView;


public class ListAllNotes extends ActionBarActivity implements AdapterView.OnItemClickListener {

    public static DBProxy db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);
        db = new DBProxy(this);

        Cursor c = db.readNotes();

        String[] fromColumns = {db.DB_COL_TITLE, db.DB_COL_BODY};
        int[] toViews = {R.id.title, R.id.note};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                this,
                R.layout.note_row,
                c,
                fromColumns,
                toViews,
                0 );

        ListView list = (ListView) findViewById(R.id.listView);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    public void AddNewNote(View v)
    {
        startActivity(new Intent(this, EnterNewNote.class));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent(this, EnterNewNote.class);

        i.putExtra("id", id);
        i.putExtra("title", ((TextView) view.findViewById(R.id.title)).getText().toString());
        i.putExtra("body", ((TextView) view.findViewById(R.id.note)).getText().toString());

        startActivity(i);
    }
}
