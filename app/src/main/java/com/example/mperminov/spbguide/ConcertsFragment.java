package com.example.mperminov.spbguide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.time.LocalDate;
import java.time.Month;
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
                R.drawable.xiu, LocalDate.of(2018, Month.APRIL, 21)));
        concerts.add(new Place("Eyehategod",
                "nightclub Mod",
                R.drawable.eyehategod, LocalDate.of(2018, Month.APRIL, 22)));
        concerts.add(new Place("Einar Stray",
                "Yaani Kirik",
                R.drawable.einar, LocalDate.of(2018, Month.APRIL, 25)));
        concerts.add(new Place("Thirty Seconds to Mars",
                "SKK Arena",
                R.drawable.stm, LocalDate.of(2018, Month.APRIL, 27)));
        PlaceDateAdapter placeAdapter = new PlaceDateAdapter(getActivity(), concerts);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(placeAdapter);
        return rootView;

    }
}
