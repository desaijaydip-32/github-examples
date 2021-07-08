package com.example.foodfini.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodfini.Adapter.HomeAdapter;
import com.example.foodfini.Model.HomeModel;
import com.example.foodfini.R;
import com.example.foodfini.databinding.FragmentFoodCategoryBinding;

import java.util.ArrayList;


public class FoodCategoryFragment extends Fragment {


    FragmentFoodCategoryBinding binding;
    ArrayList<HomeModel> homeModel;

    public static FoodCategoryFragment getInstantFragment(String title) {
        FoodCategoryFragment fragment = new FoodCategoryFragment();
        Bundle bundle = new Bundle();
        bundle.putString("TITLE", title);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        homeModel = new ArrayList<>();
        binding = FragmentFoodCategoryBinding.inflate(inflater, container, false);
        View view = binding.getRoot();



        homeModel.add(new HomeModel(R.drawable.img_one, "Wastway", "50% OFF"));
        homeModel.add(new HomeModel(R.drawable.img_two, "Fortune", ""));
        homeModel.add(new HomeModel(R.drawable.img_three, "Moonland", ""));
        homeModel.add(new HomeModel(R.drawable.img_four, "Starfish", ""));


        binding.mrecyclerview.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.mrecyclerview.setAdapter(new HomeAdapter(getContext(), homeModel, new HomeAdapter.ShareData() {
            @Override
            public void shareData(int itmeImg, String itemName) {

                Bundle bundle = new Bundle();
                bundle.putInt("imgview", itmeImg);
                bundle.putString("name", itemName);


                menuDetailsFragment fragment2 = new menuDetailsFragment();
                fragment2.setArguments(bundle);
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.container, fragment2).commit();

            }
        }));

        binding.nrecyclerview2.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.nrecyclerview2.setAdapter(new HomeAdapter(getContext(), homeModel, new HomeAdapter.ShareData() {
            @Override
            public void shareData(int itmeImg, String itemName) {

                Bundle bundle = new Bundle();
                bundle.putInt("imgview", itmeImg);
                bundle.putString("name", itemName);


                menuDetailsFragment fragment2 = new menuDetailsFragment();
                fragment2.setArguments(bundle);
                FragmentManager manager = getFragmentManager();


                manager.beginTransaction().replace(R.id.container, fragment2).commit();
            }
        }));


        return view;

    }
}