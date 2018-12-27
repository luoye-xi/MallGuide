package com.linkstar.app.guide.ui.fragment;


import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.linkstar.app.guide.R;
import com.linkstar.app.guide.base.BaseFragment;
import com.linkstar.app.guide.model.entity.CouponBean;
import com.linkstar.app.guide.model.entity.HomeGoodsBean;
import com.linkstar.app.guide.ui.adapter.CouponAdapter;
import com.linkstar.app.guide.ui.adapter.HomeGoodsAdapter;
import com.linkstar.app.guide.widget.LoadingView;
import com.linkstar.app.guide.widget.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.linkstar.app.guide.util.Constants.OPEN_BY_COUPON;

public class CouponFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener , BaseQuickAdapter.OnItemChildClickListener{

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.load_view)
    LoadingView loadView;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;

    //数据源
    private List<CouponBean> list = new ArrayList<>();
    private CouponAdapter adapter;

    private int openType;

    public CouponFragment() {
        // Required empty public constructor
    }

    public static CouponFragment newInstance(int position) {
        CouponFragment fragment = new CouponFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position" , position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_coupon;
    }

    @Override
    public void initView() {

        assert getArguments() != null;
        openType = getArguments().getInt("position" , -1);

        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light
                , android.R.color.holo_orange_light, android.R.color.holo_green_light);

        initAdapter();

    }

    private void initAdapter(){
        for (int i = 0 ; i < 10 ; i ++){
            list.add(new CouponBean());
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new CouponAdapter(R.layout.item_coupon , list , openType);
        recyclerView.setAdapter(adapter);
        adapter.openLoadAnimation();
        adapter.setOnItemChildClickListener(this);
    }

    @Override
    public void onRefresh() {
        //刷新

    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        //立即发放点击事件

    }
}
