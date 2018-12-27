package com.linkstar.app.guide.ui.adapter;

import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.linkstar.app.guide.R;
import com.linkstar.app.guide.model.entity.CouponBean;
import com.linkstar.app.guide.model.entity.InviteHistory;

import java.util.List;

import static com.linkstar.app.guide.util.Constants.OPEN_BY_COUPON_HISTORY;

public class InviteHistoryAdapter extends BaseQuickAdapter<InviteHistory, BaseViewHolder>{

    public InviteHistoryAdapter(int layoutResId, @Nullable List<InviteHistory> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, InviteHistory item) {
        helper.setText(R.id.tv_name , "流年")
                .setText(R.id.tv_time , "邀请时间：2018-12-12  12:00");

    }
}
