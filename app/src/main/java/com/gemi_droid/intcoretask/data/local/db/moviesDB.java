package com.gemi_droid.intcoretask.data.local.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import com.gemi_droid.intcoretask.data.local.dao.commentsDAO;
import com.gemi_droid.intcoretask.data.local.dao.repliesDAO;
import com.gemi_droid.intcoretask.data.local.entities.Comments;
import com.gemi_droid.intcoretask.data.local.entities.Posters;
import com.gemi_droid.intcoretask.data.local.entities.Replies;


@Database(entities = {Comments.class, Replies.class, Posters.class}, version = 1)
/* @TypeConverters({}) */

public abstract class moviesDB extends RoomDatabase {

    private static moviesDB INSTANCE;

    public abstract commentsDAO commentsDAOInstance();

    public abstract repliesDAO repliesDAOInstance();


    private static final Object sLock = new Object();

    public static moviesDB getInstance(Context context) {
        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        moviesDB.class, "movies.db")
                        .fallbackToDestructiveMigration()
                        .build();
            }
            return INSTANCE;
        }
    }


}
