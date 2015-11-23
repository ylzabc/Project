package com.example.administrator.project;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.qf.fragment.brand_fragment;
import com.qf.fragment.headpage_fragmnet;

public class MainActivity extends FragmentActivity {
    /////
    private FragmentManager manager;
    private RadioGroup group;
    private Fragment first=null;
    private headpage_fragmnet myhomefragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initdata();
    }
    private void initView() {
        group= (RadioGroup) findViewById(R.id.radiogroup);
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        myhomefragment = new headpage_fragmnet(MainActivity.this);
        transaction.add(R.id.container, myhomefragment, "home");
        transaction.commit();
        first=myhomefragment;
    }
    private void initdata() {

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                manager.beginTransaction().hide(first).commit();

                switch (checkedId) {
                    case R.id.home:
                        Fragment home = manager.findFragmentByTag("home");
                        manager.beginTransaction().show(home).commit();
                        first = home;
                        break;
                    case R.id.discover:
                        Fragment discover = manager.findFragmentByTag("discover");
                        if (discover == null) {
                            discover = new brand_fragment(MainActivity.this);
                            manager.beginTransaction().add(R.id.container, discover, "discover").commit();
                        } else {
                            manager.beginTransaction().show(discover).commit();
                        }
                        first = discover;
                        break;
                }
            }
        });
    }

}
