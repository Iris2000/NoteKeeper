package com.example.notekeeper;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ToggleButton;

public class AddNote extends AppCompatActivity {

    Toolbar toolbar;
    ConstraintLayout layout;
    ToggleButton btn1;
    ToggleButton btn2;
    ToggleButton btn3;
    ToggleButton btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.black));
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        layout = findViewById(R.id.add_note_layout);
        btn1 = findViewById(R.id.colorBtn1);
        btn2 = findViewById(R.id.colorBtn2);
        btn3 = findViewById(R.id.colorBtn3);
        btn4 = findViewById(R.id.colorBtn4);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.confirm_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    public void onColorClicked(View view) {
        switch(view.getId()){
            case R.id.colorBtn1:
                layout.setBackgroundColor(getResources().getColor(R.color.noteColor1));
                toolbar.setBackgroundColor(getResources().getColor(R.color.noteColor1));
                btn2.setChecked(false);
                btn3.setChecked(false);
                btn4.setChecked(false);
                break;
            case R.id.colorBtn2:
                layout.setBackgroundColor(getResources().getColor(R.color.noteColor2));
                toolbar.setBackgroundColor(getResources().getColor(R.color.noteColor2));
                btn1.setChecked(false);
                btn3.setChecked(false);
                btn4.setChecked(false);
                break;
            case R.id.colorBtn3:
                layout.setBackgroundColor(getResources().getColor(R.color.noteColor3));
                toolbar.setBackgroundColor(getResources().getColor(R.color.noteColor3));
                btn1.setChecked(false);
                btn2.setChecked(false);
                btn4.setChecked(false);
                break;
            case R.id.colorBtn4:
                layout.setBackgroundColor(getResources().getColor(R.color.noteColor4));
                toolbar.setBackgroundColor(getResources().getColor(R.color.noteColor4));
                btn1.setChecked(false);
                btn2.setChecked(false);
                btn3.setChecked(false);
                break;
        }

    }
}
