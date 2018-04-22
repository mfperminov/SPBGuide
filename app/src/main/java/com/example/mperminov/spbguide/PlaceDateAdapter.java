package com.example.mperminov.spbguide;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Custom adapter for Place object with date of event.
 */

public class PlaceDateAdapter extends ArrayAdapter<Place> {
    public PlaceDateAdapter(Activity context, ArrayList<Place> wordList) {
        super(context, 0, wordList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_wh, parent, false);
        }
        Place currentPlace = getItem(position);
        TextView nameTv = listItemView.findViewById(R.id.name);
        nameTv.setText(currentPlace.getmName());
        TextView shortDescriptionTv = listItemView.findViewById(R.id.short_description);
        shortDescriptionTv.setText(currentPlace.getmShortDescription());
        ImageView photoIv = listItemView.findViewById(R.id.image);
        photoIv.setImageResource(currentPlace.getmImageId());
        TextView daysUntilTv = listItemView.findViewById(R.id.days_until);
        daysUntilTv.setText(currentPlace.daysUntil());
        return listItemView;
    }
}
