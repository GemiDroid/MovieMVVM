package com.gemi_droid.intcoretask.data.network.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PosterResults {

    @SerializedName("results")
    @Expose
    private List<Posters> AllPosters;

 /*   @SerializedName("")
    @Expose
    private

    @SerializedName("")
    @Expose
    private

    @SerializedName("")
    @Expose
    private*/

    public List<Posters> getAllPosters() {
        return AllPosters;
    }

    public void setAllPosters(List<Posters> allPosters) {
        AllPosters = allPosters;
    }

    public class Posters {


        @SerializedName("id")
        @Expose
        private int poster_id;

        @SerializedName("original_title")
        @Expose
        private String poster_title;


        @SerializedName("poster_path")
        @Expose
        private String poster_url;

        @SerializedName("overview")
        @Expose
        private String poster_details;

        @SerializedName("release_date")
        @Expose
        private String releaseDate;

        @SerializedName("vote_average")
        @Expose
        private String voting;


        public String getReleaseDate() {
            return releaseDate;
        }

        public String getVoting() {
            return voting;
        }

        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }

        public void setVoting(String voting) {
            this.voting = voting;
        }

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


}



