package com.linkstar.app.guide.ui.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.linkstar.app.guide.R;
import com.linkstar.app.guide.base.BaseActivity;
import com.linkstar.app.guide.model.entity.WithdrawalRecordBean;
import com.linkstar.app.guide.ui.adapter.WithdrawalRecordAdapter;
import com.linkstar.app.guide.widget.LoadingView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class WithdrawalRecordActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener{

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.load_view)
    LoadingView loadView;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;

    //数据源
    private List<WithdrawalRecordBean> list = new ArrayList<>();
    private WithdrawalRecordAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_withdrawal_record;
    }

    @Override
    public void initView() {

        setToolBarTitle("提现记录");

        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light
                , android.R.color.holo_orange_light, android.R.color.holo_green_light);

        initAdapter();
    }

    private void initAdapter(){

        for (int i = 0 ; i < 5 ; i ++){
            list.add(new WithdrawalRecordBean());
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        adapter = new WithdrawalRecordAdapter(R.layout.item_withdrawal_record , list);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onRefresh() {

    }
}
