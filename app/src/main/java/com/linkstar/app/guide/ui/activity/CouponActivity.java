package com.linkstar.app.guide.ui.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;
import com.linkstar.app.guide.R;
import com.linkstar.app.guide.base.BaseActivity;
import com.linkstar.app.guide.ui.adapter.CouponTabAdapter;
import com.linkstar.app.guide.util.StartActivityUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CouponActivity extends BaseActivity {

    @BindView(R.id.sliding_tab)
    SlidingTabLayout slidingTab;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_coupon;
    }

    @Override
    public void initView() {

        setToolBarTitle("发放券");
        getSubTitle().setText("发放记录");

        List<String> tabList = new ArrayList<>();
        tabList.add("可发放");
        tabList.add("历史");
        CouponTabAdapter adapter = new CouponTabAdapter(getSupportFragmentManager(), tabList);
        viewpager.setAdapter(adapter);
        slidingTab.setViewPager(viewpager);

        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if (i == 0) {
                    setSwipeBackEnable(true);
                } else {
                    setSwipeBackEnable(false);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }

    @OnClick(R.id.toolbar_subtitle)
    public void onViewClicked() {
        //发送记录
        StartActivityUtil.start(this , CouponHistoryActivity.class);
    }
}
