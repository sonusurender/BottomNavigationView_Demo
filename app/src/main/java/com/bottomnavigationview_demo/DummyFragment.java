package com.bottomnavigationview_demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by sonu on 14/01/17.
 */

public class DummyFragment extends Fragment {

    public static final String FRAGMENT_TITLE = "fragment_title";
    private String fragmentTitle;

    public DummyFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Get the fragment title via Argument
        fragmentTitle = getArguments().getString(FRAGMENT_TITLE);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dummy_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        AppCompatTextView textView = (AppCompatTextView) view.findViewById(R.id.dummy_fragment_title);
        textView.setText(fragmentTitle);//Set the fetched argument via Argument
    }
}
