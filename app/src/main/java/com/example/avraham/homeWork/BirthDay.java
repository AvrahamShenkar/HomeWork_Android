package com.example.avraham.homeWork;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.util.Date;

@Entity
public class BirthDay {


    @PrimaryKey(autoGenerate = true)
    private int _id;
    @ColumnInfo(name= "fullName")
    private String _name;
    @ColumnInfo(name= "birthDate")
    @TypeConverters(DateConverter.class)
    private Date _birthDate;
    @ColumnInfo(name= "nextBDate")
    private int _nextCommingBD;
    @ColumnInfo(name= "notes")
    private String _comment ;


    public BirthDay(){
        this._name = "";
       // this._birthDate = Dat;
        this._nextCommingBD = 0;
        this._comment = "";
    }

    public BirthDay(String _name, Date _birthDate, int _nextCommingBD, String _comment) {
        this._name = _name;
        this._comment = _comment;
        this.setBirthDate(_birthDate);
    }

    public BirthDay(int _d, String _name, Date _birthDate, int _nextCommingBD, String _comment) {
        this._id = _id;
        this._name = _name;
        this._comment = _comment;
        this.setBirthDate(_birthDate);
    }

    public int getId() {return _id;}

    public void setId(int _id) {  this._id = _id; }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public Date getBirthDate() {
        return _birthDate;
    }

    public void setBirthDate(Date _birthDate) {
        this._birthDate = _birthDate;
        this._nextCommingBD = convertDateToInt(_birthDate);
    }

    public int getNextCommingBD() {
        if(_nextCommingBD == 0){
            _nextCommingBD = this.convertDateToInt(this._birthDate);
        }
        return _nextCommingBD;
    }

    public void setNextCommingBD(int _nextCommingBD) {
        this._nextCommingBD = _nextCommingBD;
    }

    public String getComment() {
        return _comment;
    }

    public void setComment(String comment) {
        _comment = comment;
    }


    private int  convertDateToInt(Date date){
        return (this.getBirthDate().getMonth()+1) * 100 + this.getBirthDate().getDate();
    }
}

