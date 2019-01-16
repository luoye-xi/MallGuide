package com.linkstar.app.guide.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.ViewGroup;

import com.linkstar.app.guide.ui.fragment.InviteVipFragment;

import java.util.List;

public class TabAdapter extends FragmentPagerAdapter {

    private List<String> list;
    private List<Fragment> fragmentList;

    public TabAdapter(FragmentManager fm, List<String> list , List<Fragment> fragmentList) {
        super(fm);
        this.list = list;
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        return (InviteVipFragment) super.instantiateItem(container, position);
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
