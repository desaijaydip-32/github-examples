package com.example.foodfini.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.foodfini.R;
import com.example.foodfini.databinding.FragmentHomeBinding;


import java.util.ArrayList;

public class HomeFragment extends Fragment {


    FoodCategoryPagerAdapter foodCategoryPagerAdapter;
    ArrayList<String> titleList;


    FragmentHomeBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        titleList = new ArrayList<>();

        titleList.add("All");
        titleList.add("Pizza");
        titleList.add("Beverages");
        titleList.add("Asian");


        foodCategoryPagerAdapter = new FoodCategoryPagerAdapter(getActivity().getSupportFragmentManager(), titleList);


        binding.viewpager.setAdapter(foodCategoryPagerAdapter);
        binding.tab.setupWithViewPager(binding.viewpager);


        binding.tab.getTabAt(0).setCustomView(R.layout.food);
        binding.tab.getTabAt(1).setCustomView(R.layout.pizza);
        binding.tab.getTabAt(2).setCustomView(R.layout.beverages);
        binding.tab.getTabAt(3).setCustomView(R.layout.asian);


    }
}