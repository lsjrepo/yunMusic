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
 * Created by finnfu on 16/5/5.
 */
public class MainFragment3 extends Fragment {
    private ViewPager mainViewPager3;
    private MainFragmentAdapter_3 adapter;
    private TabPageIndicator mIndicator3 ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.mainfragment3, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mainViewPager3 = (ViewPager) getActivity().findViewById(R.id.mainFragment_pager3);
        //初始化放在onActivityCreated,不放在onResume中,这里不会重复调
        mainViewPager3.setCurrentItem(0);
        //使用getChildFragmentManager,而不用getActivity().getSupportFragmentManager()
        // 可以保持Fragment中数据不丢失,Fragment嵌套Fragment时要注意
        adapter = new MainFragmentAdapter_3(getChildFragmentManager());
        mainViewPager3.setAdapter(adapter);
        mIndicator3 =  (TabPageIndicator) getActivity().findViewById(R.id.id_indicator3);
        mIndicator3.setViewPager(mainViewPager3, 0);
        mIndicator3.setOnPageChangeListener(new MyOnPageChangeListen());
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
               default:
                   break;

            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    }
}
