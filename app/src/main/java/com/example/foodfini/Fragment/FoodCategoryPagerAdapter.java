package com.example.foodfini.Fragment;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

public class FoodCategoryPagerAdapter extends FragmentStatePagerAdapter {

    ArrayList<String> title = new ArrayList<>();


    public FoodCategoryPagerAdapter(@NonNull FragmentManager fm, ArrayList<String> titleList) {
        super(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.title = titleList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        return FoodCategoryFragment.getInstantFragment(title.get(position));
    }

    @Override
    public int getCount() {
        return title.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }
}
