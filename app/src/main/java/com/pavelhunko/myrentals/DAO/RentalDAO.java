package com.pavelhunko.myrentals.DAO;

import com.pavelhunko.myrentals.model.Rental;

import java.util.List;

/**
 * Created by pavelhunko@gmail.com on 03/Sep/2015.
 */
public interface RentalDAO {
    List<Rental> getAllRentals();
    Rental findRentalByID(int ID);

    Rental createRental(Rental rental);
    boolean updateRental(Rental rental);
//    OOS
    boolean deleteRental(Rental rental);

}
