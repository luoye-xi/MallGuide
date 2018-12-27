package com.linkstar.app.guide.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.linkstar.app.guide.R;
import com.linkstar.app.guide.base.BaseActivity;

public class InServiceCustomerActivity extends BaseActivity {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_in_servicie_customer;
    }

    @Override
    public void initView() {

        setToolBarTitle("服务中的顾客");
    }
}
