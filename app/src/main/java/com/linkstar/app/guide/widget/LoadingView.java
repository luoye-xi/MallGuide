package com.linkstar.app.guide.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.linkstar.app.guide.R;
import com.wang.avi.AVLoadingIndicatorView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoadingView extends FrameLayout {
    @BindView(R.id.tv_tips)
    TextView tvTips;
    @BindView(R.id.iv_img)
    ImageView imageView;
    @BindView(R.id.av_view)
    AVLoadingIndicatorView avView;

    private Context context;

    public LoadingView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public LoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public LoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    private void init() {
        if (isInEditMode())
            return;
        View view = LayoutInflater.from(context).inflate(R.layout.widge_loading, this, true);
        ButterKnife.bind(view);

    }

    public void loadError() {
        setVisibility(VISIBLE);
        tvTips.setVisibility(VISIBLE);
        imageView.setVisibility(VISIBLE);
        tvTips.setText("网络异常");
        imageView.setImageResource(R.drawable.icon_network_error);
    }

    public void noData(int resId,int tipsId) {
        setVisibility(VISIBLE);
        tvTips.setVisibility(VISIBLE);
        imageView.setVisibility(VISIBLE);
        avView.hide();
        tvTips.setText(context.getString(tipsId));
        imageView.setImageResource(resId);
    }

    public void noData(int resId,String text) {
        setVisibility(VISIBLE);
        tvTips.setVisibility(VISIBLE);
        imageView.setVisibility(VISIBLE);
        avView.hide();
        tvTips.setText(text);
        imageView.setImageResource(resId);
    }

    public void setGone() {
        setVisibility(GONE);
    }

    public void loading() {
        setVisibility(VISIBLE);
        avView.show();
        tvTips.setVisibility(GONE);
        imageView.setVisibility(GONE);
    }

}