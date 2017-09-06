package com.laker.xlibrary.loader;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.laker.xlibrary.view.GlideCircleTransform;
import com.laker.xlibs.utils.imageload.ImageLoader;


public class GlideImageLoader implements ImageLoader {

    private Context mContext;

    public static GlideCircleTransform circleTransform;

    public GlideImageLoader(Context context) {
        this.mContext=context;
        circleTransform=new GlideCircleTransform(mContext);
    }

    @Override
    public void load(ImageView imageView, Object imageUrl) {
        Glide.with(mContext)
                .load(imageUrl)
                .crossFade()
                .into(imageView);
    }

    @Override
    public void load(ImageView imageView, Object imageUrl, int defaultImage) {
        Glide.with(mContext)
                .load(imageUrl)
                .crossFade()
                .placeholder(defaultImage)
                .into(imageView);
    }

    @Override
    public void load(ImageView imageView, Object imageUrl, Object transformation) {
        Glide.with(mContext)
                .load(imageUrl)
                .crossFade()
                .transform((BitmapTransformation) transformation)
                .into(imageView);
    }
}