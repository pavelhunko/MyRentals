package com.pavelhunko.myrentals.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.pavelhunko.myrentals.db.RentalContract.RentalEntry;
import com.pavelhunko.myrentals.model.Rental;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by pavelhunko@gmail.com on 03/Sep/2015.
 */
public class RentalDAOImpl implements RentalDAO {

    public static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    List<Rental> rentals;
    private SQLiteDatabase sqLiteDatabase;
    private String[] allColumns = {RentalEntry.RENTAL_STREET, RentalEntry.RENTAL_CITY, RentalEntry.RENTAL_STATE, RentalEntry.RENTAL_MOVE_IN, RentalEntry.RENTAL_MOVE_OUT};

    private static RentalDAOImpl instance;

    private RentalDAOImpl(Context context,SQLiteDatabase sqLiteDatabase) {
        super();
    }
    public static synchronized RentalDAOImpl getInstance(Context context,SQLiteDatabase sqLiteDatabase){
        if (instance==null){
            instance=new RentalDAOImpl(context,sqLiteDatabase);
        }
        return instance;
    }

    public static synchronized RentalDAOImpl getExistingInstance() {
        return instance;
    }


    public RentalDAOImpl() {
    }


    @Override
    public List<Rental> getAllRentals() {
        return rentals;
    }

    @Override
    public Rental findRentalByID(int ID) {
        return rentals.get(ID);
    }

    public Rental createRental(Rental rental) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(RentalEntry.RENTAL_STREET, rental.getStreet());
        contentValues.put(RentalEntry.RENTAL_CITY, rental.getCity());
        contentValues.put(RentalEntry.RENTAL_STATE, rental.getState());
        contentValues.put(RentalEntry.RENTAL_MOVE_IN, convertDateToString(rental.getMoveInDate()));
        contentValues.put(RentalEntry.RENTAL_MOVE_OUT, convertDateToString(rental.getMoveOutDate()));

        long insertId = sqLiteDatabase.insert(RentalEntry.TABLE_RENTALS, null, contentValues);
        Cursor cursor = sqLiteDatabase.query(RentalEntry.TABLE_RENTALS, allColumns, RentalEntry._ID + "=" + insertId, null, null, null, null);
        cursor.moveToFirst();
        Rental newRental = null;
        try {
            newRental = cursorToRental(cursor);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cursor.close();
        return newRental;
    }

    @Override
    public boolean updateRental(Rental rental) {
        return false;
    }

    @Override
    public boolean deleteRental(Rental rental) {
        return false;
    }

    private String convertDateToString(Date date) {
        String stringDate = FORMAT.format(date);
        return stringDate;
    }

    private Date convertStringToDAte(String stringDate) throws ParseException {
        return FORMAT.parse(stringDate);
    }

    private Rental cursorToRental(Cursor cursor) throws ParseException {
        Rental rental = new Rental();
        rental.setStreet(cursor.getString(0));
        rental.setCity(cursor.getString(1));
        rental.setState(cursor.getString(2));
        rental.setMoveInDate(convertStringToDAte(cursor.getString(3)));
        rental.setMoveOutDate(convertStringToDAte(cursor.getString(4)));

        return rental;
    }


}
