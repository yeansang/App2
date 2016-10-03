package com.test.ysahn.app2;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class FragB extends Fragment {

    private ImageView mImageview;
    int count=0;

    public FragB() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static FragB newInstance(int sectionNumber) {
        FragB fragment = new FragB();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_b, container, false);
        mImageview = (ImageView) rootView.findViewById(R.id.imageView);

        mImageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                mImageview.setImageResource(R.drawable.pic1+(count%5));
            }
        });
        return rootView;
    }
}