package com.gemi_droid.intcoretask.view_model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.gemi_droid.intcoretask.data.network.models.PosterResults;
import com.gemi_droid.intcoretask.data.repository.MovieRepository;

import java.util.List;


public class PostersViewModel extends ViewModel {

    private static MovieRepository movieRepo;

    private static LiveData<List<PosterResults.Posters>> AllPosters = new LiveData<List<PosterResults.Posters>>() {};

    public static LiveData<List<PosterResults.Posters>> observeOnPoster() {
        return AllPosters;
    }

    public static void getAllPosters(Context context) {
        movieRepo=new MovieRepository();
        AllPosters = movieRepo.getInstance(context).getAllPosters();
    }
}
