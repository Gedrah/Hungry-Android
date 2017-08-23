package com.aziaka.donavan.hungry_android;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFragment.OnDataPass, RestaurantFragment.OnDataPass {

    private FragmentTransaction mFragmentTransaction;
    private FragmentManager mFragmentManager;
    private ArrayList<Restaurants> RestoList = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        createList();


        // Load the first fragment Restaurant
        if (savedInstanceState == null)
            changeFragment("Restaurant");

    }



    // TODO remove this method with the list
    private void createList() {
        RestoList = new ArrayList<Restaurants>();
        Restaurants resto = new Restaurants("Afghanistan", "Albania");
        RestoList.add(resto);

        for (int i = 0; i < 15; i++)
        {
            Restaurants restos = new Restaurants("Resto " + Integer.toString(i), "Address " + Integer.toString(i));
            RestoList.add(restos);
        }

    }



    /*
    **
    ** add the main menu with settings, lists and about
    *
    **/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            changeFragment("Settings");
            return true;
        }
        if (id == R.id.action_list) {
            changeFragment("List");
            return true;
        }
        if (id == R.id.action_about) {
            changeFragment("About");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /*
    * Method where i switch between fragment
    *
    */
    public void changeFragment (String fragmentName) {

        if (findViewById(R.id.fragment_container) != null) {

            if (fragmentName == "About")
            {
                mFragmentManager = getSupportFragmentManager();
                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.fragment_container, new AboutFragment(), "About");
                mFragmentTransaction.commit();
            }
            else if (fragmentName == "Settings")
            {
                // Need datas before so it will be up when the first release will come out.

                Snackbar.make(findViewById(android.R.id.content), "Settings will be available in the next Release.", Snackbar.LENGTH_LONG).show();
            }
            else if (fragmentName == "List")
            {
                mFragmentManager = getSupportFragmentManager();
                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.fragment_container,  new ListFragment(), "List");
                mFragmentTransaction.commit();
            }
            else {
                mFragmentManager = getSupportFragmentManager();
                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.fragment_container, new RestaurantFragment(), "Restaurant");
                mFragmentTransaction.commit();
            }
        }

    }


    @Override
    public void onBackPressed() {

       Fragment currentFragment = mFragmentManager.findFragmentById(R.id.fragment_container);

       if (currentFragment instanceof RestaurantFragment) {
           super.onBackPressed();
       }
       else {
           changeFragment("Restaurant");
       }
    }


    public void setRestoList (ArrayList<Restaurants> newRestos) {
        this.RestoList = newRestos;
    }

    public ArrayList<Restaurants> getRestoList () {
        return this.RestoList;
    }

    @Override
    public void onDataPass(ArrayList<Restaurants> data) {
        this.RestoList = data;
    }

}
