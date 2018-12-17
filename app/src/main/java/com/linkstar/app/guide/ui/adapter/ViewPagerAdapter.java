package com.linkstar.app.guide.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

import com.linkstar.app.guide.ui.fragment.WorkFragment;
import com.linkstar.app.guide.ui.fragment.CustomerFragment;
import com.linkstar.app.guide.ui.fragment.HomeFragment;
import com.linkstar.app.guide.ui.fragment.MessageFragment;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        fragments.clear();
        fragments.add(HomeFragment.newInstance());
        fragments.add(WorkFragment.newInstance());
        fragments.add(MessageFragment.newInstance());
        fragments.add(CustomerFragment.newInstance());
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return PagerAdapter.POSITION_NONE;
    }


    @Override
    public int getCount() {
        return fragments.size();
    }
}
