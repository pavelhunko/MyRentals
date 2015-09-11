package com.pavelhunko.myrentals.ui;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pavelhunko.myrentals.R;

import java.util.Date;


public class RentalEditFragment extends Fragment {

    private Bundle mBundle;
    private TextView mViewCity, mViewStreet, mViewState, mViewMonthlyRent, mViewLandlordName;
    private boolean mIndividualLandlord;
    private Date mCheckinDate, mCheckoutDate;

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
    }

    //after posting result to db and fragment call notifyDataSetChanged() on Adapter
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.fragment_rental_edit, container, false);

        findViewComponents(fragmentView);
        unpackBundle(getArguments());

        return fragmentView;
    }

    private void findViewComponents(View view){
        mViewCity = ((TextView) view.findViewById(R.id.fragment_rental_edit_city));
        mViewStreet = ((TextView) view.findViewById(R.id.fragment_rental_edit_street));
        mViewState = ((TextView) view.findViewById(R.id.fragment_rental_edit_state));
        mViewMonthlyRent = ((TextView) view.findViewById(R.id.fragment_rental_edit_mrent));
        mViewLandlordName = ((TextView) view.findViewById(R.id.fragment_rental_edit_landlord));
    }


    private void unpackBundle(Bundle bundle){
        mViewCity.setText(bundle.getString("city"));
        mViewStreet.setText(bundle.getString("street"));
        mViewState.setText(bundle.getString("state"));
        mViewMonthlyRent.setText(bundle.getString("rent"));
        mViewLandlordName.setText(bundle.getString("landlord"));
    }





}
