package com.linkstar.app.guide.ui.adapter;

import android.app.Activity;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.linkstar.app.guide.R;
import com.linkstar.app.guide.model.entity.HomeGoodsBean;
import com.linkstar.app.guide.widget.MessagePicturesLayout;

import java.util.List;

public class HomeGoodsAdapter extends BaseQuickAdapter<HomeGoodsBean, BaseViewHolder>{

    public HomeGoodsAdapter(int layoutResId, @Nullable List<HomeGoodsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeGoodsBean item) {

        helper.addOnClickListener(R.id.iv_share);

    }
}
