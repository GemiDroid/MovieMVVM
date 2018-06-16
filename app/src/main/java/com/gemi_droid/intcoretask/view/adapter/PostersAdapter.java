package com.gemi_droid.intcoretask.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gemi_droid.intcoretask.R;
import com.gemi_droid.intcoretask.data.network.models.Posters;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PostersAdapter extends RecyclerView.Adapter<PostersAdapter.PostersHolder> {

    List<Posters> postersList;
    Posters posterObject;
    Context context;

    PostersAdapter(Context context, List<Posters> postersList) {

        this.context = context;
        this.postersList = postersList;
    }


    @Override
    public PostersAdapter.PostersHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.poster_row, parent, false);
        return new PostersHolder(view);
    }

    @Override
    public void onBindViewHolder(PostersAdapter.PostersHolder holder, int position) {

        posterObject = postersList.get(position);
        holder.txt_poster_title.setText(posterObject.getPoster_title());
        holder.txt_poster_content.setText(posterObject.getPoster_details());

        Picasso.with(context).load(posterObject.getPoster_url()).into(holder.img_poster);
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
