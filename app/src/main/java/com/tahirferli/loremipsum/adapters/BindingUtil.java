package com.tahirferli.loremipsum.adapters;

import android.widget.ImageView;
import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;
import com.tahirferli.loremipsum.model.Picsum;

public class BindingUtil {

    @BindingAdapter("android:setPicture")
    public static void setPic(ImageView imageView, String url) {
        Picasso.get().load(url).into(imageView);
    }
}
