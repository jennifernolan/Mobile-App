package com.example.myassignmentapp;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.myassignmentapp.Favorites;

//used to access the database
@Database(entities = {Favorites.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract FavoritesDAO getFavoritesDAO();
}
