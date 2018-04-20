package com.example.mperminov.spbguide;

import android.app.Fragment;
import android.app.FragmentTransaction;
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
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();
                        // update the image in the header based on selected item in menu
                        View hView = navigationView.getHeaderView(0);
                        ImageView navigationHeaderImage = hView.findViewById(R.id.nav_header_image);
                        int menuItemId = menuItem.getItemId();
                        int imageHeaderId = R.drawable.spb_attr;
                        Fragment fragment = null;
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
                                break;
                        }
                        if (fragment != null) {
                            FragmentTransaction transaction = getFragmentManager().beginTransaction();
                            //transaction.addToBackStack(null);
                            transaction.replace(R.id.content_frame, fragment);
                            transaction.commit();
                        }
                        navigationHeaderImage.setImageResource(imageHeaderId);
                        return true;
                    }
                });
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}