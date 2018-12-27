package com.linkstar.app.guide.ui.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.linkstar.app.guide.R;
import com.linkstar.app.guide.app.MyApplication;
import com.linkstar.app.guide.base.BaseFragment;
import com.linkstar.app.guide.ui.activity.SMSInviteActivity;
import com.linkstar.app.guide.util.StartActivityUtil;
import com.linkstar.app.guide.util.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class InviteVipFragment extends BaseFragment {

    @BindView(R.id.iv_code)
    AppCompatImageView ivCode;
    @BindView(R.id.iv_img1)
    AppCompatImageView ivImg1;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.ll_download)
    LinearLayout llDownload;
    @BindView(R.id.iv_img2)
    AppCompatImageView ivImg2;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.ll_sms)
    LinearLayout llSms;
    @BindView(R.id.ll_share)
    LinearLayout llShare;
    @BindView(R.id.tv_info1)
    TextView tvInfo1;
    @BindView(R.id.tv_info2)
    TextView tvInfo2;
    Unbinder unbinder;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_des)
    TextView tvDes;

    private int index;//fragment下标 0  下载APP  和 1 关注公众号

    private Context context;

    public InviteVipFragment() {
        // Required empty public constructor
    }

    public static InviteVipFragment newInstance(int position) {
        InviteVipFragment fragment = new InviteVipFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
            index = getArguments().getInt("position", -1);
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_invite_vip;
    }

    @Override
    public void initView() {

        context = MyApplication.getContext();

        ivCode.setImageBitmap(Utils.createQRImage("111111", Utils.dip2px(context, 193), Utils.dip2px(context, 193)));

        if (index == 1) {
            //关注公众号
            tv1.setText("分享二维码");
            tv2.setText("关注明细");
            tvInfo1.setVisibility(View.VISIBLE);
            tvInfo2.setVisibility(View.VISIBLE);
            llShare.setVisibility(View.GONE);
            tvTitle.setText("扫码关注微信公众号");
            tvDes.setVisibility(View.GONE);
        }

    }

    @OnClick({R.id.ll_download, R.id.ll_sms, R.id.ll_share})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_download:
                //下标为0时为直接下载APP 为1时分享二维码

                break;
            case R.id.ll_sms:
                //下标为0时为短信邀请 为1时关注明细
                if(index == 0 ){
                    StartActivityUtil.start(getActivity() , SMSInviteActivity.class);
                }else {

                }
                break;
            case R.id.ll_share:
                //下标为0时为分享链接邀请 为1时隐藏

                break;
        }
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
}
