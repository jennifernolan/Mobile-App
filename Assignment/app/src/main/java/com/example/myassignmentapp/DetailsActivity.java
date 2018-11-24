package com.example.myassignmentapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends Activity {
    private static final String[] PLACE_DETAILS = {
            "American coffee company and coffeehouse chain. Starbucks was founded in Seattle, Washington in 1971.\n\nStarbucks locations serve hot and cold drinks, whole-bean coffee, microground instant coffee known as espresso, caffe latte, full and loose leaf teas including Teavana tea products,\n\nEvolution Fresh juices, Frappuccino beverages, La Boulange pastries, and snacks including items such as chips and crackers.\n\nMany stores sell pre-packaged food items, hot and cold sandwiches, and drinkware including mugs and tumblers\n\n",
            "Costa Coffee is a British multinational coffeehouse company headquartered in Dunstable, Bedfordshire, and a wholly owned subsidiary of Whitbread.\n\nCosta Coffee was founded in London in 1971 by the Costa family as a wholesale operation supplying roasted coffee to caterers and specialist Italian coffee shops. \n\nCosta sells: Hot drinks(coffees, teas and hot chocolates), Cold drinks(Frostino and fruit coolers),\n\nSavoury snacks(including sandwiches and breakfast items) and Cakes and pastries(including cookies, brownies and croissants)\n\n",
            "Small little cafe on Kevin Street, Dublin. This place is great for a coffee and a sandwich.\n\nIt does breakfast as well as Scones, lovely Danishes and a cracking breakfast roll. Sandwiches are very well priced.\n\nIt has a nice seating area to watch the world go by.\n\n",
            "Insomnia Coffee Company is an Irish independent coffee chain. The headquarters are in Dublin.\n\nThe first store location opened in the back of a Galway bookstore in August 1997. Insomnia stores serve both hot and cold drinks, Fairtrade premium coffee, gourmet sandwiches, salads, soups, snacks, cakes and pastries.\n\nIt also runs seasonal campaigns throughout the year which introduces new products such as their red velvet hot chocolate at Christmas or the pumpkin pie latte during Autumn."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);

        ImageView image = (ImageView)findViewById(R.id.logo);
        Intent intent = getIntent();
        String place = intent.getStringExtra("place_id");
        String text = "";
        if(place.equals("Starbucks"))
        {
            image.setImageResource(R.drawable.starbucks);
            text = PLACE_DETAILS[0];
        }
        else if(place.equals("Costa"))
        {
            image.setImageResource(R.drawable.costa);
            text = PLACE_DETAILS[1];
        }
        else if(place.equals("Toasted"))
        {
            image.setImageResource(R.drawable.toasted);
            text = PLACE_DETAILS[2];
        }
        else if(place.equals("Insomnia"))
        {
            image.setImageResource(R.drawable.insomnia);
            text = PLACE_DETAILS[3];
        }

        TextView tv = (TextView) findViewById(R.id.place_info);
        tv.setText(text);
    }
}
