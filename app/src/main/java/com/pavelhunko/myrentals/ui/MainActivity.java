package com.pavelhunko.myrentals.ui;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.pavelhunko.myrentals.R;

public class MainActivity extends AppCompatActivity {

    private static FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        RentalsOverviewFragment roFragment = new RentalsOverviewFragment();
        fragmentTransaction.add(R.id.fragment_container, roFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        mFragmentManager.popBackStack();
    }
}
