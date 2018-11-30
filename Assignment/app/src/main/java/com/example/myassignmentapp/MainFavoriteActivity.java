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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainfavs_activity);

        mFavoritesDAO = Room.databaseBuilder(this, AppDatabase.class, "db-favorites")
                .allowMainThreadQueries()
                .build()
                .getFavoritesDAO();

        mFavoritesRecyclerView = findViewById(R.id.favoritesRecyclerView);
        mFavoritesRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mFavoritesRecyclerAdapter = new FavoritesRecyclerAdapter(this, new ArrayList<Favorites>());
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


}