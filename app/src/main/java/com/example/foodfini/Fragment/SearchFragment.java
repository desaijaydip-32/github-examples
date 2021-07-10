package com.example.foodfini.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodfini.Activitity.MainActivity;
import com.example.foodfini.Adapter.HomeAdapter;
import com.example.foodfini.Model.HomeModel;
import com.example.foodfini.R;
import com.example.foodfini.databinding.FragmentSearchBinding;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class    SearchFragment extends Fragment {


    ArrayList<HomeModel> homeModel;
    FragmentSearchBinding searchBinding;
    FoodCategoryPagerAdapter foodCategoryPagerAdapter;
    ArrayList<String> titleList;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        searchBinding= FragmentSearchBinding.inflate(inflater, container, false);
        View view = searchBinding.getRoot();
        homeModel = new ArrayList<>();

        return  view;
    }

    @Override
    public void onStart() {
        super.onStart();

        ((MainActivity)getActivity()).setnavitem(1);
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


        searchBinding.viewpager.setAdapter(foodCategoryPagerAdapter);
        searchBinding.tab1.setupWithViewPager(searchBinding.viewpager);


        searchBinding.tab1.getTabAt(0).setCustomView(R.layout.food);
        searchBinding.tab1.getTabAt(1).setCustomView(R.layout.pizza);
        searchBinding.tab1.getTabAt(2).setCustomView(R.layout.beverages);
        searchBinding.tab1.getTabAt(3).setCustomView(R.layout.asian);


    }

}