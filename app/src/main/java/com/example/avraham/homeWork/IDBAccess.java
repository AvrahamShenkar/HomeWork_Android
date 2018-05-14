package com.example.avraham.homeWork;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Avraham on 5/15/2018.
 */

@Dao
public interface IDBAccess {

    @Query("SELECT * FROM BirthDay")
    List<BirthDay> getAllItems();

    @Insert
    void addItem(BirthDay bd);


    @Query("DELETE FROM BirthDay")
    void deleteAll();

}
