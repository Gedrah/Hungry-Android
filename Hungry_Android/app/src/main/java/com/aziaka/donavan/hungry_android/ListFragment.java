package com.aziaka.donavan.hungry_android;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class ListFragment extends Fragment {


    private ArrayList<Restaurants> RestoList = null;
    private OnFragmentInteractionListener mListener;

    public ListFragment() {
        // Required empty public constructor
    }


    // TODO remove this method with the list
    private void createList() {
        RestoList = new ArrayList<Restaurants>();
        String string = "Afghanistan";
        Restaurants resto = new Restaurants("Afghanistan", "Albania");
        RestoList.add(resto);
        resto.setNameRestaurant("Albania");
        RestoList.add(resto);
        resto.setNameRestaurant("Algeria");
        RestoList.add(resto);
        resto.setNameRestaurant("American Samoa");
        RestoList.add(resto);
        resto.setNameRestaurant("Andorra");
        RestoList.add(resto);

        for (int i = 0; i < 15; i++)
        {
            Restaurants restos = new Restaurants(Integer.toString(i), "Ouai");
            RestoList.add(restos);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //TODO REMOVE fake list
        createList();

        View view = inflater.inflate(R.layout.fragment_list, container, false);


        ListView restaurantList = (ListView) view.findViewById(R.id.RestaurantList);


        RestaurantArrayAdapter listAdapter = new RestaurantArrayAdapter(this.getContext(), RestoList);

        // Assign adapter to ListView
        restaurantList.setAdapter(listAdapter);

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
