package com.gemi_droid.intcoretask.data.network.webservice;

import com.gemi_droid.intcoretask.data.network.models.Comments;
import com.gemi_droid.intcoretask.data.network.models.Posters;
import com.gemi_droid.intcoretask.data.network.models.Replies;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by pc on 06/16/2018.
 */

public interface API {

    /*                      # API for fetching Poster Comments                   */
    @GET("api/Comments")
    Call<List<Comments>> GetAllComments(
            @Query("poster_id") int PosterId);


    /*                      # API for fetching Posters                    */
    @GET("api/Poster")
    Call<List<Posters>> GetAllPosters();

    /*                      # API for fetching Poster Replies                   */
    @GET("api/Replies")
    Call<List<Replies>> GetAllReplies(
            @Query("comment_id") int CommentId);

}
