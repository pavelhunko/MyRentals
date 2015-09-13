package com.pavelhunko.myrentals.ui;

import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.pavelhunko.myrentals.DAO.RentalDAOImpl;
import com.pavelhunko.myrentals.R;
import com.pavelhunko.myrentals.adapter.RentalsListAdapter;
import com.pavelhunko.myrentals.model.Rental;

import java.text.ParseException;
import java.util.Date;

public class RentalsOverviewFragment extends ListFragment {

    RentalsListAdapter mAdapter;
    private String mCity, mStreet, mState, mMonthlyRent, mLandlordName;
    private boolean mIndividualLandlord;
    private Date mCheckinDate, mCheckoutDate;

    public RentalsOverviewFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_rentals_overview, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mAdapter = new RentalsListAdapter(getActivity().getApplicationContext());
        setListAdapter(mAdapter);
        if (mAdapter.getCount() == 0)
            loadItems();
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    private void loadItems() {
        RentalDAOImpl rentalDAO = new RentalDAOImpl();
        for (Rental r : rentalDAO.getAllRentals())
            mAdapter.add(r);
    }

    private Bundle packBundleFromView(){
        final Bundle bundle = new Bundle();
        bundle.putString("city", mCity);
        bundle.putString("street", mStreet);
        bundle.putString("state", mState);
        bundle.putString("rent", mMonthlyRent);
        bundle.putString("landlord", mLandlordName);
        return bundle;
    }

    private void getViewDetailedContent(View view){
        mCity = ((TextView) view.findViewById(R.id.ri_city)).getText().toString();
        mStreet = ((TextView) view.findViewById(R.id.ri_street)).getText().toString();
        mState = ((TextView) view.findViewById(R.id.ri_state)).getText().toString();
        mMonthlyRent = ((TextView) view.findViewById(R.id.ri_monthly_rent)).getText().toString();
        mLandlordName = ((TextView) view.findViewById(R.id.ri_landlord)).getText().toString();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        RentalEditFragment rentalEditFragment = new RentalEditFragment();

        getViewDetailedContent(v);

        rentalEditFragment.setArguments(packBundleFromView());

        this.getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, rentalEditFragment)
                .addToBackStack(null).commit();


    }
}
