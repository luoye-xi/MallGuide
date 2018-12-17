package com.linkstar.app.guide.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.linkstar.app.guide.R;
import com.linkstar.app.guide.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class CustomerFragment extends BaseFragment {


    @BindView(R.id.tv_servicing_count)
    TextView tvServicingCount;
    @BindView(R.id.tv_transfer_count)
    TextView tvTransferCount;

    public static CustomerFragment newInstance() {
        CustomerFragment fragment = new CustomerFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_customer;
    }

    @Override
    public void initView() {

    }

    @Override
    protected void loadData() {

    }

    @OnClick({R.id.tv_invite_vip, R.id.rl_servicing, R.id.ri_transfer
            , R.id.rl_customer_group, R.id.tv_customer_characteristic, R.id.tv_vouchers})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_invite_vip:
                //邀请会员
                break;
            case R.id.rl_servicing:
                //服务中的顾客
                break;
            case R.id.ri_transfer:
                //已转移的顾客
                break;
            case R.id.rl_customer_group:
                //顾客分组
                break;
            case R.id.tv_customer_characteristic:
                //顾客特征分析
                break;
            case R.id.tv_vouchers:
                //发放券
                break;
        }
    }
}
