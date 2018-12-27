package com.linkstar.app.guide.ui.adapter;

import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.linkstar.app.guide.R;
import com.linkstar.app.guide.model.entity.CouponBean;
import com.linkstar.app.guide.model.entity.GoodsDataBean;

import java.util.List;

import static com.linkstar.app.guide.util.Constants.OPEN_BY_COUPON_HISTORY;

public class GoodsDataAdapter extends BaseQuickAdapter<GoodsDataBean, BaseViewHolder> {


    public GoodsDataAdapter(int layoutResId, @Nullable List<GoodsDataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GoodsDataBean item) {
        helper.setText(R.id.tv_name, "A2白金幼儿配方奶粉(3段)900G")
                .setText(R.id.tv_price, "￥428.00")
                .setText(R.id.tv_sale_count, "19")
                .setText(R.id.tv_browse_count, "19")
                .setText(R.id.tv_collect_count, "19");


    }
}
