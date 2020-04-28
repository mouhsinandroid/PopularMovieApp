package com.mouhsinbourqaiba.android.popularmoviestage1.workflow.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mouhsinbourqaiba.android.popularmoviestage1.R;
import com.mouhsinbourqaiba.android.popularmoviestage1.Util;
import com.mouhsinbourqaiba.android.popularmoviestage1.model.Movies;
import com.mouhsinbourqaiba.android.popularmoviestage1.workflow.detail.DetailActivity;

import java.util.List;

public class HomeActivity extends AppCompatActivity implements HomeView{
    private HomePresenter presenter;
    private RecyclerView recyclerViewMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.pop_movies);
        }
        recyclerViewMovies = findViewById(R.id.rc_movies);
        presenter = new HomePresenter(this);
        presenter.getPopularMovies();
    }

    @Override
    public void showLoading() {
        findViewById(R.id.progressBar).setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        findViewById(R.id.progressBar).setVisibility(View.GONE);
    }

    @Override
    public void setMovies(final List<Movies.Movie> movies) {
        HomeAdapter adapter = new HomeAdapter(this , movies);
        recyclerViewMovies.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2,
                GridLayoutManager.VERTICAL, false);
        recyclerViewMovies.setLayoutManager(layoutManager);
        recyclerViewMovies.setNestedScrollingEnabled(true);
        adapter.notifyDataSetChanged();

        //Goto Detail
        adapter.setOnItemClickListener((v, position) -> {
            Intent intent = new Intent(getApplicationContext() , DetailActivity.class);
            intent.putExtra(Util.EXTRA_MOVIES, movies.get(position));
            startActivity(intent);
        });

    }

    @Override
    public void onErrorLoading(String message) {
        Toast.makeText(HomeActivity.this , message , Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_pop_movies:
                getSupportActionBar().setTitle(R.string.pop_movies);
                presenter.getPopularMovies();
                return true;
            case R.id.action_rated_movies:
                getSupportActionBar().setTitle(R.string.top_rated_movies);
                presenter.getTopRatedMovies();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
