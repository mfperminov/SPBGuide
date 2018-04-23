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
        pubs.add(new Place(getString(R.string.pub1),
                getString(R.string.pub1_desc),
                R.drawable.wong, getString(R.string.pub1_workhours)));
        pubs.add(new Place(getString(R.string.pub2),
                getString(R.string.pub2_desc),
                R.drawable.lab31, getString(R.string.pub2_workhours)));
        pubs.add(new Place(getString(R.string.pub3),
                getString(R.string.pub3_desc),
                R.drawable.pivrama, getString(R.string.pub3_workhours)));
        pubs.add(new Place(getString(R.string.pub4),
                getString(R.string.pub4_desc),
                R.drawable.saigon, getString(R.string.pub4_workhours)));
        pubs.add(new Place(getString(R.string.pub5),
                getString(R.string.pub5_desc),
                R.drawable.elcapitos, getString(R.string.pub5_workhours)));
        PlaceTimeAdapter placeAdapter = new PlaceTimeAdapter(getActivity(), pubs);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(placeAdapter);
        return rootView;
    }
}