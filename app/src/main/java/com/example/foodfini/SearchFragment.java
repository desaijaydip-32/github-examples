package com.example.foodfini;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class SearchFragment extends Fragment {


    ArrayList<HomeModel> homeModel;
     RecyclerView nearrestRecycclerview, populerRecycclerView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view= inflater.inflate(R.layout.fragment_search, container, false);

        homeModel = new ArrayList<>();

        homeModel.add(new HomeModel(R.drawable.img_one,"Wastway"));
        homeModel.add(new HomeModel(R.drawable.img_two,"Fortune"));
        homeModel.add(new HomeModel(R.drawable.img_three,"Moonland"));
        homeModel.add(new HomeModel(R.drawable.img_four,"Starfish"));


        nearrestRecycclerview =view.findViewById(R.id.restorrent1RecyclerView);
        populerRecycclerView =view.findViewById(R.id.populerrestorrent1RecyclerView);


        nearrestRecycclerview.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false));
        nearrestRecycclerview.setAdapter(new HomeAdapter(getContext(), homeModel, new HomeAdapter.ShareData() {
            @Override
            public void shareData(int itmeImg, String itemName) {

                Bundle bundle = new Bundle();
                bundle.putInt("imgview", itmeImg);
                bundle.putString("name", itemName);

                menuDetailsFragment fragment2 = new menuDetailsFragment();
                fragment2.setArguments(bundle);
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.container,fragment2).commit();

            }
        }));

        populerRecycclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false));
        populerRecycclerView.setAdapter(new HomeAdapter(getContext(), homeModel, new HomeAdapter.ShareData() {
            @Override
            public void shareData(int itmeImg, String itemName) {
                Bundle bundle = new Bundle();
                bundle.putInt("imgview", itmeImg);
                bundle.putString("name", itemName);


                menuDetailsFragment fragment2 = new menuDetailsFragment();
                fragment2.setArguments(bundle);
                FragmentManager manager = getFragmentManager();


                manager.beginTransaction().replace(R.id.container,fragment2).commit();
            }
        }));

        return  view;
    }
}