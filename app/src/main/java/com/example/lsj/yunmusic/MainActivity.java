package com.example.lsj.yunmusic;

import android.app.SearchManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private ArrayAdapter arrayAdapter;
    private String[] lvs = {"签到","我的消息", "积分商城", "付费音乐包", "在线听歌免流量","听歌识曲","主题换肤","夜间模式","定时停止播放","音乐闹钟","我的音乐云盘"};
    private ListView lvLeftMenu;
    private ImageButton toolBarBtn1;
    private ImageButton toolBarBtn2;
    private ImageButton toolBarBtn3;

    private ViewPager mainViewPager;
    private MainFragmentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar boolBar = (Toolbar)findViewById(R.id.tl_custom);
        boolBar.setTitle("");
        mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_left);
        lvLeftMenu = (ListView) findViewById(R.id.lv_left_menu);
        toolBarBtn1= (ImageButton) findViewById(R.id.toolbar_btn1);
        toolBarBtn2= (ImageButton) findViewById(R.id.toolbar_btn2);
        toolBarBtn3= (ImageButton) findViewById(R.id.toolbar_btn3);

        mainViewPager = (ViewPager) findViewById(R.id.mainPager);
        adapter = new MainFragmentAdapter(this.getSupportFragmentManager());
        mainViewPager.setAdapter(adapter);
        mainViewPager.setCurrentItem(0);
        mainViewPager.setOnPageChangeListener(new MyOnPageChangeListen());

        toolBarBtn1.setOnClickListener(onClickListener);
        toolBarBtn2.setOnClickListener(onClickListener);
        toolBarBtn3.setOnClickListener(onClickListener);
        setSupportActionBar(boolBar);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, boolBar, R.string.open, R.string.close)
        {
            @Override
            public void onDrawerOpened(View drawerView)
            {
                super.onDrawerOpened(drawerView);
            }
            @Override
            public void onDrawerClosed(View drawerView)
            {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        //设置菜单列表
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lvs);
        lvLeftMenu.setAdapter(arrayAdapter);
        updateToolBarUi(0);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
        {

            Window mWindow = getWindow();
            mWindow.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            mWindow.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

            SystemBarTintManager mSystemBarTintManager = new SystemBarTintManager(this);
            mSystemBarTintManager.setStatusBarTintEnabled(true);
            mSystemBarTintManager.setNavigationBarTintEnabled(true);
            mSystemBarTintManager.setTintColor(Color.parseColor("#DC1E00"));
        }

    }
    private View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.toolbar_btn1:
                    updateToolBarUi(0);
                    mainViewPager.setCurrentItem(0);
                    break;
                case R.id.toolbar_btn2:
                    updateToolBarUi(1);
                    mainViewPager.setCurrentItem(1);
                    break;
                case R.id.toolbar_btn3:
                    updateToolBarUi(2);
                    mainViewPager.setCurrentItem(3);
                    break;
                default:
                    break;


            }
        }
    };
    private class MyOnPageChangeListen implements ViewPager.OnPageChangeListener{
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            updateToolBarUi(position);

        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    }
    private void updateToolBarUi(int index) {
        switch (index) {
            case 0:
                toolBarBtn1.setBackgroundResource(R.drawable.toolbar_discover_normal);
                toolBarBtn2.setBackgroundResource(R.drawable.toolbar_music_selected);
                toolBarBtn3.setBackgroundResource(R.drawable.toolbar_friends_selected);
                break;
            case 1:
                toolBarBtn1.setBackgroundResource(R.drawable.toolbar_discover_selected);
                toolBarBtn2.setBackgroundResource(R.drawable.toolbar_music_normal);
                toolBarBtn3.setBackgroundResource(R.drawable.toolbar_friends_selected);
                break;
            case 2:
                toolBarBtn1.setBackgroundResource(R.drawable.toolbar_discover_selected);
                toolBarBtn2.setBackgroundResource(R.drawable.toolbar_music_selected);
                toolBarBtn3.setBackgroundResource(R.drawable.toolbar_friends_normal);
                break;
            default:
                break;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));
        return true;
    }

}

