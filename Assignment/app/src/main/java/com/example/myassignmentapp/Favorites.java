package com.example.myassignmentapp;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "favorites")
public class Favorites {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int id;

    @ColumnInfo
    private String placeName;
    @ColumnInfo
    private String notes;

    public void setPlaceName(String placeName)
    {
        this.placeName = placeName;
    }

    public String getPlaceName()
    {
        return placeName;
    }

    public void setNotes(String notes)
    {
        this.notes = notes;
    }

    public String getNotes()
    {
        return notes;
    }

    @NonNull
    public int getId()
    {
        return id;
    }
}
