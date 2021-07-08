package com.example.foodfini.Activitity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.example.foodfini.Adapter.CustomAdapter;
import com.example.foodfini.R;
import com.example.foodfini.databinding.ActivitySpashBinding;

public class spashActivity extends AppCompatActivity {


    ActivitySpashBinding spashBinding;
    int img[];
    String titletext[], subtitletext[];
    TextView dotstext[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       spashBinding= ActivitySpashBinding.inflate(getLayoutInflater());

        setContentView(spashBinding.getRoot());
       //  getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000")));



        img = new int[]{R.drawable.ic_popcorn, R.drawable.ic_money_,R.drawable.ic_restaurant};
        titletext = new String[]{"Choose A Tasty Dish","Easy Payment","Enjoy the Taste!"};
        subtitletext = new String[]{"Order anything you want from your Favorite restaurant.","Payment made easy through debit card, credit card  & more ways to pay for your food","Healthy eating means eating a variety of foods that give you the nutrients you need to maintain your health."};


        spashBinding.viewpager2.setAdapter(new CustomAdapter(spashActivity.this, img, titletext, subtitletext));
        addDot(0);

        setNextItemView();


        spashBinding.viewpager2.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                addDot(i);
            }
            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

//        spashBinding.nextbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               startActivity(new Intent(spashActivity.this, RegisterMainActivity.class));
//
//
//            }
//        });
    }




    private void setNextItemView() {

        spashBinding.nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spashBinding.viewpager2.setCurrentItem(spashBinding.viewpager2.getCurrentItem() + 1);
            }
        });
    }



    private void addDot(int pos) {

        dotstext= new TextView[img.length];
        spashBinding.linearLayout.removeAllViews();

        for (int j = 0; j < dotstext.length; j++) {;
            dotstext[j] = new TextView(this);
            dotstext[j].setText(Html.fromHtml("&#9679;"));
            dotstext[j].setTextSize(15);
            dotstext[j].setLetterSpacing((float) 0.3);
            dotstext[j].setTextColor(getResources().getColor(R.color.red));
            spashBinding.linearLayout.addView(dotstext[j]);
        }

        dotstext[pos].setTextColor(getResources().getColor(R.color.darker_gray));


        if (pos == 0) {

        } else if (pos == 1) {

        } else {

            newActivitypage();

        }

    }


    private void newActivitypage() {

        spashBinding.nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(spashActivity.this, RegisterMainActivity.class));
                finish();
            }
        });
    }
}