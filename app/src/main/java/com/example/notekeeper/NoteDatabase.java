package com.example.notekeeper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class NoteDatabase extends SQLiteOpenHelper {
    Context context;

    public NoteDatabase(Context context) {
        super(context,"NoteKeeper.db", null, 1);
        this.context = context.getApplicationContext();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table if not exists notesTable(id integer primary key autoincrement," +
                "title text not null," +
                "content text not null," +
                "date text not null," +
                "time text not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists notesTable");
    }
}
