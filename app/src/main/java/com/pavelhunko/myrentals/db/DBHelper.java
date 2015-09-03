package com.pavelhunko.myrentals.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Date;

/**
 * Created by pavelhunko@gmail.com on 03/Sep/2015.
 */
public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "rentals_db";
    private static final String TABLE_RENTALS = "rentals";
    private static final int DATABASE_VERSION = 1;

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

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
