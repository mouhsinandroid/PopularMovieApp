package com.mouhsinbourqaiba.android.popularmoviestage1.api;

import com.mouhsinbourqaiba.android.popularmoviestage1.model.Movies;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MoviesApi {

    @GET("popular?api_key=")
    Call<Movies> getPopularMovies();

    @GET("top_rated?api_key=")
    Call<Movies> getTopRatedMovies();
}
