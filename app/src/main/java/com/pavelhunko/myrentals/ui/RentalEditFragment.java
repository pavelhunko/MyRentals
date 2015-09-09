package com.pavelhunko.myrentals.ui;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pavelhunko.myrentals.R;


public class RentalEditFragment extends Fragment {

    private Bundle mBundle;
    public static RentalEditFragment newInstance() {
        RentalEditFragment fragment = new RentalEditFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public RentalEditFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBundle = getArguments();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.fragment_rental_edit, container, false);
        TextView city = (TextView) fragmentView.findViewById(R.id.fragment_rental_edit_city);
        String s = mBundle.getString("city");
        city.setText(s);
        return fragmentView;
    }





}
