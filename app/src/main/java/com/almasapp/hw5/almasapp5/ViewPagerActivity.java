package com.almasapp.hw5.almasapp5;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

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

        mViewPager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {
                final float norm = Math.abs(Math.abs(position) - 1);
                page.setAlpha(norm);

                page.setScaleX(norm/2 + 0.5f);
                page.setScaleY(norm/2 + 0.5f);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
