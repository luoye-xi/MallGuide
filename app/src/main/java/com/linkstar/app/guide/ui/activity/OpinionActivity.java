package com.linkstar.app.guide.ui.activity;

import android.os.Bundle;
import android.widget.EditText;

import com.linkstar.app.guide.R;
import com.linkstar.app.guide.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OpinionActivity extends BaseActivity {

    @BindView(R.id.et_content)
    EditText etContent;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_opinion;
    }

    @Override
    public void initView() {

        getToolbarTitle().setText("意见反馈");
        getSubTitle().setText("提交");

    }

    @OnClick(R.id.toolbar_subtitle)
    public void onViewClicked() {
        //提交
    }
}
