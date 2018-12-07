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

//Activity that is displayed when the project opens
public class MainActivity extends AppCompatActivity {

    ListView listView;

    ArrayAdapter<String> adapter;
    ArrayList<String> data;
    private Button favs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //access the layout xml file specified
        setContentView(R.layout.activity_main);

        //find the button and view specified in the layout xml using their id
        favs = findViewById(R.id.favs);

        listView = findViewById(R.id.listview);

        //create an array list of strings
        data = new ArrayList<String>();
        //add strings to the arraylist
        data.add("Cafe");
        data.add("Fast Food");
        data.add("Pub");
        data.add("Sandwich Bar");
        data.add("Restaurant");
        data.add("Diner");

        //create an adapter that contains the string array list
       adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
       //set and display the adapter which contains the array list of strings
       listView.setAdapter(adapter);

        //when an array list element is selected in the adapter do the following:
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //display a quick toast message informing the user which element of the adapter they clicked on using the adapters position
                Toast.makeText(MainActivity.this, "You clicked " + adapter.getItem(position), Toast.LENGTH_SHORT).show();

                //if the adapters position equals a specific type of place then do the following: (same for all)
                if(adapter.getItem(position) == "Cafe")
                {
                    //create an intent that will go from this activity to another specified activity
                    Intent intent = new Intent(MainActivity.this, Cafe.class);
                    //start the activity
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

        //if the user selects the favorites button at the top of the page they are brought to the users saved favorites, from the database, displayed in a list
        favs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainFavoriteActivity.class);
                startActivity(intent);
            }
        });
    }
}
