package com.gemi_droid.intcoretask.data.utilits;

import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;



public class TimeFormat {

    public static String getCurrentTimeFormat() {

        Calendar cal = Calendar.getInstance();
        Date currentLocalTime = cal.getTime();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", new Locale("en"));
        String localTime = dateFormat.format(currentLocalTime);
        localTime.replaceAll("%20", " ");
        Log.d("Time Now", "mostCommonItemList: " + localTime);
        return localTime;
    }
}
