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
import com.squareup.picasso.Picasso;

import java.util.List;


public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentHolder> {


    List<Comments> commentsList;
    Comments commentObject;
    Context context;

    CommentAdapter(Context context, List<Comments> commentsList) {
        this.context = context;
        this.commentsList = commentsList;
    }

    @Override
    public CommentHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_row, parent, false);
        return new CommentHolder(view);
    }

    @Override
    public void onBindViewHolder(CommentHolder holder, int position) {

        commentObject = commentsList.get(position);
        holder.txt_comment_author.setText(commentObject.getCommentAuthor());
        Picasso.with(context).load(commentObject.getImg_author_url()).into(holder.img_author);
        holder.txt_comment_date.setText(commentObject.getCommentDate());
        holder.txt_comment_title.setText(commentObject.getCommentTitle());

        if (commentObject.getImg_comment_url() != null)
            Picasso.with(context).load(commentObject.getImg_comment_url()).into(holder.img_comment);
        else holder.img_comment.setVisibility(View.GONE);



    }

    @Override
    public int getItemCount() {
        return commentsList.size();
    }


    public class CommentHolder extends RecyclerView.ViewHolder {

        TextView txt_comment_author, txt_comment_date, txt_comment_title;
        ImageView img_author, img_comment;


        public CommentHolder(View itemView) {
            super(itemView);

            txt_comment_author = itemView.findViewById(R.id.txt_comment_author);
            txt_comment_date = itemView.findViewById(R.id.txt_comment_date);
            txt_comment_title = itemView.findViewById(R.id.txt_comment_title);

            img_author = itemView.findViewById(R.id.img_author);
            img_comment = itemView.findViewById(R.id.img_comment);


        }
    }


}
