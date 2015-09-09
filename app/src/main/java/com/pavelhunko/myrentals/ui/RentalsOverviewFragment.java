package com.pavelhunko.myrentals.ui;

import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.pavelhunko.myrentals.DAO.RentalDAOImpl;
import com.pavelhunko.myrentals.R;
import com.pavelhunko.myrentals.adapter.RentalsListAdapter;
import com.pavelhunko.myrentals.model.Rental;

import java.text.ParseException;

public class RentalsOverviewFragment extends ListFragment {

    RentalsListAdapter mAdapter;

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
        try {
            RentalDAOImpl rentalDAO = new RentalDAOImpl();
            for (Rental r : rentalDAO.getAllRentals())
                mAdapter.add(r);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        RentalEditFragment rentalEditFragment = new RentalEditFragment();
        this.getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, rentalEditFragment)
                .addToBackStack(null).commit();


    }
}
