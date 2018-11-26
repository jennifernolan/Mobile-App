package com.example.myassignmentapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends Activity {
    private static final String[] PLACE_DETAILS = {
            "American coffee company and coffeehouse chain. Starbucks was founded in Seattle, Washington in 1971.\n\nStarbucks locations serve hot and cold drinks, whole-bean coffee, microground instant coffee known as espresso, caffe latte, full and loose leaf teas including Teavana tea products,\n\nEvolution Fresh juices, Frappuccino beverages, La Boulange pastries, and snacks including items such as chips and crackers.\n\nMany stores sell pre-packaged food items, hot and cold sandwiches, and drinkware including mugs and tumblers\n\n",
            "Costa Coffee is a British multinational coffeehouse company headquartered in Dunstable, Bedfordshire, and a wholly owned subsidiary of Whitbread.\n\nCosta Coffee was founded in London in 1971 by the Costa family as a wholesale operation supplying roasted coffee to caterers and specialist Italian coffee shops. \n\nCosta sells: Hot drinks(coffees, teas and hot chocolates), Cold drinks(Frostino and fruit coolers),\n\nSavoury snacks(including sandwiches and breakfast items) and Cakes and pastries(including cookies, brownies and croissants)\n\n",
            "Small little cafe on Kevin Street, Dublin. This place is great for a coffee and a sandwich.\n\nIt does breakfast as well as Scones, lovely Danishes and a cracking breakfast roll. Sandwiches are very well priced.\n\nIt has a nice seating area to watch the world go by.\n\n",
            "Insomnia Coffee Company is an Irish independent coffee chain. The headquarters are in Dublin.\n\nThe first store location opened in the back of a Galway bookstore in August 1997. Insomnia stores serve both hot and cold drinks, Fairtrade premium coffee, gourmet sandwiches, salads, soups, snacks, cakes and pastries.\n\nIt also runs seasonal campaigns throughout the year which introduces new products such as their red velvet hot chocolate at Christmas or the pumpkin pie latte during Autumn.\n\n",
            "You'll find them upstairs at The Workman's Club in their beer garden.\n\nAn awesome juicy burger with crisp, smoked American style bacon and sauteéd jalapenos plus sandwiching it between a rich buttery, crumby bun that's smothered in creamy and slightly tangy Wowburger sauce.\n\nAll toppings are free.\n\n",
            "Eddie Rocket’s Limited is an Irish restaurant chain, with its headquarters in Dublin.\n\nIt offers American-style food in 1950s' style diners. It is owned by Rocket Restaurants Limited.\n\n",
            "Boojum arrived on the scene in 2007 as one of the most disruptive food concepts to hit the high street in a long time.\n\nA casual Mexican burrito bar with award winning food at great prices. The menu is simple and has changed little since opening, focusing on burritos, tacos and a small number of other traditional Mexican street dishes.\n\nAt Boojum there is no table service.\n\n",
            "At Burritos & Blues Fresh Mexican Grill, what you see is what you get.\n\nAll the food is prepared in front of you while you wait, using the best quality, fresh-from-the-market ingredients prepared daily.\n\nWherever possible, they use only Irish produce. All meat is 100% certified Irish and is never frozen or reheated.\n\n",
            "Venue for live music and clubs or relaxing in The Parlour, decorated in 1950s sitting room-style.\n\nFamed for its atmosphere, quality and live music. A traditional country pub in the heart of the city, the venue has played host to such musical legends as Jeff Buckley, Nick Cave and Christy Moore.\n\nA life-sized statue, complete with a pint of Guinness, stands at the bar ensuring that you ‘never need drink alone’.\n\n",
            "Bunsen Burger is the hip and trendy burger joint, situated in three prime locations around the city centre serving straight up burgers.\n\nThe cool factor starts off with the menu. Less is more with it all printed on a business card.\n\n",
            "Open seven days a week with a live DJ every Friday and Saturday night, drop in and try something from our extensive drinks menu with one of our delicious wood-fired pizzas.\n\n",
            "Subway is an American privately held fast food restaurant franchise that primarily sells submarine sandwiches (subs) and salads. Subway is one of the fastest-growing franchises in the world.\n\nIt is the largest single-brand restaurant chain, and the largest restaurant operator, in the world. Subway's core product is the submarine sandwich. In addition to these, the chain also sells wraps, salad, paninis, and baked goods (including cookies, doughnuts, and muffins).\n\n",
            "SPAR is a Dutch-founded multinational group that manages independently owned and operated food retail stores.\n\n It was founded in the Netherlands in 1932, by Adriaan van Well. Its headquarters are located in Amsterdam. The company operates a partnership programme and has a presence in most European countries.\n\nThe SPAR motto is \"under the tree\".\n\n"
    };
    private Button moreInfo;
    private Button directions;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);

        ImageView image = (ImageView)findViewById(R.id.logo);
        Intent intent = getIntent();
        String place = intent.getStringExtra("place_id");
        String text = "";
        moreInfo = findViewById(R.id.moreInfo);
        directions = findViewById(R.id.directions);

        if(place.equals("Starbucks"))
        {
            image.setImageResource(R.drawable.starbucks);
            text = PLACE_DETAILS[0];
            moreInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.starbucks.ie/"));
                    startActivity(intent);
                }
            });
            directions.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    double lon = -6.2670536;
                    double lat = 53.3376248;
                    String location = "geo:" + lat + "," + lon + "?z=18";
                    final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(location));
                    startActivity(intent);
                }
            });
        }
        else if(place.equals("Costa"))
        {
            image.setImageResource(R.drawable.costa);
            text = PLACE_DETAILS[1];
            moreInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.costaireland.ie/"));
                    startActivity(intent);
                }
            });
            directions.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    double lon = -6.2660381;
                    double lat = 53.3379645;
                    String location = "geo:" + lat + "," + lon + "?z=18";
                    final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(location));
                    startActivity(intent);
                }
            });
        }
        else if(place.equals("Toasted"))
        {
            image.setImageResource(R.drawable.toasted);
            text = PLACE_DETAILS[2];
            moreInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tripadvisor.ie/Restaurant_Review-g186605-d7260504-Reviews-Toasted_Cafe-Dublin_County_Dublin.html"));
                    startActivity(intent);
                }
            });
            directions.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    double lon = -6.2667353;
                    double lat = 53.3376162;
                    String location = "geo:" + lat + "," + lon + "?z=18";
                    final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(location));
                    startActivity(intent);
                }
            });
        }
        else if(place.equals("Insomnia"))
        {
            image.setImageResource(R.drawable.insomnia);
            text = PLACE_DETAILS[3];
            moreInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.insomnia.ie/"));
                    startActivity(intent);
                }
            });
            directions.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    double lon = -6.2656169;
                    double lat = 53.3370771;
                    String location = "geo:" + lat + "," + lon + "?z=18";
                    final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(location));
                    startActivity(intent);
                }
            });
        }
        else if(place.equals("Wow Burger"))
        {
            image.setImageResource(R.drawable.wowburger);
            text = PLACE_DETAILS[4];
            moreInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://wowburger.ie/"));
                    startActivity(intent);
                }
            });
            directions.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    double lon = -6.2655212;
                    double lat = 53.336678;
                    String location = "geo:" + lat + "," + lon + "?z=18";
                    final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(location));
                    startActivity(intent);
                }
            });
        }
        else if(place.equals("Eddie Rockets"))
        {
            image.setImageResource(R.drawable.eddierockets);
            text = PLACE_DETAILS[5];
            moreInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.eddierockets.ie/"));
                    startActivity(intent);
                }
            });
            directions.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    double lon = -6.2654893;
                    double lat = 53.3365897;
                    String location = "geo:" + lat + "," + lon + "?z=18";
                    final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(location));
                    startActivity(intent);
                }
            });
        }
        else if(place.equals("Boojum"))
        {
            image.setImageResource(R.drawable.boojum);
            text = PLACE_DETAILS[6];
            moreInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.boojummex.com/"));
                    startActivity(intent);
                }
            });
            directions.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    double lon = -6.2668945;
                    double lat = 53.3376175;
                    String location = "geo:" + lat + "," + lon + "?z=18";
                    final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(location));
                    startActivity(intent);
                }
            });
        }
        else if(place.equals("Burritos and Blues"))
        {
            image.setImageResource(R.drawable.burritosandblues);
            text = PLACE_DETAILS[7];
            moreInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.burritos.ie/"));
                    startActivity(intent);
                }
            });
            directions.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    double lon = -6.2657265;
                    double lat = 53.3374192;
                    String location = "geo:" + lat + "," + lon + "?z=18";
                    final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(location));
                    startActivity(intent);
                }
            });
        }
        else if(place.equals("Whelans"))
        {
            image.setImageResource(R.drawable.whelans);
            text = PLACE_DETAILS[8];
            moreInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.whelanslive.com/"));
                    startActivity(intent);
                }
            });
            directions.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    double lon = -6.2654893;
                    double lat = 53.3365897;
                    String location = "geo:" + lat + "," + lon + "?z=18";
                    final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(location));
                    startActivity(intent);
                }
            });
        }
        else if(place.equals("Bunsen"))
        {
            image.setImageResource(R.drawable.bunsen);
            text = PLACE_DETAILS[9];
            moreInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.bunsen.ie/"));
                    startActivity(intent);
                }
            });
            directions.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    double lon = -6.2657809;
                    double lat = 53.3372493;
                    String location = "geo:" + lat + "," + lon + "?z=18";
                    final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(location));
                    startActivity(intent);
                }
            });
        }
        else if(place.equals("The Jar"))
        {
            image.setImageResource(R.drawable.thejar);
            text = PLACE_DETAILS[10];
            moreInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://thejar.ie/"));
                    startActivity(intent);
                }
            });
            directions.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    double lon = -6.265717;
                    double lat = 53.3369592;
                    String location = "geo:" + lat + "," + lon + "?z=18";
                    final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(location));
                    startActivity(intent);
                }
            });
        }
        else if(place.equals("Subway"))
        {
            image.setImageResource(R.drawable.subway);
            text = PLACE_DETAILS[11];
            moreInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.subway.com/en-IE"));
                    startActivity(intent);
                }
            });
            directions.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    double lon = -6.2656402;
                    double lat = 53.3371618;
                    String location = "geo:" + lat + "," + lon + "?z=18";
                    final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(location));
                    startActivity(intent);
                }
            });
        }
        else if(place.equals("Spar"))
        {
            image.setImageResource(R.drawable.spar);
            text = PLACE_DETAILS[12];
            moreInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.spar.ie/"));
                    startActivity(intent);
                }
            });
            directions.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    double lon = -6.2657265;
                    double lat = 53.3374192;
                    String location = "geo:" + lat + "," + lon + "?z=18";
                    final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(location));
                    startActivity(intent);
                }
            });
        }

        TextView tv = (TextView) findViewById(R.id.place_info);
        tv.setText(text);
    }
}
