package com.almasapp.hw5.almasapp5;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieDetailFragment extends Fragment {
    static String ARG_SECTION_NUMBER = "args";

    public MovieDetailFragment() {
        // Required empty public constructor
    }

    public static MovieDetailFragment newInstance(HashMap<String, ?> movie) {
        MovieDetailFragment fragment = new MovieDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_SECTION_NUMBER, movie);
        fragment.setArguments(args);

        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_movie_detail, container, false);
        
        HashMap<String, ?> movie = (HashMap<String, ?>) getArguments().get(ARG_SECTION_NUMBER);

        TextView title = (TextView) rootView.findViewById(R.id.textViewMovieDetailTitle);
        TextView year = (TextView) rootView.findViewById(R.id.textViewMovieDetailYear);
        TextView length = (TextView) rootView.findViewById(R.id.textViewMovieDetailLength);
        TextView stars = (TextView) rootView.findViewById(R.id.textViewMovieDetailStars);
        TextView director = (TextView) rootView.findViewById(R.id.textViewMovieDetailDirector);
        ImageView cover = (ImageView) rootView.findViewById(R.id.imageViewMovieDetailCover);
        RatingBar rating = (RatingBar) rootView.findViewById(R.id.ratingBarMovieDetailRating);
        TextView description = (TextView) rootView.findViewById(R.id.textViewMovieDetailDescription);

        title.setText(movie.get("name").toString());
        year.setText(movie.get("year").toString());
        length.setText(movie.get("length").toString());
        stars.setText(getResources().getText(R.string.movies_stars) + " " + movie.get("stars").toString());
        director.setText(getResources().getText(R.string.movies_director) + " " + movie.get("director").toString());
        cover.setImageResource((Integer) movie.get("image"));
        rating.setRating( (int) Double.parseDouble(movie.get("rating").toString()) + 1 );
        description.setText(movie.get("description").toString());

        return rootView;
    }


}
