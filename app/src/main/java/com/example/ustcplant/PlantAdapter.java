package com.example.ustcplant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PlantAdapter extends ArrayAdapter<Plant>{
    private int resourceId;
    public PlantAdapter(Context context,
                        int textViewSourceID,
                        List<Plant> object){
        super(context, textViewSourceID, object);
        resourceId = textViewSourceID;
    }
    public View getView(int position, View coverView, ViewGroup parent){
        Plant plant = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        ImageView plantImage = (ImageView) view.findViewById(R.id.image);
        TextView plantName = (TextView) view.findViewById(R.id.name);
        TextView plantSpecies = (TextView) view.findViewById(R.id.species);
        plantImage.setImageResource(plant.getImageIDs());
        plantName.setText(plant.getName());
        plantSpecies.setText(plant.getSpecies());
        return view;
    }

}
