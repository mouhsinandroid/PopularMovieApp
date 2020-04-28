package com.mouhsinbourqaiba.android.popularmoviestage1;

import com.mouhsinbourqaiba.android.popularmoviestage1.api.MovieClient;
import com.mouhsinbourqaiba.android.popularmoviestage1.api.MoviesApi;

public class Util {
    public static final String EXTRA_MOVIES = "movie";

    public static String BASE_URL = "https://api.themoviedb.org/3/movie/";
    public static String BASE_URL_IMG = "https://image.tmdb.org/t/p/w185";




    public static MoviesApi getApi(){ return MovieClient.getMovies().create(MoviesApi.class); }

}
