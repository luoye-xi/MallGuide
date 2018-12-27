package com.linkstar.app.guide.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.linkstar.app.guide.model.entity.MyResultsBean;

import java.util.List;

public class MyResultsAdapter extends BaseQuickAdapter<MyResultsBean, BaseViewHolder>{

    public MyResultsAdapter(int layoutResId, @Nullable List<MyResultsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyResultsBean item) {

    }
}
