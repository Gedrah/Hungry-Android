package com.aziaka.donavan.hungry_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;



public class RestaurantArrayAdapter extends ArrayAdapter<Restaurants> {

    private LayoutInflater inflater;

    public RestaurantArrayAdapter(Context context, List<Restaurants> restoList) {
        super(context, R.layout.item_restaurant, R.id.TextRestaurant, restoList);
        // Cache the LayoutInflate to avoid asking for a new one each time.
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Restaurants resto = this.getItem(position);

        // The child views in each row.
        CheckBox checkBox ;
        TextView textView ;

        // Create a new row view
        if (convertView == null) {

            convertView = inflater.inflate(R.layout.item_restaurant, null);

            // Find the child views.
            textView = (TextView) convertView.findViewById(R.id.TextRestaurant);
            checkBox = (CheckBox) convertView.findViewById(R.id.CheckBoxRestaurant);

            // Optimization: Tag the row with it's child views, so we don't have to
            // call findViewById() later when we reuse the row.
            convertView.setTag(new RestaurantsViewHolder(textView,checkBox) );

            // If CheckBox is toggled, update the planet it is tagged with.
            checkBox.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    CheckBox cb = (CheckBox) v ;
                    Restaurants resto = (Restaurants) cb.getTag();
                    resto.setChecked(cb.isChecked());
                }
            });
        }
        // Reuse existing row view
        else {
            // Because we use a ViewHolder, we avoid having to call findViewById().
            RestaurantsViewHolder viewHolder = (RestaurantsViewHolder) convertView.getTag();
            checkBox = viewHolder.getCheckBox() ;
            textView = viewHolder.getTextView() ;
        }

        // Tag the CheckBox with the Planet it is displaying, so that we can
        // access the planet in onClick() when the CheckBox is toggled.
        checkBox.setTag(resto);

        // Display planet data
        checkBox.setChecked(resto.isChecked());
        textView.setText(resto.getNameRestaurant() );

        return convertView;
    }

    private static class RestaurantsViewHolder {

        private CheckBox checkBox;
        private TextView textView;

        public RestaurantsViewHolder() {}

        public RestaurantsViewHolder(TextView textView, CheckBox checkBox) {
            this.checkBox = checkBox;
            this.textView = textView;
        }

        public CheckBox getCheckBox() {
            return checkBox;
        }

        public void setCheckBox(CheckBox checkBox) {
            this.checkBox = checkBox;
        }

        public TextView getTextView() {
            return textView;
        }

        public void setTextView(TextView textView) {
            this.textView = textView;
        }
    }

}