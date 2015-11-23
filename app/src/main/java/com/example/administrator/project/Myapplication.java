package com.example.administrator.project;

import android.app.Application;

import com.qf.utils.ShareUtils;
import com.qf.utils.VolleyUtils;

/**
 * Created by Administrator on 15-11-23.
 */
public class Myapplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        VolleyUtils.initQueue(this);
        ShareUtils.init_sharedpreferences(this);
    }
}
