package com.almasapp.hw5.almasapp5;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by José Ernesto on 18/02/2015.
 */
public class FrontPageFragment extends Fragment {

    private OnButtonClickedListener mListener;

    public interface OnButtonClickedListener {
        public void onButtonClicked(int id);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnButtonClickedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_front_page, container, false);

        Button aboutMe = (Button) rootView.findViewById(R.id.buttonFrontAboutMe);
        aboutMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onButtonClicked(R.id.buttonFrontAboutMe);
            }
        });

        Button viewPager = (Button) rootView.findViewById(R.id.buttonFrontViewPager);
        viewPager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onButtonClicked(R.id.buttonFrontViewPager);
            }
        });

        Button masterDetailFlow = (Button) rootView.findViewById(R.id.buttonFrontMasterDetail);
        masterDetailFlow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onButtonClicked(R.id.buttonFrontMasterDetail);
            }
        });

        return rootView;
    }

}
