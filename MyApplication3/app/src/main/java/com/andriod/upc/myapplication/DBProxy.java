package com.andriod.upc.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by Done on 16/3/15.
 */
public class DBProxy extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "MyNotes.db";
    public static final String DB_TABLE = "notes";
    public static final String DB_COL_ID = BaseColumns._ID;
    public static final String DB_COL_TITLE = "title";
    public static final String DB_COL_BODY = "body";

    public DBProxy(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+DB_TABLE+" ("+DB_COL_ID+" INTEGER PRIMARY KEY, "+DB_COL_TITLE+" TEXT, "+DB_COL_BODY+" TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long addNote(String title, String body)
    {
        SQLiteDatabase db = getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.putNull(DB_COL_ID);
        values.put(DB_COL_TITLE, title);
        values.put(DB_COL_BODY, body);

        // Insert the new row, returning the primary key value of the new row
        return db.insert(DB_TABLE, null, values);
    }

    public Cursor readNotes()
    {
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {
                DB_COL_ID,
                DB_COL_TITLE,
                DB_COL_BODY,
        };

        return db.query(DB_TABLE, projection, null, null, null, null, null);
    }

    public void updateNote(long id, String title, String body)
    {
        SQLiteDatabase db = getWritableDatabase();

        // New value for one column
        ContentValues values = new ContentValues();
        values.put(DB_COL_TITLE, title);
        values.put(DB_COL_BODY, body);

        // Which row to update, based on the ID
        String selection = DB_COL_ID + " LIKE ?";
        String[] selectionArgs = { String.valueOf(id) };

        int count = db.update(
                DB_TABLE,
                values,
                selection,
                selectionArgs);
    }
}
