package com.example.mperminov.spbguide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class ConcertsFragment extends android.support.v4.app.Fragment {
    public ConcertsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);
        ArrayList<Place> concerts = new ArrayList<>();
        concerts.add(new Place("Xiu Xiu",
                "Museum Erarta",
                R.drawable.xiu));
        concerts.add(new Place("Eyehategod",
                "nightclub Mod",
                R.drawable.eyehategod));
        concerts.add(new Place("Einar Stray",
                "Yaani Kirik",
                R.drawable.einar));
        concerts.add(new Place("Thirty Seconds to Mars",
                "SKK Arena",
                R.drawable.stm));
        PlaceAdapter placeAdapter = new PlaceAdapter(getActivity(), concerts);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(placeAdapter);
        return rootView;

    }
}
