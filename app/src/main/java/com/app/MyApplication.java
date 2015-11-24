package com.app;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.utils.ImageLoadUtils;
import com.utils.ShareUtils;
import com.utils.VolleyUtils;

/**
 * Created by Administrator on 15-11-24.
 */
public class MyApplication  extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoadUtils.init(getApplicationContext());
        VolleyUtils.initQueue(this);
        ShareUtils.init_sharedpreferences(this);
    }
}
