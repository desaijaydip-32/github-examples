package com.example.foodfini.Activitity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import com.example.foodfini.Fragment.CartnewFragment;
import com.example.foodfini.Fragment.HomeFragment;
import com.example.foodfini.Fragment.MenuResFragment;
import com.example.foodfini.Fragment.mapFragment;
import com.example.foodfini.R;
import com.example.foodfini.Fragment.SearchFragment;


import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    BottomNavigationView navigationView;
    private boolean backstatus = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//       binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.bottomView);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                switch (item.getItemId()) {

                    case R.id.home:

                        loadFragment(new HomeFragment(), "home");
                        break;
                    case R.id.search:

                        loadFragment(new SearchFragment(), "search");
                        break;
                    case R.id.cart:

                        loadFragment(new MenuResFragment(), "cart");
                        break;
                    case R.id.user:

                        loadFragment(new mapFragment(), "user");
                        break;
                }

                return true;
            }
        });
    }

    private void loadFragment(Fragment fragment, String name) {

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragment);




          if(name.equals("search") ){
              transaction.addToBackStack(null);
              loadFragment(new HomeFragment(),"home");
              backstatus = true;


          }
          else if(name.equals("cart") ){
               backstatus = false;
               transaction.addToBackStack(null);
              loadFragment(new SearchFragment(),"search");

          }
         else if(name.equals("user") ) {
              backstatus = false;

              transaction.addToBackStack(null);
              loadFragment(new MenuResFragment(),"cart");
          }

          transaction.commit();

    }



    public  void setnavitem(int id){


      Menu menu=  navigationView.getMenu();
     MenuItem menuItem= menu.getItem(id);
     menuItem.setChecked(true);

    }


}