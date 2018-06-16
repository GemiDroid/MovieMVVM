package com.gemi_droid.intcoretask.data.network.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by pc on 06/16/2018.
 */

public class Replies {


    @SerializedName("")
    @Expose
    private int reply_id;


    @SerializedName("")
    @Expose
    private String img_author_url;

    @SerializedName("")
    @Expose
    private String replyAuthor;


    @SerializedName("")
    @Expose
    private String replyAuthorReply;


    public String getImg_author_url() {
        return img_author_url;
    }


    public int getReply_id() {
        return reply_id;
    }

    public String getReplyAuthor() {
        return replyAuthor;
    }

    public String getReplyAuthorReply() {
        return replyAuthorReply;
    }

    public void setImg_author_url(String img_author_url) {
        this.img_author_url = img_author_url;
    }

    public void setReply_id(int reply_id) {
        this.reply_id = reply_id;
    }

    public void setReplyAuthor(String replyAuthor) {
        this.replyAuthor = replyAuthor;
    }

    public void setReplyAuthorReply(String replyAuthorReply) {
        this.replyAuthorReply = replyAuthorReply;
    }
}
