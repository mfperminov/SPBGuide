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
        museums.add(new Place(getString(R.string.museum1),
                getString(R.string.museum1_place),
                R.drawable.hermitage));
        museums.add(new Place(getString(R.string.museum2),
                getString(R.string.museum2_place),
                R.drawable.russian_museum));
        museums.add(new Place(getString(R.string.museum3),
                getString(R.string.museum3_place),
                R.drawable.aurora));
        museums.add(new Place(getString(R.string.museum4),
                getString(R.string.museum4_place),
                R.drawable.kunstkamera));
        museums.add(new Place(getString(R.string.museum5),
                getString(R.string.museum5_place),
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
