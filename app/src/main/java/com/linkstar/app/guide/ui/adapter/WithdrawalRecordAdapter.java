package com.linkstar.app.guide.ui.adapter;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.linkstar.app.guide.R;
import com.linkstar.app.guide.model.entity.GuideInformationBean;
import com.linkstar.app.guide.model.entity.WithdrawalRecordBean;
import com.linkstar.app.guide.util.GlideUtil;

import java.util.List;

public class WithdrawalRecordAdapter extends BaseQuickAdapter<WithdrawalRecordBean, BaseViewHolder> {


    public WithdrawalRecordAdapter(int layoutResId, @Nullable List<WithdrawalRecordBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, WithdrawalRecordBean item) {
        helper.setText(R.id.tv_bank , "提现到招商银行卡")
                .setText(R.id.tv_time , "2018-12-12  12:00:12")
                .setText(R.id.tv_money , "+12.00");

    }

}
