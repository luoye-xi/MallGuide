package com.linkstar.app.guide.ui.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.linkstar.app.guide.R;
import com.linkstar.app.guide.base.BaseFragment;
import com.linkstar.app.guide.ui.activity.ShopperSayActivity;
import com.linkstar.app.guide.widget.GradationScrollView;
import com.linkstar.app.guide.widget.LoadingView;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class AllGoodsFragment extends BaseFragment implements GradationScrollView.ScrollViewListener {

    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.iv_head)
    AppCompatImageView ivHead;
    @BindView(R.id.tv_shop_name)
    TextView tvShopName;
    @BindView(R.id.tv_shop_des)
    TextView tvShopDes;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.load_view)
    LoadingView loadView;
    @BindView(R.id.scrollview)
    GradationScrollView scrollview;
    @BindView(R.id.rl_bg)
    RelativeLayout rlBg;

    private ImmersionBar mImmersionBar; //沉浸式
    private int height;//背景图高度

    public AllGoodsFragment() {
        // Required empty public constructor
    }

    public static AllGoodsFragment newInstance() {
        AllGoodsFragment fragment = new AllGoodsFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_all_goods;
    }

    @Override
    public void initView() {

        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.init();

    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mImmersionBar != null)
            mImmersionBar.destroy();  //必须调用该方法，防止内存泄漏，不调用该方法，如果界面bar发生改变，在不关闭app的情况下，退出此界面再进入将记忆最后一次bar改变的状态
    }

    @OnClick({R.id.iv_back, R.id.iv_search, R.id.tv_share, R.id.tv_default, R.id.ll_sale, R.id.tv_recommend, R.id.tv_brand})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                //返回
                EventBus.getDefault().post(1);
                break;
            case R.id.iv_search:
                break;
            case R.id.tv_share:
                break;
            case R.id.tv_default:
                break;
            case R.id.ll_sale:
                break;
            case R.id.tv_recommend:
                break;
            case R.id.tv_brand:
                break;
        }
    }

    private void initListeners() {
        //标题栏根据滑动的x 渐变
        ViewTreeObserver vto = rlBg.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                rlTitle.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                height = rlBg.getHeight();

                scrollview.setScrollViewListener(AllGoodsFragment.this);
            }
        });
    }

    @Override
    public void onScrollChanged(GradationScrollView scrollView, int x, int y, int oldx, int oldy) {
        if (y <= 10) {   //设置标题的背景颜色
            rlTitle.setBackgroundColor(Color.parseColor("#00000000"));

        } else if ( y <= height ) { //滑动距离小于banner图的高度时，设置背景和字体颜色颜色透明度渐变
            float scale = (float) y / height;
            float alpha = (255 * scale);
            rlTitle.setBackgroundColor(Color.argb((int) alpha, 144, 151, 166));
        }
    }
}
