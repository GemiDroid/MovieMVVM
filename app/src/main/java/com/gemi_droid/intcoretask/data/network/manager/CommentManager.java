package com.gemi_droid.intcoretask.data.network.manager;

import android.content.Context;

import com.gemi_droid.intcoretask.R;
import com.gemi_droid.intcoretask.data.network.models.Comments;
import com.gemi_droid.intcoretask.data.network.webservice.API;
import com.gemi_droid.intcoretask.data.network.retrofit.RetrofitRepository;

import java.util.List;

import retrofit2.Call;


public class CommentManager {

    RetrofitRepository retrofitRepository;

    public CommentManager() {
        retrofitRepository = new RetrofitRepository();
    }

    public Call<List<Comments>> Comments(Context context, int poster_id) {
        API Api_Service = retrofitRepository.getRetrofit(context.getString(R.string.base_url)).create(API.class);
      return Api_Service.GetAllComments(poster_id);
    }

}
