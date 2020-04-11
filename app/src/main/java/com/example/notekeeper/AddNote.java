package com.example.notekeeper;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AddNote extends AppCompatActivity {

    Toolbar toolbar;
    ConstraintLayout layout;
    ToggleButton btn0;
    ToggleButton btn1;
    ToggleButton btn2;
    ToggleButton btn3;
    ToggleButton btn4;
    Button mReminder;
    EditText mTitle;
    EditText mContent;
    TextView mDateTime;
    String title;
    String content;
    NoteDatabase db;
    String currentDate;
    String currentTime;
    String color = "noteColor0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        // setup toolbar
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.black));
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        layout = findViewById(R.id.add_note_layout);
        btn0 = findViewById(R.id.colorBtn0);
        btn1 = findViewById(R.id.colorBtn1);
        btn2 = findViewById(R.id.colorBtn2);
        btn3 = findViewById(R.id.colorBtn3);
        btn4 = findViewById(R.id.colorBtn4);
        mTitle = findViewById(R.id.title);
        mContent = findViewById(R.id.content);
        mDateTime = findViewById(R.id.dateTime);
        mReminder = findViewById(R.id.reminderBtn);


        // get current date and time
        currentDate = new SimpleDateFormat("EEE, d MMM yyyy", Locale.getDefault()).format(new Date());
        currentTime = new SimpleDateFormat("HH:mm a", Locale.getDefault()).format(new Date());
        Log.d("currentDate", currentDate);
        Log.d("currentTime", currentTime);
        mDateTime.setText(currentDate + ", " + currentTime);

        mTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() != 0) {
                    getSupportActionBar().setTitle(s);
                } else {
                    getSupportActionBar().setTitle("Add Note");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        // set listener to color btn
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color = "noteColor0";
                layout.setBackgroundColor(getResources().getColor(R.color.noteColor0));
                toolbar.setBackgroundColor(getResources().getColor(R.color.noteColor0));
                btn1.setChecked(false);
                btn2.setChecked(false);
                btn3.setChecked(false);
                btn4.setChecked(false);
                if (!btn0.isChecked()) {
                    layout.setBackgroundColor(getResources().getColor(R.color.noteColor0));
                    toolbar.setBackgroundColor(getResources().getColor(R.color.noteColor0));
                    color = "noteColor0";
                }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color = "noteColor1";
                layout.setBackgroundColor(getResources().getColor(R.color.noteColor1));
                toolbar.setBackgroundColor(getResources().getColor(R.color.noteColor1));
                btn0.setChecked(false);
                btn2.setChecked(false);
                btn3.setChecked(false);
                btn4.setChecked(false);
                if (!btn1.isChecked()) {
                    layout.setBackgroundColor(getResources().getColor(R.color.noteColor0));
                    toolbar.setBackgroundColor(getResources().getColor(R.color.noteColor0));
                    color = "noteColor0";
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color = "noteColor2";
                layout.setBackgroundColor(getResources().getColor(R.color.noteColor2));
                toolbar.setBackgroundColor(getResources().getColor(R.color.noteColor2));
                btn0.setChecked(false);
                btn1.setChecked(false);
                btn3.setChecked(false);
                btn4.setChecked(false);
                if (!btn2.isChecked()) {
                    layout.setBackgroundColor(getResources().getColor(R.color.noteColor0));
                    toolbar.setBackgroundColor(getResources().getColor(R.color.noteColor0));
                    color = "noteColor0";
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color = "noteColor3";
                layout.setBackgroundColor(getResources().getColor(R.color.noteColor3));
                toolbar.setBackgroundColor(getResources().getColor(R.color.noteColor3));
                btn0.setChecked(false);
                btn1.setChecked(false);
                btn2.setChecked(false);
                btn4.setChecked(false);
                if (!btn3.isChecked()) {
                    layout.setBackgroundColor(getResources().getColor(R.color.noteColor0));
                    toolbar.setBackgroundColor(getResources().getColor(R.color.noteColor0));
                    color = "noteColor0";
                }
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color = "noteColor4";
                layout.setBackgroundColor(getResources().getColor(R.color.noteColor4));
                toolbar.setBackgroundColor(getResources().getColor(R.color.noteColor4));
                btn0.setChecked(false);
                btn1.setChecked(false);
                btn2.setChecked(false);
                btn3.setChecked(false);
                if (!btn4.isChecked()) {
                    layout.setBackgroundColor(getResources().getColor(R.color.noteColor0));
                    toolbar.setBackgroundColor(getResources().getColor(R.color.noteColor0));
                    color = "noteColor0";
                }
            }
        });

        mReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mReminder.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.confirm_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                AlertDialog.Builder myAlertBuilder = new AlertDialog.Builder(this);
                // Set the dialog title and message.
                myAlertBuilder.setTitle("Discard Changes");
                myAlertBuilder.setMessage("Are you sure to discard the changes?");
                // Add the dialog buttons.
                myAlertBuilder.setPositiveButton(getString(R.string.discard_btn), new
                        DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // User clicked Delete button.
                                Toast.makeText(getApplicationContext(), "Discard", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        });
                myAlertBuilder.setNegativeButton(getString(R.string.cancel_btn), new
                        DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // User cancelled the dialog.
                                Toast.makeText(getApplicationContext(), "Cancel",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                // Create and show the AlertDialog;
                myAlertBuilder.show();
                break;
            case R.id.save:
                title = mTitle.getText().toString();
                content = mContent.getText().toString();
                if (title.length() == 0) {
                    Toast.makeText(this, "Title is empty", Toast.LENGTH_SHORT).show();
                }
                else if (content.length() == 0) {
                    Toast.makeText(this, "Content is empty", Toast.LENGTH_SHORT).show();
                } else {
                    db = new NoteDatabase(this);
                    boolean insertNote = db.insertNote(title, content, currentDate, currentTime, color);
                    if (!insertNote) {
                        Log.d("failed", "insertNote failed");
                    }
                    finish();
                }
                break;
        }
//        Log.d("item", Integer.toString(item.getItemId()));
        return super.onOptionsItemSelected(item);
    }
}
