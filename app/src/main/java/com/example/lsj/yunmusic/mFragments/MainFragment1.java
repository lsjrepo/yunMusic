package com.example.lsj.yunmusic.mFragments;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.lsj.yunmusic.R;
import com.viewpagerindicator.TabPageIndicator;

/**
 *
 */
public class MainFragment1 extends Fragment {
    private ViewPager mainViewPager1;
    private MainFragmentAdapter_1 adapter;
    private TabPageIndicator mIndicator1 ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.mainfragment1, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mainViewPager1 = (ViewPager) getActivity().findViewById(R.id.mainFragment_pager1);
        mainViewPager1.setCurrentItem(0);
        adapter = new MainFragmentAdapter_1(getChildFragmentManager());
        mainViewPager1.setAdapter(adapter);
        mIndicator1 =  (TabPageIndicator) getActivity().findViewById(R.id.id_indicator1);
        mIndicator1.setViewPager(mainViewPager1,0);
        mIndicator1.setOnPageChangeListener(new MyOnPageChangeListen());
    }



    private class MyOnPageChangeListen implements ViewPager.OnPageChangeListener{
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            switch (position){
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    }
}
