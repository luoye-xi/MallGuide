package com.linkstar.app.guide.ui.fragment;


import android.graphics.Color;
import android.net.Uri;
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
import com.linkstar.app.guide.R;
import com.linkstar.app.guide.base.BaseFragment;
import com.linkstar.app.guide.model.entity.ShopperSayBean;
import com.linkstar.app.guide.util.GlideSimpleLoader;
import com.linkstar.app.guide.ui.adapter.ShopperSayAdapter;
import com.linkstar.app.guide.widget.GradationScrollView;
import com.linkstar.app.guide.widget.LoadingView;
import com.linkstar.app.guide.widget.MessagePicturesLayout;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.OnClick;

public class ShopperDynamicFragment extends BaseFragment implements GradationScrollView.ScrollViewListener , MessagePicturesLayout.Callback{

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

    private int height;//背景图高度

    //图片点击放大
    private ImageWatcherHelper iwHelper;

    private List<ShopperSayBean> list = new ArrayList<>();//数据源
    private ShopperSayAdapter adapter;

    public ShopperDynamicFragment() {
        // Required empty public constructor
    }

    public static ShopperDynamicFragment newInstance(){
        ShopperDynamicFragment fragment = new ShopperDynamicFragment();
        return fragment;
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_shopper_dynamic;
    }

    @Override
    public void initView() {
        initListeners();
        initList();
    }

    @OnClick({R.id.iv_back, R.id.iv_share, R.id.tv_message})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                EventBus.getDefault().post(1);
                break;
            case R.id.iv_share:
                //搜索

                break;
            case R.id.tv_message:
                //分享

                break;
        }
    }

    private void initList(){
        //初始化recyclerView

        //  **************  动态 addView   **************
        iwHelper = ImageWatcherHelper.with(Objects.requireNonNull(getActivity()), new GlideSimpleLoader()) // 一般来讲， ImageWatcher 需要占据全屏的位置
                .setErrorImageRes(R.mipmap.error_picture);// 配置error图标 如果不介意使用lib自带的图标，并不一定要调用这个API

        for (int i = 0 ; i < 5 ; i ++){
            list.add(new ShopperSayBean());
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
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

                scrollview.setScrollViewListener(ShopperDynamicFragment.this);
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

    @Override
    public void onThumbPictureClick(ImageView i, SparseArray<ImageView> imageGroupList, List<Uri> urlList) {
        //图片点击放大点击事件
        iwHelper.show(i, imageGroupList, urlList);
    }
}
