package com.example.mperminov.spbguide;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A {@link Fragment} subclass that contains data for attractions list.
 */
public class AttractionsFragment extends Fragment {


    public AttractionsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);
        ArrayList<Place> attractions = new ArrayList<>();
        attractions.add(new Place("Alexander Column",
                "The focal point of Palace Square in Saint Petersburg",
                R.drawable.alexander_column));
        attractions.add(new Place("Peter and Paul Fortress",
                "Original city site founded in 1703",
                R.drawable.peter_paul_fortress));
        attractions.add(new Place("Nevsky Prospect",
                "This famous Russian street that cuts through the center of " +
                        "St. Petersburg is a hub for shopping, nightlife and entertainment.",
                R.drawable.nevsky));
        attractions.add(new Place("Peterhof Palace",
                "These palaces and gardens are sometimes " +
                        "referred as the \"Russian Versailles\".",
                R.drawable.peterhof));
        attractions.add(new Place("Saint Isaac's Cathedral",
                "The largest orthodox basilica and the fourth largest" +
                        " cathedral in the world.",
                R.drawable.isaac));
        PlaceAdapter placeAdapter = new PlaceAdapter(getActivity(), attractions);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(placeAdapter);
        return rootView;
    }
}
