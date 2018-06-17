package com.gemi_droid.intcoretask.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gemi_droid.intcoretask.R;
import com.gemi_droid.intcoretask.data.network.models.PosterResults;
import com.gemi_droid.intcoretask.view.ui.MovieDetailsActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PostersAdapter extends RecyclerView.Adapter<PostersAdapter.PostersHolder> {

    List<PosterResults.Posters> postersList;
    Context context;
    public static final String POSTER_IMG_URL = "http://image.tmdb.org/t/p/w185/";


    public PostersAdapter(Context context, List<PosterResults.Posters> postersList) {

        this.context = context;
        this.postersList = postersList;
    }

    public PostersAdapter(Context context) {
        this.context = context;
    }


    @Override
    public PostersAdapter.PostersHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.poster_row, parent, false);
        return new PostersHolder(view);
    }

    @Override
    public void onBindViewHolder(final PostersAdapter.PostersHolder holder, final int position) {

        final PosterResults.Posters posterObject = postersList.get(position);

        holder.txt_poster_title.setText(posterObject.getPoster_title());
        holder.txt_poster_content.setText(posterObject.getPoster_details());

        Picasso.with(context).load(POSTER_IMG_URL + posterObject.getPoster_url()).into(holder.img_poster);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToMovieDetails(position, context,posterObject);
            }
        });
    }

    private void navigateToMovieDetails(int position, Context context,final PosterResults.Posters _posters) {

        Intent i = new Intent(context, MovieDetailsActivity.class);
        i.putExtra(MovieDetailsActivity.MOVIE_ID, position);
        i.putExtra(MovieDetailsActivity.MOVIE_POSTER, _posters.getPoster_url());
        i.putExtra(MovieDetailsActivity.MOVIE_RELEASE, _posters.getReleaseDate());
        i.putExtra(MovieDetailsActivity.MOVIE_TITLE, _posters.getPoster_title());
        i.putExtra(MovieDetailsActivity.MOVIE_OVERVIEW, _posters.getPoster_details());
        i.putExtra(MovieDetailsActivity.MOVIE_VOTE, _posters.getVoting());
        context.startActivity(i);
    }

    @Override
    public int getItemCount() {
        return postersList.size();
    }


    public class PostersHolder extends RecyclerView.ViewHolder {

        TextView txt_poster_title, txt_poster_content;
        ImageView img_poster;


        public PostersHolder(View itemView) {
            super(itemView);

            txt_poster_title = itemView.findViewById(R.id.txt_poster_title);
            txt_poster_content = itemView.findViewById(R.id.txt_poster_content);

            img_poster = itemView.findViewById(R.id.img_poster);

        }
    }
}
