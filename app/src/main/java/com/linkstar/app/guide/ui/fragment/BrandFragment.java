package com.linkstar.app.guide.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.linkstar.app.guide.R;
import com.linkstar.app.guide.base.BaseFragment;

public class BrandFragment extends BaseFragment {


    public BrandFragment() {
        // Required empty public constructor
    }

    public static BrandFragment newInstance(){
        BrandFragment fragment = new BrandFragment();
        return fragment;
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_brand;
    }

    @Override
    public void initView() {

    }
}
