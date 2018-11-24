package com.example.myassignmentapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Diner extends Activity{
    ListView listView;

    ArrayAdapter<String> adapter;
    ArrayList<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);

        listView = findViewById(R.id.placelistview);
        data = new ArrayList<String>();
        data.add("Eddie Rockets");
        data.add("Wow Burger");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String place = adapter.getItem(position);
                Intent intent = new Intent(Diner.this, DetailsActivity.class);
                intent.putExtra("place_id", place);
                startActivity(intent);
            }
        });
    }
}
