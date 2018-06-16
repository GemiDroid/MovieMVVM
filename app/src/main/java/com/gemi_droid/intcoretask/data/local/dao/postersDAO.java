package com.gemi_droid.intcoretask.data.local.dao;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.gemi_droid.intcoretask.data.local.entities.Posters;
import java.util.List;

public interface postersDAO {

    @Query("SELECT * FROM Posters ")
    List<Posters> getAllPosters();


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPosters(List<Posters> posters);

}
