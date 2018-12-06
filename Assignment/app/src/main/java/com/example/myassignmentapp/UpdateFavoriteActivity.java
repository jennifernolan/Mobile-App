package com.example.myassignmentapp;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

public class UpdateFavoriteActivity extends AppCompatActivity
{
    public static String EXTRA_FAVORITES_ID = "favorites_id";
    private TextView mPlaceName;
    private EditText mNotes;
    private Button mSaveButton;
    private Toolbar mToolbar;
    private FavoritesDAO mFavoriteDAO;
    private Favorites favorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_favorite);

        mFavoriteDAO = Room.databaseBuilder(this, AppDatabase.class, "db-favorites")
                .allowMainThreadQueries()
                .build()
                .getFavoritesDAO();

        mPlaceName = findViewById(R.id.placename);
        mNotes = findViewById(R.id.favnotes);
        mSaveButton = findViewById(R.id.saveButton);
        mToolbar = findViewById(R.id.toolbar);

        favorite = mFavoriteDAO.getFavoritesWithId(getIntent().getIntExtra(EXTRA_FAVORITES_ID, -1));
        System.out.println(favorite);
        initViews();
    }

    private void initViews()
    {
        setSupportActionBar(mToolbar);
        mPlaceName.setText(favorite.getPlaceName());
        mNotes.setText(favorite.getNotes());

        final int id = favorite.getId();

        mSaveButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String place = mPlaceName.getText().toString();
                String notes = mNotes.getText().toString();

                favorite.setPlaceName(place);
                favorite.setNotes(notes);
                favorite.id = id;

                mFavoriteDAO.update(favorite);
                setResult(RESULT_OK);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_update_options, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.delete:
                mFavoriteDAO.delete(favorite);
                setResult(RESULT_OK);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
