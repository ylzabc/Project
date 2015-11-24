package com.example.administrator.project;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.fragment.Brand_fragment;
import com.fragment.Headpage_fragment;

public class MainActivity extends FragmentActivity {
    private FragmentManager manager;
    private RadioGroup group;
    private Fragment lastFragment=null;
    private Headpage_fragment headpage_fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initdata();
    }
    private void initView() {
        group= (RadioGroup) findViewById(R.id.rg_id);
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        headpage_fragment = new Headpage_fragment(MainActivity.this);
        transaction.add(R.id.container, headpage_fragment, "home");
        transaction.commit();
        lastFragment=headpage_fragment;
    }
    private void initdata() {

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                manager.beginTransaction().hide(lastFragment).commit();

                switch (checkedId) {
                    case R.id.rb_id1:
                        Fragment home = manager.findFragmentByTag("home");
                        manager.beginTransaction().show(home).commit();
                        lastFragment = headpage_fragment;
                        break;
                    case R.id.rb_id2:
                        Fragment brand_fragment = manager.findFragmentByTag("brand");
                        if (brand_fragment == null) {
                            brand_fragment = new Brand_fragment(MainActivity.this);
                            manager.beginTransaction().add(R.id.container, brand_fragment, "brand").commit();
                        } else {
                            manager.beginTransaction().show(brand_fragment).commit();
                        }
                        lastFragment =brand_fragment ;
                        break;
                    case R.id.rb_id3:
                        break;
                }
            }
        });
    }

}
