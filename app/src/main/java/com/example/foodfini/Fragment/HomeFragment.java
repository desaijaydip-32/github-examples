package com.example.foodfini.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodfini.Adapter.HomeAdapter;
import com.example.foodfini.Model.HomeModel;
import com.example.foodfini.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    ArrayList<HomeModel> homeModel;
   RecyclerView nrecyclerView , precyclerView1;
   TabLayout tabLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
           homeModel = new ArrayList<>();

           homeModel.add(new HomeModel(R.drawable.img_one,"Wastway"));
           homeModel.add(new HomeModel(R.drawable.img_two,"Fortune"));
           homeModel.add(new HomeModel(R.drawable.img_three,"Moonland"));
           homeModel.add(new HomeModel(R.drawable.img_four,"Starfish"));


        View view= inflater.inflate(R.layout.fragment_home, container, false);


        nrecyclerView= view.findViewById(R.id.restorrent1RecyclerView);
        precyclerView1= view.findViewById(R.id.populerrestorrent1RecyclerView);


        nrecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false));
        nrecyclerView.setAdapter(new HomeAdapter(getContext(), homeModel, new HomeAdapter.ShareData() {
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

        precyclerView1.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false));
        precyclerView1.setAdapter(new HomeAdapter(getContext(), homeModel, new HomeAdapter.ShareData() {
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