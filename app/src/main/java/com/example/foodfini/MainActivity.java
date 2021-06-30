package com.example.foodfini;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import android.os.Bundle;
import android.view.MenuItem;


import com.example.foodfini.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


     ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFragment()).commit();

        binding.bottomView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment temp = null;
                  switch (item.getItemId()){
                      case R.id.home :temp = new HomeFragment();
                      break;
                      case R.id.search :temp = new SearchFragment();
                          break;
                          case R.id.cart :temp = new MenuResFragment();
                          break;
                  }

                  getSupportFragmentManager().beginTransaction().replace(R.id.container,temp ).addToBackStack(null).commit();
                return true;
            }
        });
    }
}