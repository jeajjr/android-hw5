package com.almasapp.hw5.almasapp5;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Created by José Ernesto on 18/02/2015.
 */
public class MyFragmentPagerAdapter extends FragmentStatePagerAdapter {
        int count;
    private List<Map<String, ?>> movieData;

    public MyFragmentPagerAdapter (FragmentManager fm, List<Map<String, ?>> movieData) {
        super(fm);
        this.movieData = movieData;
        count = movieData.size();
    }

    @Override
    public Fragment getItem(int position) {
        return MovieDetailFragment.newInstance((HashMap<String, ?>) movieData.get(position));
    }

    @Override
    public int getCount() {
        return count;
    }

    /**
     * Just for future customization.
     */
    @Override
    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        HashMap<String, ?> movie = (HashMap<String, ?>) movieData.get(position);
        String name = (String) movie.get("name");
        return name.toUpperCase();
    }
}
