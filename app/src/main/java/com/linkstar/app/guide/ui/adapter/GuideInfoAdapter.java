package com.linkstar.app.guide.ui.adapter;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.linkstar.app.guide.R;
import com.linkstar.app.guide.model.entity.GuideInformationBean;
import com.linkstar.app.guide.util.GlideUtil;

import java.util.List;

public class GuideInfoAdapter extends BaseQuickAdapter<GuideInformationBean , BaseViewHolder> {

    private Activity activity;

    public GuideInfoAdapter(int layoutResId, @Nullable List<GuideInformationBean> data , Activity activity) {
        super(layoutResId, data);
        this.activity = activity;
    }

    @Override
    protected void convert(BaseViewHolder helper, GuideInformationBean item) {

        GlideUtil.loadRectangle(activity , "http://pic.58pic.com/58pic/17/29/00/39658PICknp_1024.jpg" , (ImageView) helper.getView(R.id.iv_img));

    }

}
