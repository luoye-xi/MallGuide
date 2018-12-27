package com.linkstar.app.guide.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.linkstar.app.guide.R;
import com.linkstar.app.guide.base.BaseActivity;
import com.linkstar.app.guide.util.StartActivityUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DataAnalysisActivity extends BaseActivity {

    @BindView(R.id.tv_week_visit)
    TextView tvWeekVisit;
    @BindView(R.id.tv_week_order)
    TextView tvWeekOrder;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_data_analysis;
    }

    @Override
    public void initView() {

        getToolbarTitle().setText("数据分析");
    }

    @OnClick({R.id.rl_shop_data, R.id.rl_goods_analysis})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_shop_data:
                //我的微店数据
                break;
            case R.id.rl_goods_analysis:
                //商品分析
                StartActivityUtil.start(this , GoodsDataActivity.class);
                break;
        }
    }
}
