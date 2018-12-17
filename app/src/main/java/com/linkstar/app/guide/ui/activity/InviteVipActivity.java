package com.linkstar.app.guide.ui.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.flyco.tablayout.SlidingTabLayout;
import com.linkstar.app.guide.R;
import com.linkstar.app.guide.base.BaseActivity;
import com.linkstar.app.guide.ui.adapter.GoodsInfoTabAdapter;
import com.linkstar.app.guide.ui.adapter.InviteVipTabAdapter;
import com.linkstar.app.guide.ui.fragment.InviteVipFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InviteVipActivity extends BaseActivity {

    @BindView(R.id.sliding_tab)
    SlidingTabLayout slidingTab;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_invite_vip;
    }

    @Override
    public void initView() {

        getToolbarTitle().setText("邀请会员");

        List<String> tabList = new ArrayList<>();
        tabList.add("下载APP");
        tabList.add("关注公众号");
        InviteVipTabAdapter adapter = new InviteVipTabAdapter(getSupportFragmentManager(), tabList);
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

    @OnClick({R.id.iv_invite_history, R.id.iv_invite_explain})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_invite_history:
                //邀请记录
                break;
            case R.id.iv_invite_explain:
                //邀请说明
                break;
        }
    }
}
