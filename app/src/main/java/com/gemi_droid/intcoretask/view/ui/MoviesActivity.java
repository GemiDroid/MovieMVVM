package com.gemi_droid.intcoretask.view.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.gemi_droid.intcoretask.R;
import com.gemi_droid.intcoretask.data.network.models.PosterResults;
import com.gemi_droid.intcoretask.view.adapter.PostersAdapter;
import com.gemi_droid.intcoretask.view_model.PostersViewModel;
import java.util.List;


public class MoviesActivity extends AppCompatActivity {

    PostersAdapter postersAdapter;
    RecyclerView rec_posters;
    PostersViewModel postersViewModel;
    ProgressBar prog_poster;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        initView();
        initViewModel(this);
        initRecycler(this);

    }

    private void initRecycler(final Context context) {

        prog_poster.setVisibility(View.VISIBLE);

        postersViewModel.observeOnPoster().observe(this, new Observer<List<PosterResults.Posters>>() {
            @Override
            public void onChanged(@Nullable List<PosterResults.Posters> postersList) {


                if (postersList != null) {

                    postersAdapter = new PostersAdapter(context, postersList);
                    rec_posters.setAdapter(postersAdapter);
                }
                else {
                    Toast.makeText(context, context.getString(R.string.no_internet), Toast.LENGTH_LONG).show();
                }


            }
        });

        prog_poster.setVisibility(View.GONE);

    }

    private void initViewModel(Context context) {
        postersViewModel = ViewModelProviders.of(this).get(PostersViewModel.class);
        postersViewModel.getAllPosters(context);
    }

    private void initView() {
        rec_posters = findViewById(R.id.rec_posters);
        rec_posters.setLayoutManager(new LinearLayoutManager(this));
        prog_poster=findViewById(R.id.prog_poster);
    }

}
