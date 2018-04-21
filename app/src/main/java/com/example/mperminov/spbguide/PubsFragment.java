package com.example.mperminov.spbguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class PubsFragment extends Fragment {
    public PubsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);
        ArrayList<Place> pubs = new ArrayList<>();
        pubs.add(new Place("Wong Kar Wine",
                "Wine bar and panasian cafe",
                R.drawable.wong));
        pubs.add(new Place("Laboratoriya 31",
                "Unusual bar",
                R.drawable.lab31));
        pubs.add(new Place("Pivorama",
                "Great consistent service",
                R.drawable.pivrama));
        pubs.add(new Place("Saigon",
                "Great people here",
                R.drawable.saigon));
        pubs.add(new Place("El Copitas",
                "Great Place!",
                R.drawable.elcapitos));
        PlaceAdapter placeAdapter = new PlaceAdapter(getActivity(), pubs);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(placeAdapter);
        return rootView;
    }
}