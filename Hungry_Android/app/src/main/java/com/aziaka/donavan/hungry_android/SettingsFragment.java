package com.aziaka.donavan.hungry_android;

import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceFragment;

public class SettingsFragment extends PreferenceFragment {

    private OnFragmentInteractionListener mListener;

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.layout.fragment_settings);
    }

    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(Uri uri);

    }
}
