package com.linkstar.app.guide.ui.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.linkstar.app.guide.R;
import com.linkstar.app.guide.base.BaseActivity;
import com.linkstar.app.guide.model.entity.GuideInformationBean;
import com.linkstar.app.guide.model.entity.HomeGoodsBean;
import com.linkstar.app.guide.ui.adapter.GuideInfoAdapter;
import com.linkstar.app.guide.widget.LoadingView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GuideInformationActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener{

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.load_view)
    LoadingView loadView;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;

    //数据源
    private List<GuideInformationBean> list = new ArrayList<>();
    private GuideInfoAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_guide_information;
    }

    @Override
    public void initView() {

        getToolbarTitle().setText("导购资讯");

        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light
                , android.R.color.holo_orange_light, android.R.color.holo_green_light);

        initAdapter();
    }

    private void initAdapter(){

        for (int i = 0 ; i < 5 ; i ++){
            list.add(new GuideInformationBean());
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        adapter = new GuideInfoAdapter(R.layout.item_information , list , this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onRefresh() {
        refreshLayout.setRefreshing(false);

        list.clear();
        for (int i = 0 ; i < 2 ; i ++){
            list.add(new GuideInformationBean());
        }

        adapter.setNewData(list);

    }
}
