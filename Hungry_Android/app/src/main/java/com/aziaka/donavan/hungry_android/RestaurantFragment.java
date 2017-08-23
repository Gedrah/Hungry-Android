package com.aziaka.donavan.hungry_android;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class RestaurantFragment extends Fragment {

    public RestaurantFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        return inflater.inflate(R.layout.fragment_restaurant, container, false);
    }


    /*
    ** Main method that will choose a restaurant randomly
     */
    private void rollRestaurant() {

    }


    public interface OnDataPass {
        public void onDataPass(ArrayList<Restaurants> data);
    }

}
