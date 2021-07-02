package com.example.foodfini.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foodfini.Adapter.menuAdapter;
import com.example.foodfini.R;


public class menuDetailsFragment extends Fragment {


    int imgview[];

  ImageView imageView,likeImg; TextView itemnameTextView;
  RecyclerView sellerRecycclerview;
  boolean clicked = true;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        int img = bundle.getInt("imgview", 0);

        String name = bundle.getString("name");

        imgview = new int[]{R.drawable.img_one, R.drawable.img_two, R.drawable.img_three, R.drawable.img_four};


        View view = inflater.inflate(R.layout.fragment_menu_details, container, false);

       imageView=  view.findViewById(R.id.menuImageView);
        likeImg=  view.findViewById(R.id.likeImgView);
        itemnameTextView=view.findViewById(R.id.menuitelTextView);

        sellerRecycclerview = view.findViewById(R.id.sellerrecyclerview);
        imageView.setImageResource(img);
        itemnameTextView.setText(name);




        likeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(clicked){
                    likeImg.setImageResource(R.drawable.ic_like);
                    clicked = false;
                }
                else {
                    likeImg.setImageResource(R.drawable.ic_dislike);
                    clicked = true;
                }
            }
        });
        sellerRecycclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        sellerRecycclerview.setAdapter(new menuAdapter(getContext(),imgview));

        return  view;
    }
}