package com.gemi_droid.intcoretask.data.local.entities;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Posters {


    @PrimaryKey
    @ColumnInfo(name = "id")
    private int ID;
/*

    @SerializedName("title")
    @ColumnInfo(name = "name")
    private String Name;

    */


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
