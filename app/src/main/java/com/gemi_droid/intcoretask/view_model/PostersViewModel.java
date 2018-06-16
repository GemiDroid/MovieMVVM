package com.gemi_droid.intcoretask.view_model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.gemi_droid.intcoretask.data.repository.MovieRepository;
import com.gemi_droid.intcoretask.data.network.models.Comments;
import com.gemi_droid.intcoretask.data.network.models.Posters;
import com.gemi_droid.intcoretask.data.network.models.Replies;

import java.util.List;



public class PostersViewModel extends ViewModel {

    static MovieRepository movieRepo;

   /* public static LiveData<List<Posters>> getAllPosters(Context context) {

        return movieRepo.getInstance(context).getAllPosters();
    }

    public static LiveData<List<Comments>> getAllCommments(Context context, int poster_id) {

        return movieRepo.getInstance(context).getAllComments(poster_id);
    }

    public static LiveData<List<Replies>> getAllPosters(Context context, int comment_id) {

        return movieRepo.getInstance(context).getAllReplies(comment_id);
    }
*/

}
