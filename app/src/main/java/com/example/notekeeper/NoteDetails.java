package com.example.notekeeper;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class NoteDetails extends AppCompatActivity {

    Toolbar toolbar;
    String title;
    String id;
    List<NoteClass> noteInfo;
    NoteDatabase db;
    TextView mDateTime;
    TextView mContent;
    String date;
    String time;
    String content;
    byte[] imagebyte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_details);

        Intent getIntent = getIntent();
        title = getIntent.getStringExtra("title");
        id = getIntent.getStringExtra("id");
        Log.d("id", id);

        mDateTime = findViewById(R.id.dateTime);
        mContent = findViewById(R.id.content);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.black));
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        db = new NoteDatabase(this);
        noteInfo = db.getNote(id);
        date = noteInfo.get(0).getDate();
        time = noteInfo.get(0).getTime();
        content = noteInfo.get(0).getContent();
        mDateTime.setText(date + " " + time);
        mContent.setText(content);

        imagebyte = (byte[]) noteInfo.get(0).getImage();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.details_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.edit:
                Intent intent = new Intent(this, EditNote.class);
                intent.putExtra("title", title);
                intent.putExtra("content", content);
                intent.putExtra("id", id);
                intent.putExtra("image", imagebyte);
                startActivityForResult(intent, 1);
                finish();
                break;
            case R.id.delete:
                db = new NoteDatabase(this);
                AlertDialog.Builder myAlertBuilder = new AlertDialog.Builder(this);
                myAlertBuilder.setTitle("Delete Note");
                myAlertBuilder.setMessage("Are you sure to delete ' "+ title +" ' ?");
                myAlertBuilder.setPositiveButton("Yes", new
                        DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                db.deleteNote(id);
                                Toast.makeText(getApplicationContext(), "' "+title+" ' has been deleted !", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        });
                myAlertBuilder.setNegativeButton(getString(R.string.cancel_btn), new
                        DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "Cancel",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                // Create and show the AlertDialog;
                myAlertBuilder.show();
                Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 1
        if(requestCode == 1)
        {

        }
    }
}
