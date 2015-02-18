package com.almasapp.hw5.almasapp5;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

public class ViewPagerActivity extends ActionBarActivity {

    ViewPager mViewPager;
    MovieData movieData;
    MyFragmentPagerAdapter myFragmentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        movieData = new MovieData();

        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), movieData.getMoviesList());

        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mViewPager.setAdapter(myFragmentPagerAdapter);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
