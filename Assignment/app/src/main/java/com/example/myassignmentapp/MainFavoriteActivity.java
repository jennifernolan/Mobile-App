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

public class MainFavoriteActivity extends AppCompatActivity {

    private RecyclerView mFavoritesRecyclerView;
    private FavoritesRecyclerAdapter mFavoritesRecyclerAdapter;
    private FavoritesDAO mFavoritesDAO;
    private Button menu;

    private static final int RC_UPDATE_FAVS = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainfavs_activity);

        mFavoritesDAO = Room.databaseBuilder(this, AppDatabase.class, "db-favorites")
                .allowMainThreadQueries()
                .build()
                .getFavoritesDAO();
        System.out.println(mFavoritesDAO);

        mFavoritesRecyclerView = findViewById(R.id.favoritesRecyclerView);
        mFavoritesRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mFavoritesRecyclerAdapter = new FavoritesRecyclerAdapter(this, new ArrayList<Favorites>());

        mFavoritesRecyclerAdapter.addActionCallback(new FavoritesRecyclerAdapter.ActionCallback()
        {
            @Override
            public void onLongClickListener(Favorites favorite)
            {
                Intent intent = new Intent(MainFavoriteActivity.this, UpdateFavoriteActivity.class);
                intent.putExtra(UpdateFavoriteActivity.EXTRA_FAVORITES_ID, favorite.getId());
                startActivityForResult(intent, RC_UPDATE_FAVS);
            }
        });

        mFavoritesRecyclerView.setAdapter(mFavoritesRecyclerAdapter);

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

    private void loadfavs()
    {
        mFavoritesRecyclerAdapter.updateData(mFavoritesDAO.getFavorites());
    }

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