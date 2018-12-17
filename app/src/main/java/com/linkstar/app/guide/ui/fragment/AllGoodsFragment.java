package com.linkstar.app.guide.ui.fragment;


import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.linkstar.app.guide.R;
import com.linkstar.app.guide.base.BaseFragment;
import com.linkstar.app.guide.widget.GradationScrollView;
import com.linkstar.app.guide.widget.LoadingView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class AllGoodsFragment extends BaseFragment {

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

    private ImmersionBar mImmersionBar; //沉浸式

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
                //
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
}
