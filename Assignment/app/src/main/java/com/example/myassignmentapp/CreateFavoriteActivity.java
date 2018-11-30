package com.example.myassignmentapp;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CreateFavoriteActivity extends AppCompatActivity {

    private TextView mPlaceName;
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

        mPlaceName.setText(place);

        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Favorites favorites = new Favorites();
                favorites.setPlaceName(place);

                try
                {
                    mFavoritesDAO.insert(favorites);
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
