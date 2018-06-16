package com.gemi_droid.intcoretask.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gemi_droid.intcoretask.R;
import com.gemi_droid.intcoretask.data.network.models.Comments;
import com.gemi_droid.intcoretask.data.network.models.Replies;
import com.squareup.picasso.Picasso;

import java.util.List;


public class RepliesAdapter extends RecyclerView.Adapter<RepliesAdapter.ReplyHolder> {

    List<Replies> repliesList;
    Replies replieObject;
    Context context;

    RepliesAdapter(Context context, List<Replies> repliesList) {
        this.context = context;
        this.repliesList = repliesList;
    }

    @Override
    public ReplyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reply_row, parent, false);
        return new ReplyHolder(view);
    }

    @Override
    public void onBindViewHolder(ReplyHolder holder, int position) {

        replieObject = repliesList.get(position);
        holder.txt_reply_author.setText(replieObject.getReplyAuthor());
        Picasso.with(context).load(replieObject.getImg_author_url()).into(holder.img_reply_author);
        holder.txt_reply_content.setText(replieObject.getReplyAuthorReply());
    }

    @Override
    public int getItemCount() {
        return repliesList.size();
    }


    public class ReplyHolder extends RecyclerView.ViewHolder {

        TextView txt_reply_author, txt_reply_content;
        ImageView img_reply_author;


        public ReplyHolder(View itemView) {
            super(itemView);

            txt_reply_author = itemView.findViewById(R.id.txt_replier_name);
            txt_reply_content = itemView.findViewById(R.id.txt_replier_reply);

            img_reply_author = itemView.findViewById(R.id.img_reply_author);
        }
    }


}
