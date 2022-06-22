package com.example.ustcplant.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.ustcplant.Plant;
import com.example.ustcplant.PlantAdapter;
import com.example.ustcplant.R;
import com.example.ustcplant.databinding.FragmentDashboardBinding;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private final List<Plant> PlantList = new ArrayList<>();
    private String searching;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.plants_layout, container, false);
        initPlants();

        EditText sbr=myView.findViewById(R.id.sbr_input);
        ImageButton cli=myView.findViewById(R.id.sbr_click);
        sbr.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                searching = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        cli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Plant> tmpPlantList = new ArrayList<>();
                for(int i=1;i<139;i++){
                    if(getString(PlantList.get(i).getName()).contains(searching)||
                            getString(PlantList.get(i).getFeature()).contains(searching)||
                            getString(PlantList.get(i).getNickname()).contains(searching)||
                            getString(PlantList.get(i).getLocation()).contains(searching)||
                            getString(PlantList.get(i).getSpecies()).contains(searching)||
                            getString(PlantList.get(i).getSupplement()).contains(searching)){
                        Plant tmp_plant = new Plant(i,PlantList.get(i).getName(),
                                PlantList.get(i).getNickname(), PlantList.get(i).getSpecies(),
                                PlantList.get(i).getFeature(), PlantList.get(i).getValues(),
                                PlantList.get(i).getLocation(), PlantList.get(i).getSupplement(),
                                PlantList.get(i).getImageIDs());
                        tmpPlantList.add(tmp_plant);
                    }

                }
                Intent search_answers = new Intent(getActivity(), com.example.ustcplant.search_answers.class);
                search_answers.putExtra("tmp_plants", (Serializable) tmpPlantList);
                startActivity(search_answers);
            }
        });

        PlantAdapter adapter = new PlantAdapter(this.getActivity(), R.layout.plant_item, PlantList);
        ListView listView = (ListView) myView.findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Plant tmpPlant = PlantList.get(position);
                Intent introduction=new Intent(getActivity(), com.example.ustcplant.introduction.class);
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
        return myView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public static int getResId(String variableName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(variableName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }
    private void initPlants() {
        for (int i = 1; i <= 139; i++) {
            String name = "_" + i + "name";
            String nickname = "_" + i + "nickname";
            String species = "_" + i + "species";
            String feature = "_" + i + "feature";
            String values = "_" + i + "values";
            String location = "_" + i + "location";
            String supplement = "_" + i + "supplement";
            int nameId = getResId(name, R.string.class);
            int nicknameId = getResId(nickname, R.string.class);
            int speciesId = getResId(species, R.string.class);
            int featureId = getResId(feature, R.string.class);
            int valuesId = getResId(values, R.string.class);
            int locationId = getResId(location, R.string.class);
            int supplementId = getResId(supplement, R.string.class);

            Plant newPlant = new Plant(i, nameId, nicknameId, speciesId, featureId, valuesId,
                    locationId, supplementId, R.drawable.ml);
            PlantList.add(newPlant);
        }
    }
}