package com.pavelhunko.myrentals.DAO;

import com.pavelhunko.myrentals.model.Rental;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by pavelhunko@gmail.com on 03/Sep/2015.
 */
public class RentalDAOImpl implements RentalDAO{

    public static final String TABLE_RENTALS = "rentals";
    public static final String RENTAL_ID = "street";
    public static final String RENTAL_STREET = "street";
    public static final String RENTAL_CITY = "city";
    public static final String RENTAL_STATE = "state";
    public static final String RENTAL_MOVE_IN = "movein";
    public static final String RENTAL_MOVE_OUT = "moveout";

    public static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

    List<Rental> rentals;

    public RentalDAOImpl() throws ParseException {
        rentals = new ArrayList<>();
        Rental rental1 = new Rental(1,"atlantic ave 1", "Wildwood", "NJ", 200, FORMAT.parse("2015-05-13"), FORMAT.parse("2015-06-13"));
        Rental rental2 = new Rental(1,"indian ave 23", "Atlantic City", "NJ", 100, FORMAT.parse("2014-08-13"), FORMAT.parse("2015-04-13"));
        Rental rental3 = new Rental(1,"pacific ave 14", "New Jersey", "NJ", 400, FORMAT.parse("2013-05-13"), FORMAT.parse("2014-07-13"));
        rentals.add(rental1);
        rentals.add(rental2);
        rentals.add(rental3);

    }


    @Override
    public List<Rental> getAllRentals() {
        return rentals;
    }

    @Override
    public Rental findRentalByID(int ID) {
        return rentals.get(ID);
    }

    @Override
    public boolean createRental(Rental rental) {
        return false;
    }

    @Override
    public boolean updateRental(Rental rental) {
        return false;
    }

    @Override
    public boolean deleteRental(Rental rental) {
        return false;
    }


    //    public static void packageRentalIntent(Intent intent, String street, String city, String state, Integer monthlyRent, Date moveInDate, Date moveOutDate) {
//        intent.putExtra(RentalDAO.RENTALS_STREET, street);
//        intent.putExtra(RentalDAO.RENTALS_CITY, city);
//        intent.putExtra(RentalDAO.RENTALS_STATE, state);
//        intent.putExtra(RentalDAO.RENTALS_MOVE_IN, moveInDate);
//        intent.putExtra(RentalDAO.RENTALS_MOVE_OUT, moveOutDate);
//
//    }

}
