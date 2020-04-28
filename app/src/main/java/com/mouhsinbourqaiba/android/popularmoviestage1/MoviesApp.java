package com.mouhsinbourqaiba.android.popularmoviestage1;

import android.app.Application;
import android.content.res.Configuration;

import androidx.annotation.NonNull;

public class MoviesApp extends Application {

    private static MoviesApp app;

    public static MoviesApp getInstance(){
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        app = this;
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

}
