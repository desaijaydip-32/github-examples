package com.example.foodfini.Activitity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.foodfini.R;

public class CustomActivity2 extends AppCompatActivity {


    int imgrecycclor[];
    String  name[];
    int  color[];
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom2);

        recyclerView  = findViewById(R.id.recyclcer);


        imgrecycclor = new int[]{R.drawable.ic_fast_food, R.drawable.ic_ion_pizza, R.drawable.ic_vector, R.drawable.ic_asian};
        name = new String[]{"All", "Pizaa", "Bevrages", "asina"};
        color = new int[]{R.color.imgcolor,R.color.imgcolornotselected,R.color.imgcolornotselected,R.color.imgcolornotselected,R.color.imgcolornotselected};


        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
         recyclerView.setAdapter(new CustomRecycclerview(imgrecycclor,name, color ));




    }
}