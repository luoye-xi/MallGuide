package com.linkstar.app.guide.ui.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.linkstar.app.guide.R;
import com.linkstar.app.guide.base.BaseActivity;
import com.linkstar.app.guide.model.entity.CouponBean;
import com.linkstar.app.guide.ui.adapter.CouponAdapter;
import com.linkstar.app.guide.widget.LoadingView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import static com.linkstar.app.guide.util.Constants.OPEN_BY_COUPON_HISTORY;

public class CouponHistoryActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.load_view)
    LoadingView loadView;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;

    //数据源
    private List<CouponBean> list = new ArrayList<>();
    private CouponAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_coupon_history;
    }

    @Override
    public void initView() {
        setToolBarTitle("发放记录");

        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light
                , android.R.color.holo_orange_light, android.R.color.holo_green_light);

        initAdapter();

    }

    private void initAdapter() {
        for (int i = 0; i < 10; i++) {
            list.add(new CouponBean());
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CouponAdapter(R.layout.item_coupon, list, OPEN_BY_COUPON_HISTORY);
        recyclerView.setAdapter(adapter);
        adapter.openLoadAnimation();
    }

    @Override
    public void onRefresh() {

    }
}
