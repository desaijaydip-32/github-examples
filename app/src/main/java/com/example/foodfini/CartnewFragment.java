package com.example.foodfini;

import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class CartnewFragment extends Fragment {

    ArrayList<CartItemModel> cartItemModel;
    RecyclerView showItemRecyclerView;
    TextView contTexView;
    TextView oderTexView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         cartItemModel = new ArrayList<>();
         cartItemModel.add(new CartItemModel(R.drawable.img_one));
         cartItemModel.add(new CartItemModel(R.drawable.img_two));
         cartItemModel.add(new CartItemModel(R.drawable.img_three));

        View  view = inflater.inflate(R.layout.fragment_cartnew, container, false);

        showItemRecyclerView = view.findViewById(R.id.ShowRecycclervier);
        contTexView = view.findViewById(R.id.editTextTextPersonName);


          contTexView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {

                  AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                  AlertDialog alertDialog  =  builder.create();
                  View view1 = LayoutInflater.from(getContext()).inflate(R.layout.success__custom_layout,null,false);
                  alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                  oderTexView =view1.findViewById(R.id.trackTextView);

                   alertDialog.setView(view1);

                  oderTexView.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View v) {
                          alertDialog.dismiss();
                      }
                  });
                  alertDialog.show();

              }
          });








        showItemRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        showItemRecyclerView.setAdapter(new CartItemViewAdapter(getContext(), cartItemModel));



        return  view;
    }
}