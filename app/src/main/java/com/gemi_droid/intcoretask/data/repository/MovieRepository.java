package com.gemi_droid.intcoretask.data.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;

import com.gemi_droid.intcoretask.data.local.db.moviesDB;
import com.gemi_droid.intcoretask.data.network.manager.CommentManager;
import com.gemi_droid.intcoretask.data.network.manager.PostersManager;
import com.gemi_droid.intcoretask.data.network.manager.RepliesManager;
import com.gemi_droid.intcoretask.data.network.models.Comments;
import com.gemi_droid.intcoretask.data.network.models.PosterResults;
import com.gemi_droid.intcoretask.data.network.models.Replies;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {

    CommentManager commentManager;
    PostersManager postersManager;
    RepliesManager repliesManager;
    static moviesDB moviesDBInstance;
    Context context;

    public static MovieRepository getInstance(Context context) {
        moviesDBInstance.getInstance(context);
        return new MovieRepository();
    }

    public MutableLiveData<List<PosterResults.Posters>> listMutableLiveData = new MutableLiveData<List<PosterResults.Posters>>() {
    };


    public LiveData<List<PosterResults.Posters>> getAllPosters() {
        postersManager = new PostersManager();
        postersManager.Posters().enqueue(new Callback<PosterResults>() {
            @Override
            public void onResponse(Call<PosterResults> call, Response<PosterResults> response) {
                if (response.code() >= 200 && response.code() < 300) {
                    if (response.body() != null) {
                        if (response.body().getAllPosters().size() > 0) {
                            listMutableLiveData.setValue(response.body().getAllPosters());
                        }
                    }
                } else {
                    listMutableLiveData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<PosterResults> call, Throwable t) {

                listMutableLiveData.setValue(null);
                t.printStackTrace();
            }
        });

        return listMutableLiveData;
    }

    public List<Comments> getAllComments(int poster_id) {

        final List<Comments> all_comments = new ArrayList<>();

        commentManager.Comments(context, poster_id).enqueue(new Callback<List<Comments>>() {
            @Override
            public void onResponse(Call<List<Comments>> call, Response<List<Comments>> response) {
                if (response.code() >= 200 && response.code() < 300) {
                    if (response.body() != null) {
                        if (response.body().size() > 0) {
                            all_comments.addAll(response.body());
                            // moviesDBInstance.commentsDAOInstance().insertComments(response.body());
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Comments>> call, Throwable t) {

                t.printStackTrace();
            }
        });

        return all_comments;
    }

    public List<Replies> getAllReplies(int comment_id) {

        final List<Replies> all_replies = new ArrayList<>();
        repliesManager.Replies(context, comment_id).enqueue(new Callback<List<Replies>>() {
            @Override
            public void onResponse(Call<List<Replies>> call, Response<List<Replies>> response) {
                if (response.code() >= 200 && response.code() < 300) {
                    if (response.body() != null) {
                        if (response.body().size() > 0) {
                            all_replies.addAll(response.body());
                            //   moviesDBInstance.repliesDAOInstance().insertReplies(response.body());
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Replies>> call, Throwable t) {

                t.printStackTrace();
            }
        });

        return all_replies;
    }

}
