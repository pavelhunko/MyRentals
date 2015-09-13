package com.pavelhunko.myrentals.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.pavelhunko.myrentals.db.RentalContract.RentalEntry;

/**
 * Created by pavelhunko@gmail.com on 03/Sep/2015.
 */
public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "rentals_db";
    private static final int DATABASE_VERSION = 1;
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + RentalEntry.TABLE_RENTALS + " (" +
            RentalEntry._ID + " INTEGER PRIMARY KEY, " +
            RentalEntry.RENTAL_STREET + TEXT_TYPE + COMMA_SEP +
            RentalEntry.RENTAL_CITY + TEXT_TYPE + COMMA_SEP +
            RentalEntry.RENTAL_STATE + TEXT_TYPE + COMMA_SEP +
            RentalEntry.RENTAL_MOVE_IN + TEXT_TYPE + COMMA_SEP +
            RentalEntry.RENTAL_MOVE_OUT + TEXT_TYPE + COMMA_SEP +
            " );";
    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + RentalEntry.TABLE_RENTALS;


    private static DBHelper sInstance;

    private DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    public static synchronized DBHelper getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new DBHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }



}
