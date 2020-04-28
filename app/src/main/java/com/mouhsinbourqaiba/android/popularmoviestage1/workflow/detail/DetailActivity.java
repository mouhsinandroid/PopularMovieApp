package com.mouhsinbourqaiba.android.popularmoviestage1.workflow.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.mouhsinbourqaiba.android.popularmoviestage1.R;
import com.mouhsinbourqaiba.android.popularmoviestage1.Util;
import com.mouhsinbourqaiba.android.popularmoviestage1.model.Movies;
import com.squareup.picasso.Picasso;


public class DetailActivity extends AppCompatActivity implements DetailView{
    private Movies.Movie movie;
    private DetailPresenter presenter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        presenter = new DetailPresenter(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.detail_movies);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        initIntent();

    }

    void initIntent(){
        Intent intent = getIntent();
        movie = (Movies.Movie) intent.getSerializableExtra(Util.EXTRA_MOVIES);
        if(movie!=null){
            presenter.getMovie(movie);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()== android.R.id.home) {
                onBackPressed();
        }
        return true;
    }

    @Override
    public void displayViews() {
        TextView titleTextView  = findViewById(R.id.tv_title);
        titleTextView.setText(movie.getTitle());

        ImageView imgPoster = findViewById(R.id.img_post);
        if(movie.getPosterPath()!=null){
            String imgUrl = Util.BASE_URL_IMG + movie.getPosterPath();
            Picasso.get().load(imgUrl).into(imgPoster);
        }

        TextView dateTextView  = findViewById(R.id.tv_date);
        dateTextView.setText(movie.getReleaseDate());

        TextView ratedTextView  = findViewById(R.id.tv_rate_movie);
        String rateLevel = getString(R.string.rate_text , movie.getVoteAverage());
        ratedTextView.setText(rateLevel);

        TextView overviewTextView  = findViewById(R.id.tv_overview);
        overviewTextView.setText(movie.getOverview());

    }
}
