package com.almasapp.hw5.almasapp5;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

public class FrontPageActivity extends ActionBarActivity implements FrontPageFragment.OnButtonClickedListener {
    final String TAG = "FrontPageActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new FrontPageFragment())
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, new FrontPageFragment())
                        .commit();

                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onButtonClicked(int id) {
        Log.d(TAG, "onButtonClicked");

        switch (id) {
            case R.id.buttonFrontAboutMe:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new AboutMeFragment())
                        .addToBackStack(null)
                        .commit();
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                break;
            case R.id.buttonFrontViewPager:
                startActivity(new Intent(this, ViewPagerActivity.class));

                break;
            case  R.id.buttonFrontMasterDetail:
                startActivity(new Intent(this, MasterDetailActivity.class));
                break;
        }
    }
}
