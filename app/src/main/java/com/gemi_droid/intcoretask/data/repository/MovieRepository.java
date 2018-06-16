package com.gemi_droid.intcoretask.data.repository;

import android.content.Context;
import com.gemi_droid.intcoretask.data.local.db.moviesDB;
import com.gemi_droid.intcoretask.data.network.manager.CommentManager;
import com.gemi_droid.intcoretask.data.network.manager.PostersManager;
import com.gemi_droid.intcoretask.data.network.manager.RepliesManager;
import com.gemi_droid.intcoretask.data.network.models.Comments;
import com.gemi_droid.intcoretask.data.network.models.Posters;
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

    moviesDB moviesDBInstance;

    Context context;

    public MovieRepository getInstance(Context context) {
        moviesDBInstance.getInstance(context);
        return new MovieRepository(context);
    }

    MovieRepository(Context context) {
        this.context = context;
    }

    public List<Posters> getAllPosters() {

        List<Posters> all_poster = new ArrayList<>();
        postersManager.Posters(context).enqueue(new Callback<List<Posters>>() {
            @Override
            public void onResponse(Call<List<Posters>> call, Response<List<Posters>> response) {
                if (response.code() >= 200 && response.code() < 300) {
                    if (response.body() != null) {
                        if (response.body().size() > 0) {
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Posters>> call, Throwable t) {

                t.printStackTrace();
            }
        });

        return all_poster;
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
