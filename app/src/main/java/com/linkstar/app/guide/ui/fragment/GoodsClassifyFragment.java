package com.linkstar.app.guide.ui.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;
import com.linkstar.app.guide.R;
import com.linkstar.app.guide.base.BaseFragment;
import com.linkstar.app.guide.ui.adapter.TabAdapter;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class GoodsClassifyFragment extends BaseFragment {

    @BindView(R.id.sliding_tab)
    SlidingTabLayout slidingTab;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    public GoodsClassifyFragment() {
        // Required empty public constructor
    }

    public static GoodsClassifyFragment newInstance() {
        GoodsClassifyFragment fragment = new GoodsClassifyFragment();
        return fragment;
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_goods_classify;
    }

    @Override
    public void initView() {
        List<String> tabList = new ArrayList<>();
        tabList.add("分类");
        tabList.add("品牌");

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(ClassifyFragment.newInstance());
        fragments.add(BrandFragment.newInstance());

        TabAdapter adapter = new TabAdapter(getChildFragmentManager(), tabList , fragments);
        viewpager.setAdapter(adapter);
        slidingTab.setViewPager(viewpager);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        EventBus.getDefault().post(1);
    }
}
