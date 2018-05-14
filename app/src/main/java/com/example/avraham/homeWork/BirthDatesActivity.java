package com.example.avraham.homeWork;
import android.arch.persistence.room.Room;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.FloatingActionButton;

import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


public class BirthDatesActivity extends AppCompatActivity {
    private static  final String TAG = "BirthDatesActivity";
    DBAccess _db;
    FloatingActionButton fab;
    RecyclerView rv;
    List<BirthDay> bDays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birth_dates);

        rv = findViewById(R.id.listItems);
        fab = findViewById(R.id.btn_addItem);

        _db = Room.databaseBuilder(getApplicationContext(), DBAccess.class, "DevDB")
                .allowMainThreadQueries()
                .build();
       // _db.iDbAccess().deleteAll();

        bDays = _db.iDbAccess().getAllItems();
        Collections.sort(bDays, new DateComparator());

        rv.setLayoutManager(new LinearLayoutManager(this));
        BirthDayAdopter bdAdopter = new BirthDayAdopter(bDays);
        rv.setAdapter(bdAdopter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Log.d(TAG, "onCLick: Pressed");
                openIntent(NewItemWizard.class);
            }
        });




    }

    private void openIntent(Class clss){
        Intent inten = new Intent(this, clss);
        startActivity(inten);
    }
}