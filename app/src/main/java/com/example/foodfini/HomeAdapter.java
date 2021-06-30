package com.example.foodfini;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeAdapter  extends  RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

    Context context;
    ArrayList<HomeModel> homeModel;
    ShareData shareData;
    public HomeAdapter(Context context, ArrayList<HomeModel> homeModel , ShareData shareData) {
        this.context = context;
        this.homeModel = homeModel;
        this.shareData = shareData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_custom_layout,null,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

   holder.c_imgview.setImageResource(homeModel.get(position).getImg());
   holder.item_name.setText(homeModel.get(position).getItemname());


   holder.itemView.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           shareData.shareData(homeModel.get(position).getImg(),homeModel.get(position).getItemname() );
       }
   });

    }

    @Override
    public int getItemCount() {
        return homeModel.size();
    }

    class  MyViewHolder extends RecyclerView.ViewHolder{


        ImageView c_imgview;
        TextView  item_name;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            c_imgview = itemView.findViewById(R.id.c_img);
            item_name = itemView.findViewById(R.id.itemNameTextView);
        }
    }


 public    interface  ShareData{

        public  void shareData(int itmeImg , String itemName);
 }
}
