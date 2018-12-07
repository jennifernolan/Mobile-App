package com.example.myassignmentapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

//displays a list of restaurants
public class Restaurant extends AppCompatActivity{
    ListView listView;

    ArrayAdapter<String> adapter;
    ArrayList<String> data;

    private Button favs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //access the xml layout for this class
        setContentView(R.layout.activity_place);

        //have the buttons and views find their corresponding layout from the xml using ids
        favs = findViewById(R.id.favs);

        listView = findViewById(R.id.placelistview);
        //create a new string array list
        data = new ArrayList<String>();
        //add the following strings to the array list
        data.add("Bunsen");
        data.add("The Jar");

        //create a new adapter to stored and display the array list
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        //set and display the adapter
        listView.setAdapter(adapter);

        //if one of the items in the list is clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //get its position in the adapter/array - returns the string set in the adapter
                String place = adapter.getItem(position);
                //go from this class to the DetailsActivity class
                Intent intent = new Intent(Restaurant.this, DetailsActivity.class);
                //add place id, storing the adapters string, and add it to the intent
                intent.putExtra("place_id", place);
                //start the activity and go to the DetailsActivity class
                startActivity(intent);
            }
        });

        //this button brings you to the list of favorites gathered from the database to allow the user to see what other places they have favorited
        favs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create an intent to go to the MainFavoriteActivity class to view the favorites list
                Intent intent = new Intent(Restaurant.this, MainFavoriteActivity.class);
                //start the activity and go to the MainFavoriteActivity class
                startActivity(intent);
            }
        });
    }
}
