package com.example.myassignmentapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    ArrayAdapter<String> adapter;
    ArrayList<String> data;
    private Button favs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        favs = findViewById(R.id.favs);

        listView = findViewById(R.id.listview);

        data = new ArrayList<String>();
        data.add("Cafe");
        data.add("Fast Food");
        data.add("Pub");
        data.add("Sandwich Bar");
        data.add("Restaurant");
        data.add("Diner");

       adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
       listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "You clicked " + adapter.getItem(position), Toast.LENGTH_SHORT).show();

                if(adapter.getItem(position) == "Cafe")
                {
                    Intent intent = new Intent(MainActivity.this, Cafe.class);
                    MainActivity.this.startActivity(intent);
                }
                if(adapter.getItem(position) == "Fast Food")
                {
                    Intent intent = new Intent(MainActivity.this, FastFood.class);
                    MainActivity.this.startActivity(intent);
                }
                if(adapter.getItem(position) == "Pub")
                {
                    Intent intent = new Intent(MainActivity.this, Pub.class);
                    MainActivity.this.startActivity(intent);
                }
                if(adapter.getItem(position) == "Sandwich Bar")
                {
                    Intent intent = new Intent(MainActivity.this, SandwichBar.class);
                    MainActivity.this.startActivity(intent);
                }
                if(adapter.getItem(position) == "Restaurant")
                {
                    Intent intent = new Intent(MainActivity.this, Restaurant.class);
                    MainActivity.this.startActivity(intent);
                }
                if(adapter.getItem(position) == "Diner")
                {
                    Intent intent = new Intent(MainActivity.this, Diner.class);
                    MainActivity.this.startActivity(intent);
                }
            }
        });

        favs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainFavoriteActivity.class);
                startActivity(intent);
            }
        });
    }
}
