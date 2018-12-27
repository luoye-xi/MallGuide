package com.linkstar.app.guide.ui.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;
import com.linkstar.app.guide.R;
import com.linkstar.app.guide.base.BaseActivity;
import com.linkstar.app.guide.ui.adapter.InviteVipTabAdapter;
import com.linkstar.app.guide.ui.adapter.OrderTabAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomerOrderActivity extends BaseActivity {

    @BindView(R.id.sliding_tab)
    SlidingTabLayout slidingTab;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_customer_order;
    }

    @Override
    public void initView() {

        getToolbarTitle().setText("订单管理");

        List<String> tabList = new ArrayList<>();
        tabList.add("全部");
        tabList.add("待付款");
        tabList.add("待发货");
        tabList.add("待收货");
        tabList.add("待评价");
        OrderTabAdapter adapter = new OrderTabAdapter(getSupportFragmentManager(), tabList);
        viewpager.setAdapter(adapter);
        slidingTab.setViewPager(viewpager);

        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if( i == 0 ){
                    setSwipeBackEnable(true);
                }else {
                    setSwipeBackEnable(false);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }
}
