package com.example.myassignmentapp;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

//this class displays the users favorited places from the database in a list format
public class MainFavoriteActivity extends AppCompatActivity {

    private RecyclerView mFavoritesRecyclerView;
    private FavoritesRecyclerAdapter mFavoritesRecyclerAdapter;
    private FavoritesDAO mFavoritesDAO;
    private Button menu;

    private static final int RC_UPDATE_FAVS = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //access the layout xml page specified
        setContentView(R.layout.mainfavs_activity);

        //access the database using the data access object
        mFavoritesDAO = Room.databaseBuilder(this, AppDatabase.class, "db-favorites")
                .allowMainThreadQueries()
                .build()
                .getFavoritesDAO();

        //find the view using its specified id in the layout xml file
        mFavoritesRecyclerView = findViewById(R.id.favoritesRecyclerView);
        //set the view to a linear layout/list like structure
        mFavoritesRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //create a recycler adapter to hold the database entries that is displayed in a list format
        mFavoritesRecyclerAdapter = new FavoritesRecyclerAdapter(this, new ArrayList<Favorites>());

        //if the user wants to update a favorite start an intent.
        mFavoritesRecyclerAdapter.addActionCallback(new FavoritesRecyclerAdapter.ActionCallback()
        {
            @Override
            public void onLongClickListener(Favorites favorite)
            {
                //go from this class to the UpdateFavoriteActivity class
                Intent intent = new Intent(MainFavoriteActivity.this, UpdateFavoriteActivity.class);
                //add the id of the selected list item to the intent
                intent.putExtra(UpdateFavoriteActivity.EXTRA_FAVORITES_ID, favorite.getId());
                //start the activity and get a result back
                startActivityForResult(intent, RC_UPDATE_FAVS);
            }
        });

        //set the adapter that will hold all the database entries for the user
        mFavoritesRecyclerView.setAdapter(mFavoritesRecyclerAdapter);

        //if the user selects the menu button redirect them back to the MainActivity class
        menu = findViewById(R.id.menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainFavoriteActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        loadfavs();
    }

    //get the data stored in the database
    private void loadfavs()
    {
        mFavoritesRecyclerAdapter.updateData(mFavoritesDAO.getFavorites());
    }

    //if the updating of the favorite activity was successful the load the list of favorites
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_UPDATE_FAVS && resultCode == RESULT_OK)
        {
            loadfavs();
           /* Intent intent = new Intent(MainFavoriteActivity.this, UpdateFavoriteActivity.class);
            startActivity(intent);*/
        }
    }
}