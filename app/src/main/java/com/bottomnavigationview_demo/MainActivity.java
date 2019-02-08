package com.bottomnavigationview_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void defaultBottomNavigationView(View view) {
        startNavigationActivity(BottomNavigationType.DEFAULT);
    }


    public void customBottomNavigationView(View view) {
        startNavigationActivity(BottomNavigationType.CUSTOM);
    }

    public void moreMenuItemsBottomNavigationView(View view) {
        startNavigationActivity(BottomNavigationType.MORE_MENU);
    }

    //Start Navigation Activity and Pass the Navigation Type
    private void startNavigationActivity(BottomNavigationType bottomNavigationType) {
        Bundle b = new Bundle();
        b.putSerializable(BottomNavigationViewActivity.NAVIGATION_TYPE, bottomNavigationType);
        startActivity(new Intent(this, BottomNavigationViewActivity.class)
                .putExtras(b));
    }
}
