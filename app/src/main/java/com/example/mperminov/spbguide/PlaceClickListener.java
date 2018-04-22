package com.example.mperminov.spbguide;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;

public class PlaceClickListener extends AppCompatActivity
        implements AdapterView.OnItemClickListener {
    private Context mContext;

    public PlaceClickListener(Context context) {
        mContext = context;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Place curPlace = (Place) parent.getItemAtPosition(position);
        //intent for open google maps with name of place
        Uri mapUri = Uri.parse("geo:0,0?q=" + Uri.encode(curPlace.getmName()));
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        mContext.startActivity(mapIntent);
    }
}
