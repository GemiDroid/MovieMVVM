package com.gemi_droid.intcoretask.data.network.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Posters {

    @SerializedName("")
    @Expose
    private int poster_id;

    @SerializedName("")
    @Expose
    private String poster_title;


    @SerializedName("")
    @Expose
    private String poster_url;

    @SerializedName("")
    @Expose
    private String poster_details;


    public int getPoster_id() {
        return poster_id;
    }

    public String getPoster_details() {
        return poster_details;
    }

    public String getPoster_title() {
        return poster_title;
    }

    public String getPoster_url() {
        return poster_url;
    }

    public void setPoster_details(String poster_details) {
        this.poster_details = poster_details;
    }

    public void setPoster_id(int poster_id) {
        this.poster_id = poster_id;
    }

    public void setPoster_title(String poster_title) {
        this.poster_title = poster_title;
    }

    public void setPoster_url(String poster_url) {
        this.poster_url = poster_url;
    }
}
