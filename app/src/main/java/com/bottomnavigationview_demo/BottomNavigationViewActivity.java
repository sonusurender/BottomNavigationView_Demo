package com.bottomnavigationview_demo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by sonu on 14/01/17.
 */

public class BottomNavigationViewActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    public static final String NAVIGATION_TYPE = "navigation_type";
    private BottomNavigationView defaultBottomNavigationView, customBottomNavigationView, moreMenuNavigationView;
    private BottomNavigationType bottomNavigationType;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_navigation_view_activity);

        //Get the Type of Navigation Via Intent
        bottomNavigationType = (BottomNavigationType) getIntent().getSerializableExtra(NAVIGATION_TYPE);

        //Find IDs for all Navigation Views
        defaultBottomNavigationView = (BottomNavigationView) findViewById(R.id.default_bottom_navigation);
        customBottomNavigationView = (BottomNavigationView) findViewById(R.id.custom_bottom_navigation);
        moreMenuNavigationView = (BottomNavigationView) findViewById(R.id.more_menu_bottom_navigation);

        setNavigation();
        setListeners();

    }

    //Create a method to implement listeners over all Navigation Views
    private void setListeners() {
        defaultBottomNavigationView.setOnNavigationItemSelectedListener(this);
        customBottomNavigationView.setOnNavigationItemSelectedListener(this);
        moreMenuNavigationView.setOnNavigationItemSelectedListener(this);
    }


    //Show hide navigation views on basis of Navigation Type
    private void setNavigation() {
        switch (bottomNavigationType) {
            case DEFAULT:
                defaultBottomNavigationView.setVisibility(View.VISIBLE);
                customBottomNavigationView.setVisibility(View.GONE);
                moreMenuNavigationView.setVisibility(View.GONE);

                //By Default Set Home Fragment
                replaceDummyFragment(defaultBottomNavigationView.getMenu().findItem(R.id.action_home));
                break;
            case CUSTOM:
                defaultBottomNavigationView.setVisibility(View.GONE);
                customBottomNavigationView.setVisibility(View.VISIBLE);
                moreMenuNavigationView.setVisibility(View.GONE);

                //By Default Set Home Fragment
                replaceDummyFragment(customBottomNavigationView.getMenu().findItem(R.id.action_home));
                break;
            case MORE_MENU:
                defaultBottomNavigationView.setVisibility(View.GONE);
                customBottomNavigationView.setVisibility(View.GONE);
                moreMenuNavigationView.setVisibility(View.VISIBLE);

                //By Default Set Home Fragment
                replaceDummyFragment(moreMenuNavigationView.getMenu().findItem(R.id.action_home));
                break;
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        //If item is Checked make it unchecked
        if (item.isChecked())
            item.setChecked(false);
        switch (item.getItemId()) {
            case R.id.action_home:
                //Check the Item
                item.setChecked(true);
                replaceDummyFragment(item);
                break;
            case R.id.action_message:
                //Check the Item
                item.setChecked(true);
                replaceDummyFragment(item);
                break;
            case R.id.action_notification:
                //Check the Item
                item.setChecked(true);
                replaceDummyFragment(item);
                break;
            case R.id.action_profile:
                //Check the Item
                item.setChecked(true);
                replaceDummyFragment(item);
                break;

        }
        return true;
    }

    //Replace Dummy Fragment and Pass the Fragment title via Fragment
    private void replaceDummyFragment(@NonNull MenuItem item) {
        Bundle b = new Bundle();
        b.putString(DummyFragment.FRAGMENT_TITLE, item.getTitle().toString());
        Fragment dummyFragment = new DummyFragment();
        dummyFragment.setArguments(b);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, dummyFragment).commit();
    }
}
