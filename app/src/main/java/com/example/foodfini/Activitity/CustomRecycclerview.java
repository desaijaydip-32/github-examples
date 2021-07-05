package com.example.foodfini.Activitity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.foodfini.R;

public class CustomRecycclerview extends RecyclerView.Adapter<CustomRecycclerview.CustomeViewHolder> {
    int[] imgrecycclor;
    String[] name;
    int[] color;


    public CustomRecycclerview(int[] imgrecycclor, String[] name, int[] color) {

        this.imgrecycclor = imgrecycclor;
        this.name = name;
        this.color = color;
    }

    @NonNull
    @Override
    public CustomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View  view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_recycclerview_layout,parent,false);
        return  new CustomeViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CustomeViewHolder holder, int position) {

        holder.customimg.setImageResource(imgrecycclor[position]);
        holder.nameTextViwe.setText(name[position]);


        if(imgrecycclor[position]==0){
             holder.customimg.setColorFilter(R.color.imgcolor);

        }

        else {
            holder.customimg.setColorFilter(R.color.imgcolornotselected);
        }
        holder.customimg.setImageResource(imgrecycclor[position]);






    }

    @Override
    public int getItemCount() {
        return imgrecycclor.length;
    }


    class  CustomeViewHolder extends  RecyclerView.ViewHolder{

        ImageView customimg;
        TextView nameTextViwe;
        public CustomeViewHolder(@NonNull View itemView) {
            super(itemView);

              customimg = itemView.findViewById(R.id.imageView12);
              nameTextViwe = itemView.findViewById(R.id.nametextView26);

        }
    }
}
