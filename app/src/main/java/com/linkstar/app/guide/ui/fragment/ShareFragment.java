package com.linkstar.app.guide.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.linkstar.app.guide.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class ShareFragment extends BottomSheetDialogFragment {

    @BindView(R.id.tv_get_money)
    TextView tvGetMoney;
    @BindView(R.id.tv_info)
    TextView tvInfo;

    //赏金
    private int money;

    private Unbinder unbind;

    public ShareFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        money = Integer.parseInt(getTag());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_share, null);
        unbind = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbind.unbind();
    }

    @OnClick({R.id.ll_more_pic, R.id.ll_wechat, R.id.ll_circle, R.id.ll_qrcode, R.id.ll_sms, R.id.ll_copy, R.id.tv_ok})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_more_pic:
                //多图分享
                break;
            case R.id.ll_wechat:
                //微信好友
                break;
            case R.id.ll_circle:
                //朋友圈
                break;
            case R.id.ll_qrcode:
                //二维码
                break;
            case R.id.ll_sms:
                //短信
                break;
            case R.id.ll_copy:
                //复制连接
                break;
            case R.id.tv_ok:
                //知道了
                break;
        }
        dismiss();
    }

}
