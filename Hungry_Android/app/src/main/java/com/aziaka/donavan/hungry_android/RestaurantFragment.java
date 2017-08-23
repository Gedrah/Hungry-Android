package com.aziaka.donavan.hungry_android;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;


public class RestaurantFragment extends Fragment {

    private ArrayList<Restaurants> RestoList = null;
    private ListFragment.OnDataPass dataPasser;
    TextView restoName = null;
    TextView restoAddress = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        RestoList = ((MainActivity) getActivity()).getRestoList();

        View view = inflater.inflate(R.layout.fragment_restaurant, container, false);


        restoName = (TextView) view.findViewById(R.id.restaurantName);
        restoAddress = (TextView) view.findViewById(R.id.restaurantAddress);



        return view;
    }


    /*
    ** Main method that will choose a restaurant randomly
    */
    private void rollRestaurant() {

        boolean checking = false;
        Random random = new Random();

        // check if the list is not empty
        if (RestoList == null || RestoList.isEmpty())
        {
            Snackbar.make(getView().findViewById(android.R.id.content), "Error: The list is empty. Check your internet connection.", Snackbar.LENGTH_LONG).show();
            return;
        }

        // check if atleast one restaurant is checked
        for (int i = 0; i < RestoList.size() || checking; i++)
        {
            Restaurants item = RestoList.get(i);
            if (item.isChecked()) {
                checking = true;
            }
        }

        //check if checking is true
        if (!checking)
        {
            Snackbar.make(getView().findViewById(android.R.id.content), "Error: Check at least one restaurant.", Snackbar.LENGTH_LONG).show();
            return;
        }


        //look for a random place to eat :)
        while (true) {
            int i = random.nextInt(RestoList.size());
            Restaurants item = RestoList.get(i);
            if (item.isChecked()) {
                setRestoInfo(item);
                return;
            }

        }

    }


    /*
    update informations
     */
    void setRestoInfo (Restaurants info) {
        restoName.setText(info.getNameRestaurant());
        restoAddress.setText(info.getAddressRestaurant());
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        dataPasser = (ListFragment.OnDataPass) context;
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
