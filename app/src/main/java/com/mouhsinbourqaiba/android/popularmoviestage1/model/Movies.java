package com.mouhsinbourqaiba.android.popularmoviestage1.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Movies implements Serializable {

    @SerializedName("results")
    @Expose
    private List<Movie> movies = null;
    public List<Movie> getMovies(){
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    static public class Movie implements Serializable{

        @SerializedName("popularity")
        @Expose
        private String popularity;

        @SerializedName("vote_count")
        @Expose
        private int voteCount;

        @SerializedName("video")
        @Expose
        private Boolean video;

        @SerializedName("poster_path")
        @Expose
        private String posterPath;

        @SerializedName("id")
        @Expose
        private int id;

        @SerializedName("adult")
        @Expose
        private Boolean adult;

        @SerializedName("backdrop_path")
        @Expose
        private String backdropPath;

        @SerializedName("original_language")
        @Expose
        private String originalLanguage;

        @SerializedName("original_title")
        @Expose
        private String originalTitle;

        @SerializedName("genre_ids")
        @Expose
        private int[] genreIds;

        @SerializedName("title")
        @Expose
        private String title;

        @SerializedName("vote_average")
        @Expose
        private String voteAverage;

        @SerializedName("overview")
        @Expose
        private String overview;

        @SerializedName("release_date")
        @Expose
        private String releaseDate;

        public String getPopularity() {
            return popularity;
        }

        public void setPopularity(String popularity) {
            this.popularity = popularity;
        }

        public int getVoteCount() {
            return voteCount;
        }

        public void setVoteCount(int voteCount) {
            this.voteCount = voteCount;
        }

        public Boolean getVideo() {
            return video;
        }

        public void setVideo(Boolean video) {
            this.video = video;
        }

        public String getPosterPath() {
            return posterPath;
        }

        public void setPosterPath(String posterPath) {
            this.posterPath = posterPath;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Boolean getAdult() {
            return adult;
        }

        public void setAdult(Boolean adult) {
            this.adult = adult;
        }

        public String getBackdropPath() {
            return backdropPath;
        }

        public void setBackdropPath(String backdropPath) {
            this.backdropPath = backdropPath;
        }

        public String getOriginalLanguage() {
            return originalLanguage;
        }

        public void setOriginalLanguage(String originalLanguage) {
            this.originalLanguage = originalLanguage;
        }

        public String getOriginalTitle() {
            return originalTitle;
        }

        public void setOriginalTitle(String originalTitle) {
            this.originalTitle = originalTitle;
        }

        public int[] getGenreIds() {
            return genreIds;
        }

        public void setGenreIds(int[] genreIds) {
            this.genreIds = genreIds;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getVoteAverage() {
            return voteAverage;
        }

        public void setVoteAverage(String voteAverage) {
            this.voteAverage = voteAverage;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public String getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }
    }
}
