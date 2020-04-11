package com.example.notekeeper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class NoteDatabase extends SQLiteOpenHelper {
    Context context;

    public NoteDatabase(Context context) {
        super(context,"NoteKeeper.db", null, 1);
//        context.deleteDatabase("NoteKeeper.db");
        this.context = context.getApplicationContext();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table if not exists notesTable(id integer primary key autoincrement," +
                "title text not null," +
                "content text not null," +
                "date text not null," +
                "time text not null," +
                "color text not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists notesTable");
    }

    public boolean insertNote(String title, String content, String date, String time, String color) {
//        Log.d("title", title);
//        Log.d("content", content);
//        Log.d("date", date);
//        Log.d("time", time);
//        Log.d("color", color);
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", title);
        contentValues.put("content", content);
        contentValues.put("date", date);
        contentValues.put("time", time);
        contentValues.put("color", color);
        long ins = db.insert("notesTable", null, contentValues);
        if (ins == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean deleteNote (String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("notesTable", "id" + "="+id, null) > 0;
    }


    public List<NoteClass> getNoteList() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<NoteClass> noteList = new ArrayList<>();

        String MY_QUERY = "SELECT * FROM notesTable ORDER BY id desc";
        Cursor cursor = db.rawQuery(MY_QUERY, new String[]{});
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                String id = cursor.getString(0);
                String title = cursor.getString(1);
                String date = cursor.getString(3);
                String time = cursor.getString(4);
                String color = cursor.getString(5);
                NoteClass note = new NoteClass();
                note.setId(id);
                note.setTitle(title);
                note.setDate(date);
                note.setTime(time);
                note.setColor(color);
                noteList.add(note);
                cursor.moveToNext();
            }
        }
//        Log.d("id", Long.toString(noteList.get(0).getId()));
//        Log.d("title", noteList.get(0).getTitle());
//        Log.d("date", noteList.get(0).getDate());
//        Log.d("time", noteList.get(0).getTime());
//        Log.d("color", noteList.get(0).getColor());

        cursor.close();
        return noteList;
    }

    public List<NoteClass> getNote(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        List<NoteClass> noteList = new ArrayList<>();

        String MY_QUERY = "SELECT * FROM notesTable WHERE id = ?";
        Cursor cursor = db.rawQuery(MY_QUERY, new String[]{id});
        if (cursor.moveToFirst()) {
//            String title = cursor.getString(1);
            String content = cursor.getString(2);
            String date = cursor.getString(3);
            String time = cursor.getString(4);
            String color = cursor.getString(5);

            NoteClass note = new NoteClass();
//            note.setTitle(title);
            note.setContent(content);
            note.setDate(date);
            note.setTime(time);
            note.setColor(color);
            noteList.add(note);
        }
        cursor.close();
//
//        Log.d("title", noteList.get(0).getTitle());
//        Log.d("content", noteList.get(0).getContent());
//        Log.d("date", noteList.get(0).getDate());
//        Log.d("time", noteList.get(0).getTime());
//        Log.d("color", noteList.get(0).getColor());

        return noteList;
    }
}
