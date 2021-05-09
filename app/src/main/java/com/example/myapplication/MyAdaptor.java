package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.Objects;

public class MyAdaptor extends PagerAdapter {
    // Context object
    Context context;

    // Array of images
    int[] images;

    // Layout Inflater
    LayoutInflater mLayoutInflater;

    public MyAdaptor(Context context, int[] images) {
        this.context = context;
        this.images = images;
        this.mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View itemView=mLayoutInflater.inflate(R.layout.item,container,false);
        ImageView imageView= itemView.findViewById(R.id.imageViewMain);
        imageView.setImageResource(images[position]);
        Objects.requireNonNull(container).addView(itemView);
        return itemView;
        //return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout )object);
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return  view==((LinearLayout) object);
  //      return false;
    }
}
