package com.linkstar.app.guide.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationViewPager;
import com.linkstar.app.guide.R;
import com.linkstar.app.guide.base.BaseActivity;
import com.linkstar.app.guide.ui.adapter.ViewPagerAdapter;
import com.linkstar.app.guide.widget.LoadingDialog;
import com.linkstar.app.guide.widget.LoadingView;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.view_pager)
    AHBottomNavigationViewPager viewPager;
    @BindView(R.id.bottom_navigation)
    AHBottomNavigation bottomNavigation;

    private ArrayList<AHBottomNavigationItem> bottomNavigationItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

        setSwipeBackEnable(false);

        AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.tab_home, R.drawable.icon_home, R.color.colorBottomNavigationActiveColored);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.tab_work, R.drawable.icon_workbench, R.color.colorBottomNavigationActiveColored);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.tab_message, R.drawable.icon_message, R.color.colorBottomNavigationActiveColored);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem(R.string.tab_customer, R.drawable.icon_customer, R.color.colorBottomNavigationActiveColored);

        bottomNavigationItems.add(item1);
        bottomNavigationItems.add(item2);
        bottomNavigationItems.add(item3);
        bottomNavigationItems.add(item4);

        bottomNavigation.addItems(bottomNavigationItems);
        bottomNavigation.setForceTitlesDisplay(true);
        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));
        bottomNavigation.setAccentColor(Color.parseColor("#f76f6f"));
        bottomNavigation.setInactiveColor(Color.parseColor("#C0C0C0"));

        viewPager.setOffscreenPageLimit(4);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));

        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {

                viewPager.setCurrentItem(position, false);
                return true;
            }
        });

    }
}
