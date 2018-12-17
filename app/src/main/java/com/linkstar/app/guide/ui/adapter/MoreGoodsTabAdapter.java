package com.linkstar.app.guide.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.ViewGroup;

import com.linkstar.app.guide.ui.fragment.GoodsInfoFragment;
import com.linkstar.app.guide.ui.fragment.MoreGoodsFragment;

import java.util.List;

public class MoreGoodsTabAdapter extends FragmentPagerAdapter {

    private List<String> list;

    public MoreGoodsTabAdapter(FragmentManager fm, List<String> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return MoreGoodsFragment.newInstance();
    }

    @NonNull
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return (MoreGoodsFragment) super.instantiateItem(container, position);
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return PagerAdapter.POSITION_NONE;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
}
