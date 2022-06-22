package com.example.ustcplant;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class search_answers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_answers);

        Intent intentGet = getIntent();
        List<Plant> searched_plants = (List<Plant>) intentGet.getSerializableExtra("tmp_plants");
        PlantAdapter adapter = new PlantAdapter(com.example.ustcplant.search_answers.this,
                R.layout.plant_item, searched_plants);
        ListView listView = (ListView) findViewById(R.id.answerList_view);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Plant tmpPlant = searched_plants.get(position);
                Intent introduction=new Intent(search_answers.this,introduction.class);

                Bundle message = new Bundle();
                message.putInt("name", tmpPlant.getName());
                message.putInt("species", tmpPlant.getSpecies());
                message.putInt("feature", tmpPlant.getFeature());
                message.putInt("values", tmpPlant.getValues());
                message.putInt("locations", tmpPlant.getLocation());
                message.putInt("supplement", tmpPlant.getSupplement());
                message.putInt("imageIds", tmpPlant.getImageIDs());
                message.putInt("nickname", tmpPlant.getNickname());

                introduction.putExtras(message);
                startActivity(introduction);
            }
        });
    }
}
