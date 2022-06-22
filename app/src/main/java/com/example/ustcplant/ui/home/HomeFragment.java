package com.example.ustcplant.ui.home;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.ustcplant.R;
import com.example.ustcplant.databinding.FragmentHomeBinding;



public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.homepage_activity, container, false);
        ImageButton imageButton1, imageButton2;
        imageButton1 = myView.findViewById(R.id.plantsIcon);
        imageButton2 = myView.findViewById(R.id.mapIcon);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getActivity(), "亲亲，该按钮直达功能存在bug，请点击下方导航栏“图鉴”哦", Toast.LENGTH_LONG*5);
                toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL , 0, 0);  //设置显示位置
                TextView textView = (TextView) toast.getView().findViewById(android.R.id.message);
                textView.setTextColor(Color.BLACK);
                toast.show();
            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getActivity(), "亲亲，该按钮直达功能存在bug，请点击下方导航栏“地图”哦", Toast.LENGTH_LONG*5);
                toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL , 0, 0);  //设置显示位置
                TextView textView = (TextView) toast.getView().findViewById(android.R.id.message);
                textView.setTextColor(Color.BLACK);
                toast.show();
            }
        });
        return myView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}