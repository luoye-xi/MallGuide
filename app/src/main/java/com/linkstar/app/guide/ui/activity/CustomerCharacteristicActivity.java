package com.linkstar.app.guide.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.linkstar.app.guide.R;
import com.linkstar.app.guide.base.BaseActivity;

public class CustomerCharacteristicActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_customer_characteristic;
    }

    @Override
    public void initView() {

        setToolBarTitle("顾客特征分析");

    }
}
