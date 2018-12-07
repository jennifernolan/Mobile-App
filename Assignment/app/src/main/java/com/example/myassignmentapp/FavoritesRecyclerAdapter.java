package com.example.myassignmentapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

//this class is used as an adapter to get the list of database entries from the database and display them back to the user on the MainFavoriteActivity class
public class FavoritesRecyclerAdapter extends RecyclerView.Adapter<FavoritesRecyclerAdapter.ViewHolder>
{
    interface ActionCallback
    {
        void onLongClickListener(Favorites favorite);
    }

    private Context context;
    private List<Favorites>  favoritesList;
    private ActionCallback mActionCallbacks;

    FavoritesRecyclerAdapter(Context context, List<Favorites> favoritesList)
    {
        this.context = context;
        this.favoritesList = favoritesList;
    }

    //create the layout for the list of the returned data from the database
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.favorite_rows, parent, false);
        return new ViewHolder(view);
    }

    //get the adapters position
    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        holder.bindData(position);
    }

    //get the size of the favorites table in the database
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

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener {
        private TextView mPlaceName;

        ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnLongClickListener(this);
            mPlaceName = itemView.findViewById(R.id.placename);
        }

        //display the list values on the MainFavoriteActivity class
        void bindData(int position) {
            Favorites favorites = favoritesList.get(position);
            String place = favorites.getPlaceName();
            mPlaceName.setText(place);
        }

        //if the user long clicks on one of the lists elements then get the position of that element
        @Override
        public boolean onLongClick(View v)
        {
            if(mActionCallbacks != null)
            {
                mActionCallbacks.onLongClickListener(favoritesList.get(getAdapterPosition()));
            }
            return true;
        }
    }

    void addActionCallback(ActionCallback actionCallbacks)
    {
        mActionCallbacks = actionCallbacks;
    }
}
