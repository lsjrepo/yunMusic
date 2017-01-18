package com.example.lsj.yunmusic.mFragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MainFragmentAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragmentArrayList;
    private Fragment mainFragment1;
    private Fragment mainFragment2;
    private Fragment mainFragment3;

    public MainFragmentAdapter(FragmentManager fm) {
        super(fm);
        mainFragment1 = new MainFragment1();
        mainFragment2 = new MainFragment2();
        mainFragment3 = new MainFragment3();
        fragmentArrayList = new ArrayList<>();
        fragmentArrayList.add(mainFragment1);
        fragmentArrayList.add(mainFragment2);
        fragmentArrayList.add(mainFragment3);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return fragmentArrayList.get(0);
            case 1:
                return fragmentArrayList.get(1);
            case 2:
                return fragmentArrayList.get(2);
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 3;
    }
}
