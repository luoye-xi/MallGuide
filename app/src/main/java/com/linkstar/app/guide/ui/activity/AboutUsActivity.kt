package com.linkstar.app.guide.ui.activity

import com.linkstar.app.guide.BuildConfig
import com.linkstar.app.guide.R
import com.linkstar.app.guide.base.BaseActivity
import kotlinx.android.synthetic.main.activity_about_us.*

class AboutUsActivity : BaseActivity() {

    override fun getLayoutId(): Int = R.layout.activity_about_us

    override fun initView() {

        toolbarTitle.text = "关于小七顾问"

        tv_version.text = "小七顾问v"+BuildConfig.VERSION_NAME

    }

}
