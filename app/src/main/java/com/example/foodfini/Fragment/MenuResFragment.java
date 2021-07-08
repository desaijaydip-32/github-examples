package com.example.foodfini.Fragment;

import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.foodfini.Adapter.CartAdapter;
import com.example.foodfini.Fragment.CartnewFragment;
import com.example.foodfini.Model.MenuModel;
import com.example.foodfini.R;

import java.util.ArrayList;

public class MenuResFragment extends Fragment {

    ArrayList<MenuModel> arrayList;
    RecyclerView recyclerView;
    TextView cntTextView, viewTexView;
    ImageView backimgview;
    TextView checkview;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        arrayList = new ArrayList<>();
        arrayList.add(new MenuModel(R.drawable.img_one, 140, "Vegitable Salad", false));
        arrayList.add(new MenuModel(R.drawable.img_two, 150, "Burger with some", false));
        arrayList.add(new MenuModel(R.drawable.img_three, 140, "Vegitable Salad", false));
        arrayList.add(new MenuModel(R.drawable.img_four, 140, "Vegitable Salad", false));

        View view = inflater.inflate(R.layout.fragment_menu_res, container, false);

        recyclerView = view.findViewById(R.id.bestsellerrecycelrview34);
        cntTextView = view.findViewById(R.id.textView41);
        viewTexView = view.findViewById(R.id.viewtextView44);
        backimgview = view.findViewById(R.id.imageView33);

        viewTexView.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                AlertDialog alertDialog = builder.create();
                View view1 = getLayoutInflater().inflate(R.layout.dummy, null);

                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                checkview = view1.findViewById(R.id.orderTextView);
                alertDialog.setView(view1);

                 checkview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        FragmentManager manager = getFragmentManager();
                        manager.beginTransaction().replace(R.id.container, new CartnewFragment()).commit();
                        alertDialog.dismiss();
                    }
                });
                alertDialog.show();

            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new CartAdapter(getContext(), arrayList, cntTextView, backimgview));
        return view;
    }
}