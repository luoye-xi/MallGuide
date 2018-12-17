package com.linkstar.app.guide.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.linkstar.app.guide.R;

public class ShopperDynamicFragment extends Fragment {

    public ShopperDynamicFragment() {
        // Required empty public constructor
    }

    public static ShopperDynamicFragment newInstance(){
        ShopperDynamicFragment fragment = new ShopperDynamicFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shopper_dynamic, container, false);
    }

}
