package com.example.myassignmentapp;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.myassignmentapp.Favorites;

import java.util.List;

//queries, inserts, updates and deletes to the database that the Data Access Object can perform
@Dao
public interface FavoritesDAO {

    @Insert
    public void insert(Favorites... favorites);

    @Update
    public void update(Favorites... favorites);

    @Delete
    public void delete(Favorites... favorites);

    @Query("SELECT * FROM favorites")
    public List<Favorites> getFavorites();

    @Query("SELECT * FROM favorites WHERE id = :number")
    public Favorites getFavoritesWithId(int number);
}
