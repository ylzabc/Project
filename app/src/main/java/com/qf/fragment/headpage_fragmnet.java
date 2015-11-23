package com.qf.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.project.R;

/**
 * Created by Administrator on 15-11-23.
 */
public class headpage_fragmnet extends Fragment {

    private final Context context;

    public headpage_fragmnet(Context context) {
        this.context=context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout2, container, false);
    }
}
