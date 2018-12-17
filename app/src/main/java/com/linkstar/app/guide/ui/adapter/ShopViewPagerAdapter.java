package com.linkstar.app.guide.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

import com.linkstar.app.guide.ui.fragment.AllGoodsFragment;
import com.linkstar.app.guide.ui.fragment.ContactShopperFragment;
import com.linkstar.app.guide.ui.fragment.CustomerFragment;
import com.linkstar.app.guide.ui.fragment.GoodsClassifyFragment;
import com.linkstar.app.guide.ui.fragment.HomeFragment;
import com.linkstar.app.guide.ui.fragment.MessageFragment;
import com.linkstar.app.guide.ui.fragment.ShopperDynamicFragment;
import com.linkstar.app.guide.ui.fragment.WorkFragment;

import java.util.ArrayList;
import java.util.List;

public class ShopViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments = new ArrayList<>();

    public ShopViewPagerAdapter(FragmentManager fm) {
        super(fm);
        fragments.clear();
        fragments.add(AllGoodsFragment.newInstance());
        fragments.add(ShopperDynamicFragment.newInstance());
        fragments.add(GoodsClassifyFragment.newInstance());
        fragments.add(ContactShopperFragment.newInstance());
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
