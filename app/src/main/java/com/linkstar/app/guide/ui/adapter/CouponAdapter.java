package com.linkstar.app.guide.ui.adapter;

import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.linkstar.app.guide.R;
import com.linkstar.app.guide.model.entity.CouponBean;

import java.util.List;

import static com.linkstar.app.guide.util.Constants.OPEN_BY_COUPON_HISTORY;

public class CouponAdapter extends BaseQuickAdapter<CouponBean, BaseViewHolder>{

    private int openType;

    public CouponAdapter(int layoutResId, @Nullable List<CouponBean> data , int openType) {
        super(layoutResId, data);
        this.openType = openType;
    }

    @Override
    protected void convert(BaseViewHolder helper, CouponBean item) {

        if(openType == OPEN_BY_COUPON_HISTORY){
            helper.getView(R.id.tv_publish).setVisibility(View.GONE);
        }

        helper.addOnClickListener(R.id.tv_publish);

    }
}
