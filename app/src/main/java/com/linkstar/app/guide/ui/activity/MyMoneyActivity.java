package com.linkstar.app.guide.ui.activity;

import android.view.View;
import android.widget.TextView;

import com.linkstar.app.guide.R;
import com.linkstar.app.guide.base.BaseActivity;
import com.linkstar.app.guide.ui.fragment.BankFragment;
import com.linkstar.app.guide.util.StartActivityUtil;

import butterknife.BindView;
import butterknife.OnClick;

import static com.linkstar.app.guide.util.Constants.CLICK_BY_ADD_BANK;

public class MyMoneyActivity extends BaseActivity implements BankFragment.OnClickListener{

    @BindView(R.id.tv_can_carry)
    TextView tvCanCarry;
    @BindView(R.id.tv_carried)
    TextView tvCarried;
    @BindView(R.id.tv_not_in)
    TextView tvNotIn;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_money;
    }

    @Override
    public void initView() {

        getToolbarTitle().setText("我的佣金");

    }

    @OnClick({R.id.iv_invite_history, R.id.iv_invite_explain, R.id.btn_apply})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_invite_history:
                //提现记录
                StartActivityUtil.start(this , WithdrawalRecordActivity.class);
                break;
            case R.id.iv_invite_explain:
                //说明
                break;
            case R.id.btn_apply:
                //申请提现
                BankFragment fragment = new BankFragment();
                fragment.setClickListener(this);
                fragment.show(getSupportFragmentManager() , "");
                break;
        }
    }

    @Override
    public void onClick(int position, int clickType) {
        if( clickType == CLICK_BY_ADD_BANK ){
            StartActivityUtil.start(this , AddBankActivity.class);
        }
    }
}
