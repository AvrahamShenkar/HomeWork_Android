package com.example.avraham.homeWork;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.RoomDatabase;

import java.util.ArrayList;

@Database(entities = BirthDay.class, version = 1)
public abstract class DBAccess extends RoomDatabase{
    public abstract IDBAccess iDbAccess();


}
