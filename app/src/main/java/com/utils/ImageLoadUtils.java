package com.utils;

import android.content.Context;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by Administrator on 15-11-23.
 */
public class ImageLoadUtils {
 public static void init(Context context){
     DisplayImageOptions options=new DisplayImageOptions.Builder()
            .cacheInMemory(true)
             .cacheOnDisk(true)
             .build();
     ImageLoaderConfiguration configuration=new ImageLoaderConfiguration.Builder(context)
             .diskCacheSize(50*1024*1024)
             .diskCacheFileCount(100)
             .memoryCacheSizePercentage(20)
             .defaultDisplayImageOptions(options)
             .build();
     ImageLoader.getInstance().init(configuration);
 }



}
