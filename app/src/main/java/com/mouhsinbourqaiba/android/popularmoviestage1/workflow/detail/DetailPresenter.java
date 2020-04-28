package com.mouhsinbourqaiba.android.popularmoviestage1.workflow.detail;

import com.mouhsinbourqaiba.android.popularmoviestage1.model.Movies;

public class DetailPresenter {

    DetailView view;

    public DetailPresenter(DetailView view) {
        this.view = view;
    }

    public void getMovie(Movies.Movie movie){
        if(movie!=null){
            view.displayViews();
        }
    }
}
