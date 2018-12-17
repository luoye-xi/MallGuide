package com.linkstar.app.guide.ui.activity;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.ielse.imagewatcher.ImageWatcherHelper;
import com.gyf.barlibrary.ImmersionBar;
import com.linkstar.app.guide.R;
import com.linkstar.app.guide.app.MyApplication;
import com.linkstar.app.guide.model.entity.HomeGoodsBean;
import com.linkstar.app.guide.model.entity.ShopperSayBean;
import com.linkstar.app.guide.ui.adapter.ShopperSayAdapter;
import com.linkstar.app.guide.util.ActivityTransitionUtil;
import com.linkstar.app.guide.widget.GradationScrollView;
import com.linkstar.app.guide.widget.LoadingDialog;
import com.linkstar.app.guide.widget.LoadingView;
import com.linkstar.app.guide.widget.MessagePicturesLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

public class ShopperSayActivity extends SwipeBackActivity implements GradationScrollView.ScrollViewListener , MessagePicturesLayout.Callback{

    @BindView(R.id.iv_head)
    AppCompatImageView ivHead;
    @BindView(R.id.tv_shop_name)
    TextView tvShopName;
    @BindView(R.id.tv_shop_des)
    TextView tvShopDes;
    @BindView(R.id.tv_be_focus)
    TextView tvBeFocus;
    @BindView(R.id.tv_be_good)
    TextView tvBeGood;
    @BindView(R.id.tv_dynamic_count)
    TextView tvDynamicCount;
    @BindView(R.id.rl_bg)
    RelativeLayout rlBg;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.load_view)
    LoadingView loadView;
    @BindView(R.id.scrollview)
    GradationScrollView scrollview;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.all_load)
    LoadingView allLoad;

    private ImmersionBar mImmersionBar; //沉浸式
    private Unbinder unbinder;
    private Context context;
    private LoadingDialog dialog;

    private int height;//背景图高度

    //图片点击放大
    private ImageWatcherHelper iwHelper;

    private List<ShopperSayBean> list = new ArrayList<>();//数据源
    private ShopperSayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopper_say);

        unbinder = ButterKnife.bind(this);

        context = MyApplication.getContext();

        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.init();

        initView();
    }

    private void initView() {

        initListeners();
        initList();

    }

    private void initList(){
        //初始化recyclerView

        //  **************  动态 addView   **************
        iwHelper = ImageWatcherHelper.with(this, new GlideSimpleLoader()) // 一般来讲， ImageWatcher 需要占据全屏的位置
                .setErrorImageRes(R.mipmap.error_picture);// 配置error图标 如果不介意使用lib自带的图标，并不一定要调用这个API

        for (int i = 0 ; i < 5 ; i ++){
            list.add(new ShopperSayBean());
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        adapter = new ShopperSayAdapter(R.layout.item_shopper_say , list , this);
        adapter.openLoadAnimation();
        recyclerView.setAdapter(adapter);
    }

    private void initListeners() {
        //标题栏根据滑动的x 渐变
        ViewTreeObserver vto = rlBg.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                rlTitle.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                height = rlBg.getHeight();

                scrollview.setScrollViewListener(ShopperSayActivity.this);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mImmersionBar != null)
            mImmersionBar.destroy();

        if (unbinder != null)
            unbinder.unbind();
    }

    @OnClick({R.id.iv_back, R.id.iv_share, R.id.tv_message})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                break;
            case R.id.iv_share:
                break;
            case R.id.tv_message:
                break;
        }
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

    @Override
    public void onThumbPictureClick(ImageView i, SparseArray<ImageView> imageGroupList, List<Uri> urlList) {
        //图片点击放大点击事件
        iwHelper.show(i, imageGroupList, urlList);
    }

    @Override
    public void onBackPressed() {
        if (!iwHelper.handleBackPressed()) {
            super.onBackPressed();
            ActivityTransitionUtil.finishActivityTransition(this);
        }
    }
}
