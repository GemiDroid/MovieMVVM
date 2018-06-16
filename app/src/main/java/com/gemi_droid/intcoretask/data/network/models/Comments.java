package com.gemi_droid.intcoretask.data.network.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Comments {

    @SerializedName("")
    @Expose
    private int comment_id;


    @SerializedName("")
    @Expose
    private String img_author_url;

    @SerializedName("")
    @Expose
    private String img_comment_url;


    @SerializedName("")
    @Expose
    private String commentAuthor;


    @SerializedName("")
    @Expose
    private String commentDate;


    @SerializedName("")
    @Expose
    private String commentTitle;

    public String getCommentAuthor() {
        return commentAuthor;
    }


    public String getCommentDate() {
        return commentDate;
    }

    public String getCommentTitle() {
        return commentTitle;
    }

    public String getImg_author_url() {
        return img_author_url;
    }

    public String getImg_comment_url() {
        return img_comment_url;
    }


    public void setCommentAuthor(String commentAuthor) {
        this.commentAuthor = commentAuthor;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    public void setCommentTitle(String commentTitle) {
        this.commentTitle = commentTitle;
    }

    public void setImg_author_url(String img_author_url) {
        this.img_author_url = img_author_url;
    }

    public void setImg_comment_url(String img_comment_url) {
        this.img_comment_url = img_comment_url;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public int getComment_id() {
        return comment_id;
    }
}
