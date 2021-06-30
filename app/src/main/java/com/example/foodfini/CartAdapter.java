package com.example.foodfini;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CartAdapter extends  RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    Context context;
    ArrayList<MenuModel> arrayList;
    TextView cntTextView;
    int cnt =0;
      boolean cck = false;
    ImageView backimgview;

    public CartAdapter(Context context, ArrayList<MenuModel> arrayList, TextView cntTextView, ImageView backimgview) {
        this.arrayList = arrayList;
        this.context = context;
        this.cntTextView = cntTextView;
        this.backimgview = backimgview;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cart_item_show, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {


        MenuModel model = arrayList.get(position);

        holder.imageView.setImageResource(model.getImg());
        holder.itemTextView.setText(model.getItemName());
        holder.rsTextView.setText(model.getPrice()+"");
        holder.plusicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(model.isCart()==false){
                    model.setCart(true);
                      cnt++;
                    holder.plusicon.setImageResource(R.drawable.ic_right);
                   // Log.d("Value" ,String.valueOf(cnt));



                }
                else{
                     model.setCart(false);
                     cnt--;
                    holder.plusicon.setImageResource(R.drawable.ic_plus_square);
                }
//
                if(cnt>0){

                     cntTextView.setText(String.valueOf(cnt));
                    backimgview.setVisibility(View.VISIBLE);
                }
                else
                {
                    backimgview.setVisibility(View.GONE);
                }
            }
        });
        
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class CartViewHolder extends RecyclerView.ViewHolder{

         TextView itemTextView, rsTextView;
         ImageView imageView, plusicon;


        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
           imageView= itemView.findViewById(R.id.imageView29);
            itemTextView= itemView.findViewById(R.id.textView24);
            rsTextView= itemView.findViewById(R.id.textView34);

            plusicon = itemView.findViewById(R.id.imageView30);
        }
    }
}
