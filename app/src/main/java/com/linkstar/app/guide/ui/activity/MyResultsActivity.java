package com.linkstar.app.guide.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.linkstar.app.guide.R;
import com.linkstar.app.guide.base.BaseActivity;
import com.linkstar.app.guide.model.entity.GuideInformationBean;
import com.linkstar.app.guide.model.entity.MyResultsBean;
import com.linkstar.app.guide.ui.adapter.GuideInfoAdapter;
import com.linkstar.app.guide.ui.adapter.MyResultsAdapter;
import com.linkstar.app.guide.widget.LoadingView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyResultsActivity extends BaseActivity {

    @BindView(R.id.tv_month_results)
    TextView tvMonthResults;
    @BindView(R.id.tv_day_results)
    TextView tvDayResults;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.load_view)
    LoadingView loadView;

    //数据源
    private List<MyResultsBean> list = new ArrayList<>();
    private MyResultsAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_results;
    }

    @Override
    public void initView() {

        getToolbarTitle().setText("我的业绩");

        initAdapter();
    }

    private void initAdapter(){
        //初始化recyclerView

        for (int i = 0 ; i < 5 ; i ++){
            list.add(new MyResultsBean());
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        adapter = new MyResultsAdapter(R.layout.item_results , list);
        recyclerView.setAdapter(adapter);

    }

}
