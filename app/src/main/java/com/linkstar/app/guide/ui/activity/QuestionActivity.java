package com.linkstar.app.guide.ui.activity;

import com.linkstar.app.guide.R;
import com.linkstar.app.guide.base.BaseActivity;

public class QuestionActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_question;
    }

    @Override
    public void initView() {

        setToolBarTitle("常见问题");

    }
}
