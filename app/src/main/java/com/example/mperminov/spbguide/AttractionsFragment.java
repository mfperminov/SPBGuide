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
        attractions.add(new Place(getString(R.string.attraction1),
                getString(R.string.attraction1_desc),
                R.drawable.alexander_column));
        attractions.add(new Place(getString(R.string.attraction2),
                getString(R.string.attraction2_desc),
                R.drawable.peter_paul_fortress));
        attractions.add(new Place(getString(R.string.attraction3),
                getString(R.string.attraction3_desc),
                R.drawable.nevsky));
        attractions.add(new Place(getString(R.string.attraction4),
                getString(R.string.attraction4_desc),
                R.drawable.peterhof));
        attractions.add(new Place(getString(R.string.attraction5),
                getString(R.string.attraction5_desc),
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
