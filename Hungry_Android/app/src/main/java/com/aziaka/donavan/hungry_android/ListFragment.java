package com.aziaka.donavan.hungry_android;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class ListFragment extends Fragment {


    private ArrayList<String> StringList = null;
    private OnFragmentInteractionListener mListener;

    public ListFragment() {
        // Required empty public constructor
    }


    private void createList() {
        StringList = new ArrayList<String>();
        String string = "Afghanistan";
        StringList.add(string);
        string = "Albania";
        StringList.add(string);
        string = "Algeria";
        StringList.add(string);
        string = "American Samoa";
        StringList.add(string);
        string = "Andorra";
        StringList.add(string);
        string = "Angola";
        StringList.add(string);
        string = "Anguilla";
        StringList.add(string);
        string = "Albania";
        StringList.add(string);
        string = "Algeria";
        StringList.add(string);
        string = "American Samoa";
        StringList.add(string);
        string = "Andorra";
        StringList.add(string);
        string = "Angola";
        StringList.add(string);
        string = "Anguilla";
        StringList.add(string);
        string = "Albania";
        StringList.add(string);
        string = "Algeria";
        StringList.add(string);
        string = "American Samoa";
        StringList.add(string);
        string = "Andorra";
        StringList.add(string);
        string = "Angola";
        StringList.add(string);
        string = "Anguilla";
        StringList.add(string);
        string = "Albania";
        StringList.add(string);
        string = "Algeria";
        StringList.add(string);
        string = "American Samoa";
        StringList.add(string);
        string = "Andorra";
        StringList.add(string);
        string = "Angola";
        StringList.add(string);
        string = "Anguilla";
        StringList.add(string);
        string = "Albania";
        StringList.add(string);
        string = "Algeria";
        StringList.add(string);
        string = "American Samoa";
        StringList.add(string);
        string = "Andorra";
        StringList.add(string);
        string = "Angola";
        StringList.add(string);
        string = "Anguilla";
        StringList.add(string);
        string = "Albania";
        StringList.add(string);
        string = "Algeria";
        StringList.add(string);
        string = "American Samoa";
        StringList.add(string);
        string = "Andorra";
        StringList.add(string);
        string = "Angola";
        StringList.add(string);
        string = "Anguilla";
        StringList.add(string);
        string = "Albania";
        StringList.add(string);
        string = "Algeria";
        StringList.add(string);
        string = "American Samoa";
        StringList.add(string);
        string = "Andorra";
        StringList.add(string);
        string = "Angola";
        StringList.add(string);
        string = "Anguilla";
        StringList.add(string);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        createList();

        View view = inflater.inflate(R.layout.fragment_list, container, false);


        ListView restaurantList = (ListView) view.findViewById(R.id.RestaurantList);

        System.out.println(StringList.size());

        // Assign adapter to ListView
        restaurantList.setAdapter(new ArrayAdapter<String>(getContext(), R.layout.item_restaurant, StringList));


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
