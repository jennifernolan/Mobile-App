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

public class FastFood extends AppCompatActivity {

    ListView listView;

    ArrayAdapter<String> adapter;
    ArrayList<String> data;

    private Button favs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);

        favs = findViewById(R.id.favs);

        listView = findViewById(R.id.placelistview);
        data = new ArrayList<String>();
        data.add("Boojum");
        data.add("Burritos and Blues");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String place = adapter.getItem(position);
                Intent intent = new Intent(FastFood.this, DetailsActivity.class);
                intent.putExtra("place_id", place);
                startActivity(intent);
            }
        });

        favs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FastFood.this, MainFavoriteActivity.class);
                startActivity(intent);
            }
        });
    }
}
