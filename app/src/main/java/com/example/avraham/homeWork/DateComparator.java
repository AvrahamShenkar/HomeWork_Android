package com.example.avraham.homeWork;

import android.text.format.DateFormat;

import java.util.Comparator;
import java.util.Date;
import 	java.lang.Math;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/**
 * Created by Avraham on 5/15/2018.
 */

public class DateComparator implements Comparator<BirthDay> {
    @Override
    public int compare(BirthDay lhs, BirthDay rhs) {
        int a = lhs.getNextCommingBD();
        int b = rhs.getNextCommingBD();

        Date d = new Date();
        CharSequence s = DateFormat.format("MMMM d, yyyy ", d.getTime());
        int current = (d.getMonth()+1) * 100 + d.getDate();

        return Integer.valueOf(Math.abs(current - a)).compareTo(Integer.valueOf(Math.abs(current - b)));
    }
}