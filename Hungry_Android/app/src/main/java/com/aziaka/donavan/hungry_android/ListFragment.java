package com.aziaka.donavan.hungry_android;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class ListFragment extends Fragment {

    private ArrayList<Restaurants> RestoList = null;
    private OnDataPass dataPasser;


    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_list, container, false);


        ListView restaurantList = (ListView) view.findViewById(R.id.RestaurantList);



        RestoList = ((MainActivity) getActivity()).getRestoList();

        RestaurantArrayAdapter listAdapter = new RestaurantArrayAdapter(this.getContext(), RestoList);

        // Assign adapter to ListView
        restaurantList.setAdapter(listAdapter);

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        dataPasser = (OnDataPass) context;
    }

    @Override
    public void onDetach() {
        passData(this.RestoList);
        super.onDetach();
    }

    public void passData(ArrayList<Restaurants> data) {
        dataPasser.onDataPass(data);
    }


    public interface OnDataPass {
        public void onDataPass(ArrayList<Restaurants> data);
    }

}
