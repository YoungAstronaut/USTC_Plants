package com.example.ustcplant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class introduction extends AppCompatActivity{
    ImageView img;
    TextView name, species, feature, values, locations,supplement;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        Intent intro = getIntent();
        Bundle receipt = intro.getExtras();

        img=findViewById(R.id.intro_img);
        img.setImageResource(receipt.getInt("imageIds"));

        name=findViewById(R.id.plantName);
        name.setText(receipt.getInt("name"));

        species=findViewById(R.id.plantSpecies);
        species.setText(getString(receipt.getInt("species")));

        feature=findViewById(R.id.plantFeature);
        feature.setText(getString(receipt.getInt("feature")));

        values=findViewById(R.id.plantValues);
        values.setText(getString(receipt.getInt("values")));

        locations=findViewById(R.id.plantLocation);
        locations.setText(getString(receipt.getInt("locations")));

        supplement=findViewById(R.id.plantSupplement);
        supplement.setText(receipt.getInt("supplement"));
    }
}
