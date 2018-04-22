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
public class AttractionsFragment extends android.support.v4.app.Fragment {


    public AttractionsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);
        ArrayList<Place> attractions = new ArrayList<>();
        attractions.add(new Place("Alexander Column",
                "The focal point of Palace Square",
                R.drawable.alexander_column));
        attractions.add(new Place("Peter and Paul Fortress",
                "Original city site founded in 1703",
                R.drawable.peter_paul_fortress));
        attractions.add(new Place("Nevsky Prospect",
                "The main city street",
                R.drawable.nevsky));
        attractions.add(new Place("Peterhof Palace",
                "Seafront royal palace, park & museums",
                R.drawable.peterhof));
        attractions.add(new Place("Saint Isaac's Cathedral",
                "The largest orthodox basilica in the world.",
                R.drawable.isaac));
        PlaceAdapter placeAdapter = new PlaceAdapter(getActivity(), attractions);
        ListView listView = rootView.findViewById(R.id.list);
        //on click - open google maps with query of attractions name
        PlaceClickListener clickListener = new PlaceClickListener(getContext());
        listView.setOnItemClickListener(clickListener);
        listView.setAdapter(placeAdapter);
        return rootView;
    }
}
