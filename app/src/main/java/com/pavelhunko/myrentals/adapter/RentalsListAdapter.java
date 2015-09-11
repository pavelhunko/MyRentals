package com.pavelhunko.myrentals.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pavelhunko.myrentals.R;
import com.pavelhunko.myrentals.model.Rental;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pavelhunko@gmail.com on 03/Sep/2015.
 */
public class RentalsListAdapter extends BaseAdapter {

    private final List<Rental> mRentals = new ArrayList<>();
    private final Context mContext;

    public RentalsListAdapter(Context context) {
        mContext = context;
    }

    public void add(Rental rental){
        mRentals.add(rental);
        notifyDataSetChanged();
    }

    public void clear(){
        mRentals.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mRentals.size();
    }

    @Override
    public Object getItem(int position) {
        return mRentals.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Rental rental = (Rental) getItem(position);

        RelativeLayout itemLayout = (RelativeLayout) convertView;
        if (itemLayout == null) {
            LayoutInflater mLInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemLayout = (RelativeLayout) mLInflater.inflate(R.layout.fragment_rental_item, null);
        }

        final TextView riStreet = (TextView) itemLayout.findViewById(R.id.ri_street);
        final TextView riCity = (TextView) itemLayout.findViewById(R.id.ri_city);
        final TextView riState = (TextView) itemLayout.findViewById(R.id.ri_state);
        //final TextView riLandlordName = (TextView) itemLayout.findViewById(R.id.ri_landlord);
        final TextView riTimeframe = (TextView) itemLayout.findViewById(R.id.ri_timeframe);
        final TextView riTotal = (TextView) itemLayout.findViewById(R.id.ri_monthly_rent);

        //timeframe

        //total paid

        riStreet.setText(rental.getStreet());
        riCity.setText(rental.getCity());
        riState.setText(rental.getState());
//        riLandlordName.setText(rental.);
//        calculate time frame
        riTimeframe.setText(rental.getMoveInDate().toString());
        riTotal.setText(rental.getMonthlyRent().toString());
        return itemLayout;
    }


}
