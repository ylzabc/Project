package com.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.project.R;

/**
 * Created by Administrator on 15-11-23.
 */
public class Brand_fragment extends Fragment {
    private final Context context;

    public Brand_fragment(Context context) {

        this.context=context;
    }
////////////////////////

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.layout1,container,false);
    }
}
