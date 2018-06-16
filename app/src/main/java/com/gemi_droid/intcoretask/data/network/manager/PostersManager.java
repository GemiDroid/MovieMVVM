package com.gemi_droid.intcoretask.data.network.manager;

import android.content.Context;

import com.gemi_droid.intcoretask.data.network.models.Comments;
import com.gemi_droid.intcoretask.data.network.models.Posters;
import com.gemi_droid.intcoretask.data.network.repository.RetrofitRepository;
import com.gemi_droid.intcoretask.data.network.webservice.API;

import java.util.List;

import retrofit2.Call;


public class PostersManager {

    RetrofitRepository retrofitRepository;

    public PostersManager() {
        retrofitRepository = new RetrofitRepository();
    }

    public Call<List<Posters>> Posters(Context context) {
        API Api_Service = retrofitRepository.getRetrofit(context).create(API.class);
       return Api_Service.GetAllPosters();
    }

}
