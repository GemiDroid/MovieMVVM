package com.gemi_droid.intcoretask.data.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.gemi_droid.intcoretask.data.local.entities.Replies;

import java.util.List;

@Dao
public interface repliesDAO {

    @Query("SELECT * FROM Replies where id = :commentId")
    List<Replies> getAllReplies(int commentId);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertReplies(List<Replies> replies);

}
