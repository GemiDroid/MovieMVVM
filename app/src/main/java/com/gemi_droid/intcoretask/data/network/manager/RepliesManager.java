package com.gemi_droid.intcoretask.data.network.manager;

import android.content.Context;

import com.gemi_droid.intcoretask.R;
import com.gemi_droid.intcoretask.data.network.models.Replies;
import com.gemi_droid.intcoretask.data.network.webservice.API;
import com.gemi_droid.intcoretask.data.network.retrofit.RetrofitRepository;

import java.util.List;

import retrofit2.Call;


public class RepliesManager {

    RetrofitRepository retrofitRepository;

    public RepliesManager() {
        retrofitRepository = new RetrofitRepository();
    }

    public Call<List<Replies>> Replies(Context context, int comment_id) {
        API Api_Service = retrofitRepository.getRetrofit(context.getString(R.string.base_url)).create(API.class);
        return Api_Service.GetAllReplies(comment_id);
    }

}
