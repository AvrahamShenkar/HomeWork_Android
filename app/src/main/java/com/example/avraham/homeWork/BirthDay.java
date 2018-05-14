package com.example.avraham.homeWork;

import java.util.Date;

public class BirthDay {
    private String _name;
    private Date _birthDate;
    private int _nextCommingBD;
    private String _comment ;


    public BirthDay(){
        this._name = "";
       // this._birthDate = Dat;
        this._nextCommingBD = 0;
        this._comment = "";
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public Date getBirthDate() {
        return _birthDate;
    }

    public void setVirthDate(Date _birthDate) {
        this._birthDate = _birthDate;
    }

    public int getNextCommingBD() {
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
}

