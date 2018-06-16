package com.gemi_droid.intcoretask.data.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.gemi_droid.intcoretask.data.local.entities.Comments;
import java.util.List;

@Dao
public interface commentsDAO {

    @Query("SELECT * FROM Comments where id = :posterId")
    List<Comments> getAllComments(int posterId);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertComments(List<Comments> comments);

}
