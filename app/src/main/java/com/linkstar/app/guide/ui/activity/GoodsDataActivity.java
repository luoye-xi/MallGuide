package com.linkstar.app.guide.ui.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.linkstar.app.guide.R;
import com.linkstar.app.guide.base.BaseActivity;
import com.linkstar.app.guide.model.entity.CouponBean;
import com.linkstar.app.guide.model.entity.GoodsDataBean;
import com.linkstar.app.guide.ui.adapter.CouponAdapter;
import com.linkstar.app.guide.ui.adapter.GoodsDataAdapter;
import com.linkstar.app.guide.widget.LoadingView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GoodsDataActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener{

    @BindView(R.id.tv_sale)
    TextView tvSale;
    @BindView(R.id.iv_sale)
    AppCompatImageView ivSale;
    @BindView(R.id.view_sale)
    View viewSale;
    @BindView(R.id.tv_browse)
    TextView tvBrowse;
    @BindView(R.id.iv_browse)
    AppCompatImageView ivBrowse;
    @BindView(R.id.view_browse)
    View viewBrowse;
    @BindView(R.id.tv_collect)
    TextView tvCollect;
    @BindView(R.id.iv_collect)
    AppCompatImageView ivCollect;
    @BindView(R.id.view_collect)
    View viewCollect;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.load_view)
    LoadingView loadView;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;

    //数据源
    private List<GoodsDataBean> list = new ArrayList<>();
    private GoodsDataAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_goods_data;
    }

    @Override
    public void initView() {
        //这个页面的代码想想就冗杂...

        setToolBarTitle("最近7天商品数据");

        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light
                , android.R.color.holo_orange_light, android.R.color.holo_green_light);

        initAdapter();

    }

    private void initAdapter(){
        for (int i = 0 ; i < 10 ; i ++){
            list.add(new GoodsDataBean());
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new GoodsDataAdapter(R.layout.item_goods_data , list);
        recyclerView.setAdapter(adapter);
        adapter.openLoadAnimation();
    }

    @OnClick({R.id.rl_sale, R.id.rl_browse, R.id.rl_collect})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_sale:
                //销量点击

                tvSale.setTextColor(getResources().getColor(R.color.main_red));
                tvBrowse.setTextColor(getResources().getColor(R.color.home_title_color));
                tvCollect.setTextColor(getResources().getColor(R.color.home_title_color));

                viewSale.setVisibility(View.VISIBLE);
                viewBrowse.setVisibility(View.GONE);
                viewCollect.setVisibility(View.GONE);

                break;
            case R.id.rl_browse:
                //浏览量点击

                tvBrowse.setTextColor(getResources().getColor(R.color.main_red));
                tvSale.setTextColor(getResources().getColor(R.color.home_title_color));
                tvCollect.setTextColor(getResources().getColor(R.color.home_title_color));

                viewBrowse.setVisibility(View.VISIBLE);
                viewSale.setVisibility(View.GONE);
                viewCollect.setVisibility(View.GONE);

                break;
            case R.id.rl_collect:
                //收藏点击

                tvCollect.setTextColor(getResources().getColor(R.color.main_red));
                tvSale.setTextColor(getResources().getColor(R.color.home_title_color));
                tvBrowse.setTextColor(getResources().getColor(R.color.home_title_color));

                viewCollect.setVisibility(View.VISIBLE);
                viewSale.setVisibility(View.GONE);
                viewBrowse.setVisibility(View.GONE);

                break;
        }
    }

    @Override
    public void onRefresh() {

    }
}
