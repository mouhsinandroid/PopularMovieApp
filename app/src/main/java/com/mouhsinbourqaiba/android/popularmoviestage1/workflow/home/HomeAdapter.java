package com.mouhsinbourqaiba.android.popularmoviestage1.workflow.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mouhsinbourqaiba.android.popularmoviestage1.R;
import com.mouhsinbourqaiba.android.popularmoviestage1.Util;
import com.mouhsinbourqaiba.android.popularmoviestage1.model.Movies;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HomeAdapter  extends RecyclerView.Adapter<HomeAdapter.RecyclerViewHolder>{

    private static ClickListener clickListener;
    private List<Movies.Movie> movies;
    private Context context;

    public  HomeAdapter(Context context , List<Movies.Movie> movies){
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_movies , parent , false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        if(movies.get(position).getPosterPath()!=null || !movies.get(position).getPosterPath().equalsIgnoreCase("")){
            String imgUrl = Util.BASE_URL_IMG + movies.get(position).getPosterPath();
                Picasso.get().load(imgUrl).into(holder.imgMovie);
        }
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }


 static class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imgMovie;
        RecyclerViewHolder(@NonNull View itemView){
            super(itemView);
            imgMovie = itemView.findViewById(R.id.img_movie);
            itemView.setOnClickListener(this);
        }



        @Override
        public void onClick(View v) {
            clickListener.onClick(v, getAdapterPosition());
        }
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        HomeAdapter.clickListener = clickListener;
    }

    public interface ClickListener {
        void onClick(View view, int position);
    }
}
