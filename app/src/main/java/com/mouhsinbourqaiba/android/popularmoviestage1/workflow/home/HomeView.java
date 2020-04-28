package com.mouhsinbourqaiba.android.popularmoviestage1.workflow.home;

import com.mouhsinbourqaiba.android.popularmoviestage1.model.Movies;

import java.util.List;

public interface HomeView {
    void showLoading();
    void hideLoading();
    void setMovies(List<Movies.Movie> movies);
    void onErrorLoading(String message);
}
