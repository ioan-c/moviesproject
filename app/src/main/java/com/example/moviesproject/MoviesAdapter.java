package com.example.moviesproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {
    private List<Movie> mDataset;
    private Context mContext;



    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textView;
        View itemView;
        public MyViewHolder(View v) {
            super(v);
            itemView = v;
            textView = v.findViewById(R.id.text_movie_title);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MoviesAdapter(List<Movie> myDataset, Context context) {

        mDataset = myDataset;
        mContext = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MoviesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        // create a new view
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie, parent, false);

        MyViewHolder vh = new MyViewHolder(itemView);

        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textView.setText(mDataset.get(position).getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openDetailsActivity = new Intent(mContext, DetailActivity.class);
                openDetailsActivity.putExtra(DetailActivity.EXTRA_MOVIE, mDataset.get(holder.getAdapterPosition()));
                mContext.startActivity(openDetailsActivity);
            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {

        return mDataset == null ? 0 : mDataset.size();
    }
}