package com.gemi_droid.intcoretask.data.userPreferences;


import android.content.Context;
import android.content.SharedPreferences;

public class cachedData {

    public static void saveInPreference(Context context, String key, String value) {
        SharedPreferences preferences = context.getSharedPreferences("movies", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }
    /**
     * Insert Key to retreive value ..
     */
    public static String getFromPreference(Context context,String key) {
        SharedPreferences preferences = context.getSharedPreferences("movies",Context.MODE_PRIVATE);
        return preferences.getString(key,"");
    }

}
