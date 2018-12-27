package com.linkstar.app.guide.ui.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.linkstar.app.guide.R;
import com.linkstar.app.guide.base.BaseActivity;
import com.linkstar.app.guide.model.entity.InviteHistory;
import com.linkstar.app.guide.ui.adapter.InviteHistoryAdapter;
import com.linkstar.app.guide.widget.LoadingView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class InviteHistoryActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener{

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.load_view)
    LoadingView loadView;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;

    //数据源
    private List<InviteHistory> list = new ArrayList<>();
    private InviteHistoryAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_invite_history;
    }

    @Override
    public void initView() {

        setToolBarTitle("邀请记录");

        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light
                , android.R.color.holo_orange_light, android.R.color.holo_green_light);

        initAdapter();

    }

    private void initAdapter(){
        for (int i = 0 ; i < 10 ; i ++){
            list.add(new InviteHistory());
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new InviteHistoryAdapter(R.layout.item_invite_history , list);
        recyclerView.setAdapter(adapter);
        adapter.openLoadAnimation();
    }
    @Override
    public void onRefresh() {

    }
}
