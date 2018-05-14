package com.example.avraham.homeWork;

import java.util.Calendar;
import java.util.Date;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.avraham.homeWork.BirthDay;

public class NewItemWizard extends AppCompatActivity {
    DBAccess _db;
    EditText _firstName;
    EditText _lastName;
    DatePicker _birthDate;
    EditText _desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_itam_wizard);

        _db = Room.databaseBuilder(getApplicationContext(), DBAccess.class, "DevDB")
                .allowMainThreadQueries()
                .build();

        _firstName = (EditText) findViewById(R.id.first_name);
        _lastName = (EditText) findViewById(R.id.sure_name);
        _birthDate = (DatePicker) findViewById(R.id.birth_date);
        _desc = (EditText) findViewById(R.id.description);

    }

    public void addItem(View view){
        if(validateFields()){
            //do something
        }

        BirthDay bd = new BirthDay(_firstName.getText() + " " +  _lastName.getText(), getDate(), 0, _desc.getText().toString());

        _db.iDbAccess().addItem(bd);
        returnPage();

    }

    private boolean validateFields(){
      //  if(_firstName.getText() == null || _firstName.getText().length() > 5)
        return true;
    }

    private Date getDate(){
        int day = _birthDate.getDayOfMonth();
        int month = _birthDate.getMonth();
        int year =  _birthDate.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        return calendar.getTime();
    }

    private void returnPage(){
        openIntent(BirthDatesActivity.class);
    }

    private void openIntent(Class calss){
        Intent inten = new Intent(this, calss);
        finish();
        startActivity(inten);
    }

}