package com.linkstar.app.guide.ui.adapter;

import android.net.Uri;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.linkstar.app.guide.R;
import com.linkstar.app.guide.model.entity.ShopperSayBean;
import com.linkstar.app.guide.widget.MessagePicturesLayout;

import java.util.ArrayList;
import java.util.List;

public class ShopperSayAdapter extends BaseQuickAdapter<ShopperSayBean , BaseViewHolder>{

    private MessagePicturesLayout.Callback callback;

    public ShopperSayAdapter(int layoutResId, @Nullable List<ShopperSayBean> data , MessagePicturesLayout.Callback callback) {
        super(layoutResId, data);
        this.callback = callback;
    }

    @Override
    protected void convert(BaseViewHolder helper, ShopperSayBean item) {

        MessagePicturesLayout picLayout = helper.getView(R.id.pic_layout);
        picLayout.setCallback(callback);
        List<Uri> uriList = new ArrayList<>();
        uriList.add(Uri.parse("http://pic.58pic.com/58pic/17/29/00/39658PICknp_1024.jpg"));
        uriList.add(Uri.parse("http://pic65.nipic.com/file/20150425/13839354_210311767000_2.jpg"));
        picLayout.set(uriList , uriList);

    }
}
