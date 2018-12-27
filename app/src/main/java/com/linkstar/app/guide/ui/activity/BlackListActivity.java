package com.linkstar.app.guide.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.linkstar.app.guide.R;
import com.linkstar.app.guide.base.BaseActivity;

public class BlackListActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_black_list;
    }

    @Override
    public void initView() {

        getToolbarTitle().setText("评论黑名单");
        getSubTitle().setText("完成");

    }
}
