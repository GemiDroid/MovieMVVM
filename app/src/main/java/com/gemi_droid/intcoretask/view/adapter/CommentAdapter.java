package com.gemi_droid.intcoretask.view.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.gemi_droid.intcoretask.R;
import com.gemi_droid.intcoretask.data.network.models.Comments;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentHolder> {


    RepliesAdapter repliesAdapter;
    List<Comments> commentsList;
    Comments commentObject;
    Context context;
    boolean isLiked;

    public CommentAdapter(Context context, List<Comments> commentsList) {
        this.context = context;
        this.commentsList = commentsList;
    }

    public CommentAdapter(Context context) {
        this.context = context;
    }

    @Override
    public CommentHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_row, parent, false);
        return new CommentHolder(view);
    }

    @Override
    public void onBindViewHolder(final CommentHolder holder, int position) {

       /* commentObject = commentsList.get(position);
        holder.txt_comment_author.setText(commentObject.getCommentAuthor());
        Picasso.with(context).load(commentObject.getImg_author_url()).into(holder.img_author);
        holder.txt_comment_date.setText(commentObject.getCommentDate());
        holder.txt_comment_title.setText(commentObject.getCommentTitle());

        if (commentObject.getImg_comment_url() != null)
            Picasso.with(context).load(commentObject.getImg_comment_url()).into(holder.img_comment);
        else holder.img_comment.setVisibility(View.GONE);
*/

        holder.lin_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                likeButton(holder);
            }
        });
        holder.img_post_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayPopupMenu(context, holder);
            }
        });

        initRecyclerView(holder);

    }

    private void initRecyclerView(CommentHolder holder) {
        repliesAdapter = new RepliesAdapter(context);
        holder.rec_comment_replies.setNestedScrollingEnabled(false);
        holder.rec_comment_replies.setLayoutManager(new LinearLayoutManager(context));
        holder.rec_comment_replies.setAdapter(repliesAdapter);
    }

    private void likeButton(CommentHolder holder) {
        if (!isLiked) {
            holder.img_like.setImageResource(R.drawable.ic_liked);
            holder.txt_like.setText(context.getString(R.string.you_like) + " " + context.getString(R.string.one_like));
            isLiked = true;
        } else {
            holder.img_like.setImageResource(R.drawable.ic_like);
            holder.txt_like.setText(context.getString(R.string.one_like));
            isLiked = false;
        }
    }

    private void displayPopupMenu(Context context, CommentHolder holder) {
        PopupMenu popupMenu = new PopupMenu(context, holder.img_post_menu);
        popupMenu.getMenuInflater().inflate(R.menu.menu_event, popupMenu.getMenu());
        popupMenu.show();
    }

    @Override
    public int getItemCount() {
        return 30;
        // return commentsList.size();
    }


    public class CommentHolder extends RecyclerView.ViewHolder {

        TextView txt_comment_author, txt_comment_date, txt_comment_title, txt_like;
        CircleImageView img_author;
        ImageView img_post, img_like, img_post_menu;
        RecyclerView rec_comment_replies;
        LinearLayout lin_like;

        public CommentHolder(View itemView) {
            super(itemView);

            txt_comment_author = itemView.findViewById(R.id.txt_comment_author);
            txt_comment_date = itemView.findViewById(R.id.txt_comment_date);
            txt_comment_title = itemView.findViewById(R.id.txt_comment_title);
            txt_like = itemView.findViewById(R.id.txt_like);

            img_author = itemView.findViewById(R.id.img_author);
            img_post = itemView.findViewById(R.id.img_post);
            img_like = itemView.findViewById(R.id.img_like);
            img_post_menu = itemView.findViewById(R.id.img_post_menu);

            lin_like = itemView.findViewById(R.id.lin_like);

            rec_comment_replies = itemView.findViewById(R.id.rec_comment_replies);

        }
    }


}
