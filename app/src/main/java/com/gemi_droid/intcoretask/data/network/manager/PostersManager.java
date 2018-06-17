package com.gemi_droid.intcoretask.data.network.manager;

import com.gemi_droid.intcoretask.data.network.models.PosterResults;
import com.gemi_droid.intcoretask.data.network.retrofit.RetrofitRepository;
import com.gemi_droid.intcoretask.data.network.webservice.API;
import retrofit2.Call;


public class PostersManager {

    RetrofitRepository retrofitRepository;

    public PostersManager() {
        retrofitRepository = new RetrofitRepository();
    }

    public Call<PosterResults> Posters() {
        API Api_Service = retrofitRepository.getRetrofit("https://api.themoviedb.org/3/movie/").create(API.class);
       return Api_Service.GetAllPosters("6c08ba20de298358919a0cfd7c0c066a");
    }

}
