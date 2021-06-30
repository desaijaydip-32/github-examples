package com.example.foodfini;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class menuAdapter extends  RecyclerView.Adapter<menuAdapter.MyViewHolder> {


    Context context;
    int img[];
    public menuAdapter(Context context, int[] imageView) {
        this.context = context;
        this.img = imageView;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sellert_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

          holder.itemImg.setImageResource(img[position]);
          holder.textView.setText("Vegitable Salad");
    }

    @Override
    public int getItemCount() {
        return img.length;
    }

    class  MyViewHolder extends RecyclerView.ViewHolder{


        ImageView itemImg;
        TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

           itemImg = itemView.findViewById(R.id.itemimageView);
           textView = itemView.findViewById(R.id.textView24);
        }
    }
}
