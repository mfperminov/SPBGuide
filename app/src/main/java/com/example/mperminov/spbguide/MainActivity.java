package com.example.mperminov.spbguide;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        final NavigationView navigationView = findViewById(R.id.nav_view);
        final ImageView logo = findViewById(R.id.splash);
        logo.setImageResource(R.drawable.spb_logo_text);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();
                        // find ImageView in the header
                        View hView = navigationView.getHeaderView(0);
                        ImageView navigationHeaderImage = hView.findViewById(R.id.nav_header_image);
                        int menuItemId = menuItem.getItemId();
                        int imageHeaderId = R.drawable.spb_attr;
                        //change fragment in FrameLayout based on chosen item menu
                        //and update image in the header
                        android.support.v4.app.Fragment fragment = null;
                        switch (menuItemId) {
                            case R.id.nav_attr:
                                imageHeaderId = R.drawable.spb_attr;
                                fragment = new AttractionsFragment();
                                break;
                            case R.id.nav_museums:
                                imageHeaderId = R.drawable.spb_museum;
                                fragment = new MuseumsFragment();
                                break;
                            case R.id.nav_concerts:
                                imageHeaderId = R.drawable.spb_conc;
                                fragment = new ConcertsFragment();
                                break;
                            case R.id.nav_pubs:
                                imageHeaderId = R.drawable.spb_pubs;
                                fragment = new PubsFragment();
                                break;
                        }
                        //transaction for fragments rotating
                        if (fragment != null) {
                            logo.setVisibility(View.INVISIBLE);
                            android.support.v4.app.FragmentTransaction transaction =
                                    getSupportFragmentManager().beginTransaction();
                            transaction.addToBackStack(null);
                            transaction.replace(R.id.content_frame, fragment);
                            transaction.commit();
                        }
                        //set the category image to header
                        navigationHeaderImage.setImageResource(imageHeaderId);
                        return true;
                    }
                });
        //activating custom toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        // "sandwich" icon on toolbar
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //open the drawer when the user taps on the nav drawer button
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}