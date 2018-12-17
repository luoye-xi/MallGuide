package com.linkstar.app.guide.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.linkstar.app.guide.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GoodsClassifyFragment extends Fragment {


    public GoodsClassifyFragment() {
        // Required empty public constructor
    }

    public static GoodsClassifyFragment newInstance(){
        GoodsClassifyFragment fragment = new GoodsClassifyFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_goods_classify, container, false);
    }

}
