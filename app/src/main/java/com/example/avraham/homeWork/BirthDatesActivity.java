package com.example.avraham.homeWork;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.FloatingActionButton;

import android.util.Log;
import android.view.View;

import java.util.ArrayList;


public class BirthDatesActivity extends AppCompatActivity {
    private static  final String TAG = "BirthDatesActivity";
    FloatingActionButton fab;
    ArrayList<BirthDay> bDays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birth_dates);

        fab = findViewById(R.id.btn_addItem);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Log.d(TAG, "onCLick: Pressed");
                openIntent(NewItemWizard.class);
            }
        });


        bDays = new ArrayList<>();
    }

    private void openIntent(Class clss){
        Intent inten = new Intent(this, clss);
        startActivity(inten);
    }
}