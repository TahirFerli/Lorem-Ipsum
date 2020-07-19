package com.tahirferli.loremipsum.adapters;

import android.widget.ImageView;
import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;
import com.tahirferli.loremipsum.model.Picsum;

import timber.log.Timber;

public class BindingUtil {

    @BindingAdapter("android:setPicture")
    public static void setPic(ImageView imageView, Picsum picsum) {
        int[] sizes = getSmallerPicSizes(picsum.getWidth(), picsum.getHeight());
        Picasso.get()
                .load(picsum.getDownloadUrl())
                .resize(sizes[0], sizes[1])
                .into(imageView);
    }

    private static int[] getSmallerPicSizes(int width, int height) {
        Timber.wtf("width: %s height: %s before", width, height);
        int[] sizes = new int[2];
        // Get 1/10 size of the image if it is bigger than 1500.
        if(width > 1500) {
            width = (int) Math.round(width * 0.1);
            height = (int) Math.round(height * 0.1);
            Timber.wtf("width: %s height: %s after", width, height);
        }

        sizes[0] = width;
        sizes[1] = height;

        return sizes;
    }


}
