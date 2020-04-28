package com.mouhsinbourqaiba.android.popularmoviestage1.workflow.home;


import androidx.annotation.NonNull;

import com.mouhsinbourqaiba.android.popularmoviestage1.Util;
import com.mouhsinbourqaiba.android.popularmoviestage1.model.Movies;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenter{

    private HomeView homeView;

    public HomePresenter(HomeView homeView){
        this.homeView = homeView;
    }

    void getPopularMovies(){
        homeView.showLoading();

        Call<Movies> moviesCall = Util.getApi().getPopularMovies();
        moviesCall.enqueue(new Callback<Movies>() {
            @Override
            public void onResponse(@NonNull Call<Movies> call, @NonNull Response<Movies> response) {
                homeView.hideLoading();
                if(response.isSuccessful() && response.body()!=null){
                    homeView.setMovies(response.body().getMovies());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Movies> call, @NonNull Throwable t) {
                homeView.hideLoading();
                homeView.onErrorLoading(t.getMessage());

            }
        });

    }

    void getTopRatedMovies(){
        homeView.showLoading();

        Call<Movies> moviesCall = Util.getApi().getTopRatedMovies();
        moviesCall.enqueue(new Callback<Movies>() {
            @Override
            public void onResponse(@NonNull Call<Movies> call, @NonNull Response<Movies> response) {
                homeView.hideLoading();
                if(response.isSuccessful() && response.body()!=null){
                    homeView.setMovies(response.body().getMovies());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Movies> call, @NonNull Throwable t) {
                homeView.hideLoading();
                homeView.onErrorLoading(t.getMessage());

            }
        });

    }


}
