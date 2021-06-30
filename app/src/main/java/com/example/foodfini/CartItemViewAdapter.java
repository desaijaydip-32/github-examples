package com.example.foodfini;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CartItemViewAdapter  extends  RecyclerView.Adapter<CartItemViewAdapter.CustomviewHolder> {


    Context context;
    ArrayList<CartItemModel> cartItemModel;
    public CartItemViewAdapter(Context context, ArrayList<CartItemModel> cartItemModel) {
        this.context = context;
        this.cartItemModel = cartItemModel;
    }

    @NonNull
    @Override
    public CustomviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View  view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_cart_layout, parent, false);
        return new CustomviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomviewHolder holder, int position) {

           CartItemModel model= cartItemModel.get(position);
           holder.itemImgView.setImageResource(model.getImg());
    }

    @Override
    public int getItemCount() {
        return cartItemModel.size();
    }

    class  CustomviewHolder extends RecyclerView.ViewHolder{

        ImageView itemImgView;
       public CustomviewHolder(@NonNull View itemView) {
           super(itemView);
           itemImgView = itemView.findViewById(R.id.imageView29);
       }
   }
}
