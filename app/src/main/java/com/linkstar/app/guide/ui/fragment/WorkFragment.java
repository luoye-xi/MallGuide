package com.linkstar.app.guide.ui.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.linkstar.app.guide.R;
import com.linkstar.app.guide.base.BaseFragment;
import com.linkstar.app.guide.ui.activity.InviteVipActivity;
import com.linkstar.app.guide.ui.activity.MyShopActivity;
import com.linkstar.app.guide.ui.activity.SettingActivity;
import com.linkstar.app.guide.ui.activity.ShopperSayActivity;
import com.linkstar.app.guide.util.StartActivityUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class WorkFragment extends BaseFragment {


    @BindView(R.id.tv_month_money)
    TextView tvMonthMoney;
    @BindView(R.id.tv_month_count)
    TextView tvMonthCount;
    @BindView(R.id.tv_vip_count)
    TextView tvVipCount;
    @BindView(R.id.tv_promote)
    TextView tvPromote;
    Unbinder unbinder;

    public WorkFragment() {
        // Required empty public constructor
    }

    public static WorkFragment newInstance() {
        WorkFragment fragment = new WorkFragment();
        return fragment;
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_control;
    }

    @Override
    public void initView() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.iv_human, R.id.iv_scan, R.id.ll_my_shop, R.id.ll_shoppers, R.id.ll_invite_vip
            , R.id.ll_info, R.id.ll_my_money, R.id.ll_results, R.id.ll_data_analysis
            , R.id.ll_order, R.id.ll_bank_card, R.id.ll_question, R.id.ll_opinion, R.id.ll_setting})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_human:
                break;
            case R.id.iv_scan:
                break;
            case R.id.ll_my_shop:
                //我的微店
                StartActivityUtil.start(getActivity() , MyShopActivity.class);
                break;
            case R.id.ll_shoppers:
                //导购说
                StartActivityUtil.start(getActivity() , ShopperSayActivity.class);
                break;
            case R.id.ll_invite_vip:
                //邀请会员
                StartActivityUtil.start(getActivity() , InviteVipActivity.class);
                break;
            case R.id.ll_info:
                //导购资讯
                break;
            case R.id.ll_my_money:
                //我的佣金
                break;
            case R.id.ll_results:
                //我的业绩
                break;
            case R.id.ll_data_analysis:
                //数据分析
                break;
            case R.id.ll_order:
                //顾客订单
                break;
            case R.id.ll_bank_card:
                //我的银行卡
                break;
            case R.id.ll_question:
                //常见问题
                break;
            case R.id.ll_opinion:
                //意见反馈
                break;
            case R.id.ll_setting:
                //系统设置
                StartActivityUtil.start(getActivity() , SettingActivity.class);
                break;
        }
    }
}
