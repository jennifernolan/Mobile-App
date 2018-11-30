package com.example.myassignmentapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class FavoritesRecyclerAdapter extends RecyclerView.Adapter<FavoritesRecyclerAdapter.ViewHolder>
{
    private Context context;
    private List<Favorites>  favoritesList;

    FavoritesRecyclerAdapter(Context context, List<Favorites> favoritesList)
    {
        this.context = context;
        this.favoritesList = favoritesList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.favorite_rows, parent, false);
        return new ViewHolder(view) {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        };
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        holder.bindData(position);
    }

    @Override
    public int getItemCount()
    {
        return favoritesList.size();
    }

    void updateData(List<Favorites> favorites)
    {
        this.favoritesList = favorites;
        notifyDataSetChanged();
    }

    abstract class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener
    {
        private TextView mPlaceName;

        ViewHolder(View itemView)
        {
            super(itemView);
            itemView.setOnLongClickListener(this);
            mPlaceName = itemView.findViewById(R.id.placename);
        }

        void bindData(int position)
        {
            Favorites favorites = favoritesList.get(position);
            String place = favorites.getPlaceName();
            mPlaceName.setText(place);
        }
    }
}
