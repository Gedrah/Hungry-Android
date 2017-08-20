package com.aziaka.donavan.hungry_android;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements RestaurantFragment.OnFragmentInteractionListener, ListFragment.OnFragmentInteractionListener, SettingsFragment.OnFragmentInteractionListener {

    Bundle instance = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        instance = savedInstanceState;
        changeFragment(savedInstanceState, "Restaurant");
        // fab button
        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            changeFragment(instance, "Settings");
            return true;
        }
        if (id == R.id.action_list) {
            changeFragment(instance, "List");
            return true;
        }
        if (id == R.id.action_about) {
            changeFragment(instance, "Settings");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void changeFragment (Bundle savedInstanceState, String fragmentName) {

        System.out.print("Before !");
        if (findViewById(R.id.fragment_container) != null) {

            System.out.print("After !");

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }


            if (fragmentName == "Restaurant")
            {
                RestaurantFragment firstFragment = new RestaurantFragment();
                firstFragment.setArguments(getIntent().getExtras());
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, firstFragment).commit();
            }
            else if (fragmentName == "Settings")
            {
                SettingsFragment firstFragment = new SettingsFragment();
                firstFragment.setArguments(getIntent().getExtras());
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, firstFragment).commit();
            }
            else if (fragmentName == "List")
            {
                ListFragment firstFragment = new ListFragment();
                firstFragment.setArguments(getIntent().getExtras());
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, firstFragment).commit();
            }

        }

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
