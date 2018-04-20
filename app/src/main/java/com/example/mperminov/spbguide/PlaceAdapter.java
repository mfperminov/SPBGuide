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
 * Custom adapter for Place object
 */

public class PlaceAdapter extends ArrayAdapter<Place> {
    public PlaceAdapter(Activity context, ArrayList<Place> wordList) {
        super(context, 0, wordList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Place currentPlace = getItem(position);
        TextView nameTv = listItemView.findViewById(R.id.name);
        nameTv.setText(currentPlace.getmName());
        TextView shortDescriptionTv = listItemView.findViewById(R.id.short_description);
        shortDescriptionTv.setText(currentPlace.getmShortDecription());
        ImageView photoIv = listItemView.findViewById(R.id.image);
        photoIv.setImageResource(currentPlace.getmImageId());
        return listItemView;
    }
}
