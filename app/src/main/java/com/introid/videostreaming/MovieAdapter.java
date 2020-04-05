package com.introid.videostreaming;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {
    private Context mContext;
    private List<Movie> mData;

    public MovieAdapter(Context mContext, List<Movie> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MovieAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new MyViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MyViewHolder holder, int position) {
        holder.tvTitle.setText( mData.get( position ).getTitle() );
        holder.imgMovie.setImageResource( mData.get( position ).getThumbnail());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgMovie;
        TextView tvTitle;
        MyViewHolder(@NonNull View itemView) {
            super( itemView );
            imgMovie= itemView.findViewById( R.id.item_movie_img );
            tvTitle= itemView.findViewById( R.id.item_movie_title );
        }
    }
}
