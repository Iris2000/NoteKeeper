package com.example.notekeeper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import java.util.List;

import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements
        SearchView.OnQueryTextListener {

    Toolbar toolbar;
    NoteDatabase db;
    List<NoteClass> noteList;
    NoteAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.black));
        setSupportActionBar(toolbar);
        db = new NoteDatabase(this);
        noteList = db.getNoteList();
//        Log.d("testing", "testing");
        recyclerView = findViewById(R.id.noteList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NoteAdapter(this, noteList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_note_menu, menu);

        MenuItem menuItem = menu.findItem(R.id.search_button);
        SearchView searchView = (SearchView)menuItem.getActionView();
        searchView.setOnQueryTextListener(this);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.toString().equals("Add Note")){
            Intent intent = new Intent(this, AddNote.class);
            intent.putExtra("from", "MainActivity");
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        db = new NoteDatabase(this);
        noteList = db.getNoteList();
        recyclerView = findViewById(R.id.noteList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NoteAdapter(this, noteList);
        recyclerView.setAdapter(adapter);
        super.onResume();
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String target_text = newText.toLowerCase();
        List<NoteClass> newList = new ArrayList<>();
        for(NoteClass title : noteList){
            if(title.getTitle().toLowerCase().contains(target_text)){
                newList.add(title);
            }
        }

        adapter.setFilter(newList);
        return true;
    }
}