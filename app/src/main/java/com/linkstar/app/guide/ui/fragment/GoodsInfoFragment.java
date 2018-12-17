package com.linkstar.app.guide.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.linkstar.app.guide.R;

public class GoodsInfoFragment extends Fragment {

    public GoodsInfoFragment() {
        // Required empty public constructor
    }

    public static GoodsInfoFragment newInstance(){
        GoodsInfoFragment fragment = new GoodsInfoFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_goods_info, container, false);
    }

}
