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
        setContentView(R.layout.favactivity_detail);

        Intent intent = getIntent();
        final String place = intent.getStringExtra("place");

        mFavoritesDAO = Room.databaseBuilder(this, AppDatabase.class, "db-favorites")
                .allowMainThreadQueries()
                .build()
                .getFavoritesDAO();

        mPlaceName = findViewById(R.id.placename);
        mSaveButton = findViewById(R.id.saveButton);
        mNotes = findViewById(R.id.favnotes);

        mPlaceName.setText(place);

        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String notes = mNotes.getText().toString();

                Favorites favorites = new Favorites();
                favorites.setPlaceName(place);
                favorites.setNotes(notes);

                System.out.println(favorites);

                try
                {
                    mFavoritesDAO.insert(favorites);
                    System.out.println(mFavoritesDAO);
                    setResult(RESULT_OK);
                    finish();
                }
                catch(SQLiteConstraintException e)
                {
                    Toast.makeText(CreateFavoriteActivity.this, "This has already been created", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
