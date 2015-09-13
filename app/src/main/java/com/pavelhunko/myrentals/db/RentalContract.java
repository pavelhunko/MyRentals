package com.pavelhunko.myrentals.db;


import android.provider.BaseColumns;

public final class RentalContract  {
    public RentalContract(){}

    public static abstract class RentalEntry implements BaseColumns {
        public static final String TABLE_RENTALS = "rentals";
        public static final String RENTAL_STREET = "street";
        public static final String RENTAL_CITY = "city";
        public static final String RENTAL_STATE = "state";
        public static final String RENTAL_MOVE_IN = "movein";
        public static final String RENTAL_MOVE_OUT = "moveout";
    }
}
