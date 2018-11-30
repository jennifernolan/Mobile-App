package com.example.myassignmentapp;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "favorites")
public class Favorites {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int id;

    private String placeName;

    public void setPlaceName(String placeName)
    {
        this.placeName = placeName;
    }

    public String getPlaceName()
    {
        return placeName;
    }

    @NonNull
    public int getId()
    {
        return id;
    }
}
