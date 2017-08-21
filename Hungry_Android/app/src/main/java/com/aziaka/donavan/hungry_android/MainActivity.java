package com.aziaka.donavan.hungry_android;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements RestaurantFragment.OnFragmentInteractionListener,
        ListFragment.OnFragmentInteractionListener, SettingsFragment.OnFragmentInteractionListener, AboutFragment.OnFragmentInteractionListener {

    private FragmentTransaction mFragmentTransaction;
    private FragmentManager mFragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Load the first fragment Restaurant
        if (savedInstanceState == null)
            changeFragment("Restaurant");

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

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
