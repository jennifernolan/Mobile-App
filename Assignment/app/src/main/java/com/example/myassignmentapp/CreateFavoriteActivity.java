package com.example.myassignmentapp;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CreateFavoriteActivity extends AppCompatActivity {

    private TextView mPlaceName;
    private EditText mNotes;
    private FavoritesDAO mFavoritesDAO;
    private Button mSaveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //access the layout xml page specified
        setContentView(R.layout.favactivity_detail);

        //get the extra information passed from the intent
        Intent intent = getIntent();
        final String place = intent.getStringExtra("place");

        //access the database using the data access object
        mFavoritesDAO = Room.databaseBuilder(this, AppDatabase.class, "db-favorites")
                .allowMainThreadQueries()
                .build()
                .getFavoritesDAO();

        //find the views and buttons layouts using their specific id in the previously accessed layout xml page
        mPlaceName = findViewById(R.id.placename);
        mSaveButton = findViewById(R.id.saveButton);
        mNotes = findViewById(R.id.favnotes);

        //set the places name
        mPlaceName.setText(place);

        //if the user wants to save their newly created favorite
        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //get the notes the user input and convert them to a string format
                final String notes = mNotes.getText().toString();

                //insert the entered details into the database
                Favorites favorites = new Favorites();
                favorites.setPlaceName(place);
                favorites.setNotes(notes);

                try
                {
                    mFavoritesDAO.insert(favorites);
                    setResult(RESULT_OK);
                    finish();
                }
                catch(SQLiteConstraintException e)
                {
                    //if it is already created then display this toast o the user
                    Toast.makeText(CreateFavoriteActivity.this, "This has already been created", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
