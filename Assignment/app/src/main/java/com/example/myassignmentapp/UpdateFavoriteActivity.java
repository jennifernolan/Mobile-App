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

//Class used to allow the user to update their notes on a particular place.
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
        //access the xml layout for this class
        setContentView(R.layout.activity_update_favorite);

        //access the database with the Data Access Object
        mFavoriteDAO = Room.databaseBuilder(this, AppDatabase.class, "db-favorites")
                .allowMainThreadQueries()
                .build()
                .getFavoritesDAO();

        //have the various views find their corresponding layout from the xml using ids
        mPlaceName = findViewById(R.id.placename);
        mNotes = findViewById(R.id.favnotes);
        mSaveButton = findViewById(R.id.saveButton);
        mToolbar = findViewById(R.id.toolbar);

        //select the clicked list item data from the database using its unique id
        favorite = mFavoriteDAO.getFavoritesWithId(getIntent().getIntExtra(EXTRA_FAVORITES_ID, -1));
        initViews();
    }

    private void initViews()
    {
        //set the toolbar as an action bar to enable the delete image to be selected
        setSupportActionBar(mToolbar);

        //set the text of the two layouts with the data currently stored in the database
        mPlaceName.setText(favorite.getPlaceName());
        mNotes.setText(favorite.getNotes());

        //get the selected list items id
        final int id = favorite.getId();

        //when the save button is clicked get the place name and the edited notes and update their values in the database
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

    //display the delete symbol in the toolbar by access it using its corresponding xml layout file
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_update_options, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //if the delete symbol is selected remove/delete the selected list item from the database
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
