package com.pager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by arudanovskiy on 11/10/17.
 * Placeholder for images for Onboarding
 */

public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    public static PlaceholderFragment newInstance(int sectionNumber) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ImageView imageView = rootView.findViewById(R.id.section_label);
        imageView.setImageResource(prepareImgResource(getArguments().getInt(ARG_SECTION_NUMBER)));
        return rootView;
    }

    private int prepareImgResource(int position) {
        switch (position) {
            case 0:
                return R.drawable.ic_onboarding_greetings;
            case 1:
                return R.drawable.ic_onboarding_tutorial;
            case 2:
                return R.drawable.ic_onboarding_ending;
            default:
                return R.drawable.ic_launcher_foreground;
        }
    }
}