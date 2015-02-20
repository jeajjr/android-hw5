package com.almasapp.hw5.almasapp5;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MasterDetailActivity extends ActionBarActivity implements RecyclerViewFragment.OnItemClickedListener {
    final String TAG = "MasterDetailActivity";

    private boolean mTwoPane;
    private MovieData movieData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        movieData = new MovieData();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.item_list, new RecyclerViewFragment())
                    .commit();
        }

        if (findViewById(R.id.item_detail_container) != null) {
            mTwoPane = true;
        }
        else
            mTwoPane = false;

        Log.d(TAG, "mTwoPane: " + mTwoPane);
    }

    @Override
    public void onItemClick(int position) {
        if (mTwoPane) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.item_detail_container, MovieDetailFragment.newInstance(movieData.getItem(position)))
                    .commit();
        }
        else {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.item_list, MovieDetailFragment.newInstance(movieData.getItem(position)))
                    .addToBackStack(null)
                    .commit();
        }
    }
}
