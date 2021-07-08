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


public class    SearchFragment extends Fragment {


    ArrayList<HomeModel> homeModel;

    TabLayout tab;
     RecyclerView nearrestRecycclerview, populerRecycclerView;

     TabLayout tabLayout;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view= inflater.inflate(R.layout.fragment_search, container, false);

       //  tabLayout = view.findViewById(R.id.tab);

//
//        tabLayout.getTabAt(0).setCustomView(R.layout.food);
//        tabLayout.getTabAt(1).setCustomView(R.layout.food);
//        tabLayout.getTabAt(2).setCustomView(R.layout.food);

//
//        tabLayout.getTabAt(0).setText("all");
//        tabLayout.getTabAt(1).setText("all");
//        tabLayout.getTabAt(2).setText("all");
//

        homeModel = new ArrayList<>();






        homeModel.add(new HomeModel(R.drawable.img_one, "Wastway", "50%"));
        homeModel.add(new HomeModel(R.drawable.img_two, "Fortune",""));
        homeModel.add(new HomeModel(R.drawable.img_three, "Moonland",""));
        homeModel.add(new HomeModel(R.drawable.img_four, "Starfish",""));


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