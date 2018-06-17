package com.gemi_droid.intcoretask.data.network.webservice;

import com.gemi_droid.intcoretask.data.network.models.Comments;
import com.gemi_droid.intcoretask.data.network.models.PosterResults;
import com.gemi_droid.intcoretask.data.network.models.Replies;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface API {


    /*                      # API for fetching Poster Comments                   */
    @GET("api/Comments")
    Call<List<Comments>> GetAllComments(
            @Query("poster_id") int PosterId);


    /*                      # API for fetching Posters                    */
    @GET("top_rated")
    Call<PosterResults> GetAllPosters(@Query("api_key") String API_KEY);

    /*                      # API for fetching Poster Replies                   */
    @GET("api/Replies")
    Call<List<Replies>> GetAllReplies(
            @Query("comment_id") int CommentId);

}
