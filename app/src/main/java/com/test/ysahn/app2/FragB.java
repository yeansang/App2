package com.test.ysahn.app2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FragB extends Fragment {
    private static final String ARG_SECTION_NUMBER = "test";

    public FragB() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static FragB newInstance(int sectionNumber) {
        FragB fragment = new FragB();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_b, container, false);
        return rootView;
    }
}