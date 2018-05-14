package com.example.avraham.homeWork;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OpenCalculator(View view) {
        openIntent(CalculatorActivity.class);
    }

    public void OpenBirthDates(View view) {
        openIntent(BirthDatesActivity.class);
    }

    private void openIntent(Class clss){
        Intent inten = new Intent(this, clss);
        startActivity(inten);
    }
}