package com.example.lsj.yunmusic.mFragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;


public class MainFragmentAdapter_1 extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragmentArrayList;
    private Fragment mainFragment1;
    private Fragment mainFragment2;
    private Fragment mainFragment3;
    private Fragment mainFragment4;
    private static final String[] TITLE = new String[] { "  个性推荐", "歌单", "主播电台", "排行版"};
    public MainFragmentAdapter_1(FragmentManager fm) {
        super(fm);
        mainFragment1 = new Main1_Fragment1();
        mainFragment2 = new Main1_Fragment2();
        mainFragment3 = new Main1_Fragment3();
        mainFragment4 = new Main1_Fragment4();
        fragmentArrayList = new ArrayList<>();
        fragmentArrayList.add(mainFragment1);
        fragmentArrayList.add(mainFragment2);
        fragmentArrayList.add(mainFragment3);
        fragmentArrayList.add(mainFragment4);
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
            case 3:
                return fragmentArrayList.get(3);
            default:
                return null;
        }

    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLE[position];
    }

    @Override
    public int getCount() {
        return 4;
    }
}
