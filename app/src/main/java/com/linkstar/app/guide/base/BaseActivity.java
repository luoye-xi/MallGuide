package com.linkstar.app.guide.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.linkstar.app.guide.R;
import com.linkstar.app.guide.app.AppManager;
import com.linkstar.app.guide.app.MyApplication;
import com.linkstar.app.guide.util.ActivityTransitionUtil;
import com.linkstar.app.guide.widget.LoadingDialog;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

public abstract class BaseActivity extends SwipeBackActivity implements BaseView {

    private ImmersionBar mImmersionBar; //沉浸式

    private TextView mToolbarTitle;
    private TextView mToolbarSubTitle;
    private Toolbar mToolbar;

    private Unbinder unbinder;

    public Context context;

    public LoadingDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        //
        AppManager.getAppManager().addActivity(this);

        unbinder = ButterKnife.bind(this);

        context = MyApplication.getContext();

        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.statusBarColor(R.color.color_white)
                .statusBarAlpha(0.2f)
                .statusBarDarkFont(true, 0.2f)
                .init();

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
       /*
        toolbar.setLogo(R.mipmap.ic_launcher_app);
        toolbar.setTitle("Title");
        toolbar.setSubtitle("Sub Title");
        */
        mToolbarTitle = (TextView) findViewById(R.id.toolbar_title);
        mToolbarSubTitle = (TextView) findViewById(R.id.toolbar_subtitle);
        if (mToolbar != null) {
            //将Toolbar显示到界面
            setSupportActionBar(mToolbar);
        }
        if (mToolbarTitle != null) {
            //getTitle()的值是activity的android:lable属性值
            mToolbarTitle.setText(getTitle());
            //设置默认的标题不显示
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        LoadingDialog.Builder loadBuilder=new LoadingDialog.Builder(this)
                .setMessage("加载中...")
                .setCancelable(true)
                .setCancelOutside(false);
        dialog = loadBuilder.create();

        initView();

    }

    @Override
    protected void onStart() {
        super.onStart();
        /**
         * 判断是否有Toolbar,并默认显示返回按钮
         */
        if (null != getToolbar() && isShowBacking()) {
            showBack();
        }
    }

    /**
     * 获取头部标题的TextView
     *
     * @return
     */
    public TextView getToolbarTitle() {
        return mToolbarTitle;
    }

    /**
     * 获取头部标题的TextView
     *
     * @return
     */
    public TextView getSubTitle() {
        return mToolbarSubTitle;
    }

    /**
     * 设置头部标题
     *
     * @param title
     */
    public void setToolBarTitle(CharSequence title) {
        if (mToolbarTitle != null) {
            mToolbarTitle.setText(title);
        } else {
            getToolbar().setTitle(title);
            setSupportActionBar(getToolbar());
        }
    }

    /**
     * this Activity of tool bar.
     * 获取头部.
     *
     * @return support.v7.widget.Toolbar.
     */
    public Toolbar getToolbar() {
        return (Toolbar) findViewById(R.id.toolbar);
    }

    /**
     * 版本号小于21的后退按钮图片
     */
    private void showBack() {
        //setNavigationIcon必须在setSupportActionBar(toolbar);方法后面加入
        getToolbar().setNavigationIcon(R.drawable.icon_back);
        getToolbar().setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    /**
     * 是否显示后退按钮,默认显示,可在子类重写该方法.
     *
     * @return
     */
    protected boolean isShowBacking() {
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ActivityTransitionUtil.finishActivityTransition(this);
    }

    /**
     * this activity layout res
     * 设置layout布局,在子类重写该方法.
     *
     * @return res layout xml id
     */
    protected abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mImmersionBar != null)
            mImmersionBar.destroy();  //必须调用该方法，防止内存泄漏，不调用该方法，如果界面bar发生改变，在不关闭app的情况下，退出此界面再进入将记忆最后一次bar改变的状态

        if (unbinder != null)
            unbinder.unbind();
    }

    public void setActivityResult(Activity activity, Bundle bundle) {
        Intent resultIntent = new Intent();
        resultIntent.putExtras(bundle);
        activity.setResult(RESULT_OK, resultIntent);
        activity.finish();
    }


}
