package com.example.moviefx.utility;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviefx.R;
import com.example.moviefx.pojo.Movie;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.HolderView> {
    private ArrayList<Movie> movieArrayList;
    private Context context;

    public DataAdapter(Context context, ArrayList<Movie> movieArrayList) {
        this.context = context;
        this.movieArrayList = movieArrayList;
    }

    @NonNull
    @Override
    public HolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_view, parent, false);
        HolderView holder = new HolderView(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderView holder, int position) {
        String title = movieArrayList.get(position).getTitle();
        String release = movieArrayList.get(position).getReleaseYear();
        String description = movieArrayList.get(position).getDescription();
        holder.title.setText(title);
        holder.release.setText(release);
        holder.description.setText(description);
    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }

    public class HolderView extends RecyclerView.ViewHolder {

        public TextView title, release, description;

        public HolderView(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            release = itemView.findViewById(R.id.year);
            description = itemView.findViewById(R.id.description);
        }
    }
}
