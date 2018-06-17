package com.gemi_droid.intcoretask.view.ui;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gemi_droid.intcoretask.R;
import com.gemi_droid.intcoretask.data.utilits.ShareUtility;
import com.gemi_droid.intcoretask.view.adapter.CommentAdapter;
import com.gemi_droid.intcoretask.view.adapter.PostersAdapter;
import com.squareup.picasso.Picasso;

public class MovieDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String MOVIE_RELEASE = "movie_release";
    public static final String MOVIE_OVERVIEW = "movie_overview";
    public static final String MOVIE_VOTE = "movie_vote";
    public static final String MOVIE_TITLE = "movie_title";
    public static final String MOVIE_ID = "movie_id";
    public static final String MOVIE_POSTER = "movie_poster";
    CommentAdapter commentAdapter;
    RecyclerView rec_comments;
    ImageView img_fav, img_share, img_exit, image_poster;
    boolean isChecked;
    Bundle bundle;
    AppBarLayout app_bar;
    TextView txt_poster_release, txt_poster_title, txt_poster_vote, txt_poster_overview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        img_exit = toolbar.findViewById(R.id.img_exit);
        img_share = toolbar.findViewById(R.id.img_share);
        img_fav = toolbar.findViewById(R.id.img_fav);
        app_bar = findViewById(R.id.app_bar);
        image_poster = findViewById(R.id.image_poster);
        txt_poster_release = findViewById(R.id.txt_poster_release);
        txt_poster_title = findViewById(R.id.txt_poster_title);
        txt_poster_vote = findViewById(R.id.txt_poster_vote);
        txt_poster_overview = findViewById(R.id.txt_poster_overview);

        img_fav.setOnClickListener(this);
        img_exit.setOnClickListener(this);
        img_share.setOnClickListener(this);

        bundle = getIntent().getExtras();
        if (bundle != null) {
            Picasso.with(this).load(PostersAdapter.POSTER_IMG_URL + bundle.getString(MOVIE_POSTER)).into(image_poster);
            txt_poster_release.setText(bundle.getString(MOVIE_RELEASE));
            txt_poster_title.setText(bundle.getString(MOVIE_TITLE));
            txt_poster_vote.setText(bundle.getString(MOVIE_VOTE));
            txt_poster_overview.setText(bundle.getString(MOVIE_OVERVIEW));
        }




      /*  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/
        rec_comments = findViewById(R.id.rec_comments);
        rec_comments.setNestedScrollingEnabled(false);
        commentAdapter = new CommentAdapter(this);
        rec_comments.setLayoutManager(new LinearLayoutManager(this));
        rec_comments.setAdapter(commentAdapter);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.img_exit:
                finish();
                break;
            case R.id.img_share:
                ShareUtility.share(this, getString(R.string.app_name));
                break;
            case R.id.img_fav:
                if (!isChecked) {
                    img_fav.setImageResource(android.R.drawable.star_on);
                    isChecked = true;

                } else {
                    img_fav.setImageResource(android.R.drawable.star_off);
                    isChecked = false;
                }
                break;

        }
    }
}
