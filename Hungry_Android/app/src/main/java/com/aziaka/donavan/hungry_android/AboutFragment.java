package com.aziaka.donavan.hungry_android;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;


public class AboutFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        int versionCode = BuildConfig.VERSION_CODE;
        String versionName = BuildConfig.VERSION_NAME;


        // TODO ASk for a Title (HUNGRY) and for a Logo

        View aboutPage = new AboutPage(getContext())
                .setImage(R.drawable.about_icon_github)
                .setDescription("Application made by Donavan Aziaka.")
                .addItem(new Element().setTitle("Version " + versionName))
                .addEmail("donavan.aziaka@epitech.eu", "For any requests, send me an email.")
                .addGitHub("Gedrah", "Gedrah")
                .create();
        return aboutPage;
    }


}
