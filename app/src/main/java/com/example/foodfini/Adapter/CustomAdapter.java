package com.example.foodfini.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.foodfini.R;

public class CustomAdapter extends PagerAdapter {
    Context context;
    int[] img;
    String[] title;
    String[] subtitle;
    public CustomAdapter(Context context, int[] imgview, String[] titletextview, String[] subtitletextview) {
     this.context = context;
     this.img = imgview;
     this.title = titletextview;
     this.subtitle = subtitletextview;
    }

    @Override
    public int getCount() {

        return img.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view ==object;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView;
        TextView titletextview, subtextview;

       View view= LayoutInflater.from(context).inflate(R.layout.custom_spash, container,false);
         imageView = view.findViewById(R.id.ic_imgview);
         titletextview = view.findViewById(R.id.customTextView);
         subtextview = view.findViewById(R.id.customSubTextView);

         imageView.setImageResource(img[position]);
         titletextview.setText(title[position]);
         subtextview.setText(subtitle[position]);
        container.addView(view);
       return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        super.destroyItem(container, position, object);

        container.removeView((View) object);
    }
}
