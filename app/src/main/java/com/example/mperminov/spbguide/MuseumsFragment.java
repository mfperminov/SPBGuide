package com.example.mperminov.spbguide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class MuseumsFragment extends android.support.v4.app.Fragment {
    public MuseumsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);
        ArrayList<Place> museums = new ArrayList<>();
        museums.add(new Place("Hermitage Museum",
                "Art & culture museum founded in 1764",
                R.drawable.hermitage));
        museums.add(new Place("Russian Museum",
                "Fine artworks, icons & sculptures",
                R.drawable.russian_museum));
        museums.add(new Place("Russian cruiser Aurora",
                "Floating museum on 20th-century warship",
                R.drawable.aurora));
        museums.add(new Place("Kunstkamera",
                "Anthropological & ethnographic museum",
                R.drawable.kunstkamera));
        museums.add(new Place("Pavlovsk Palace",
                "Palace, museum, and nature reserve.",
                R.drawable.pavlovsk));
        PlaceAdapter placeAdapter = new PlaceAdapter(getActivity(), museums);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(placeAdapter);
        //on click - open google maps with query of museum name
        PlaceClickListener clickListener = new PlaceClickListener(getContext());
        listView.setOnItemClickListener(clickListener);
        listView.setAdapter(placeAdapter);
        return rootView;
    }
}
