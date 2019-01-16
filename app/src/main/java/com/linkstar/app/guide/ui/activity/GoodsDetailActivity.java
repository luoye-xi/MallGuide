package com.linkstar.app.guide.ui.activity;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.flyco.tablayout.SlidingTabLayout;
import com.github.ielse.imagewatcher.ImageWatcherHelper;
import com.gyf.barlibrary.ImmersionBar;
import com.linkstar.app.guide.R;
import com.linkstar.app.guide.app.MyApplication;
import com.linkstar.app.guide.model.entity.EvaluateBean;
import com.linkstar.app.guide.ui.adapter.EvaluateAdapter;
import com.linkstar.app.guide.ui.adapter.GoodsInfoTabAdapter;
import com.linkstar.app.guide.ui.adapter.MoreGoodsTabAdapter;
import com.linkstar.app.guide.util.ActivityTransitionUtil;
import com.linkstar.app.guide.util.GlideSimpleLoader;
import com.linkstar.app.guide.widget.GradationScrollView;
import com.linkstar.app.guide.widget.LoadingDialog;
import com.linkstar.app.guide.widget.MessagePicturesLayout;
import com.linkstar.app.guide.widget.ViewPagerForScrollView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class GoodsDetailActivity extends AppCompatActivity implements GradationScrollView.ScrollViewListener
        , MessagePicturesLayout.Callback{

    @BindView(R.id.info_sliding_tab)
    SlidingTabLayout infoSlidingTab;
    @BindView(R.id.info_viewpager)
    ViewPager infoViewpager;
    @BindView(R.id.banner)
    AppCompatImageView banner;
    @BindView(R.id.scrollview)
    GradationScrollView scrollview;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.tv_good_name)
    TextView tvGoodName;
    @BindView(R.id.iv_favorite)
    AppCompatImageView ivFavorite;
    @BindView(R.id.tv_favorite)
    TextView tvFavorite;
    @BindView(R.id.ll_favorite)
    LinearLayout llFavorite;
    @BindView(R.id.tv_des)
    TextView tvDes;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.tv_postage)
    TextView tvPostage;
    @BindView(R.id.tv_return)
    TextView tvReturn;
    @BindView(R.id.rl_support)
    RelativeLayout rlSupport;
    @BindView(R.id.tv_vouchers1)
    TextView tvVouchers1;
    @BindView(R.id.tv_vouchers2)
    TextView tvVouchers2;
    @BindView(R.id.rl_get_vouchers)
    LinearLayout rlGetVouchers;
    @BindView(R.id.tv_select)
    TextView tvSelect;
    @BindView(R.id.rl_evaluate)
    RelativeLayout rlEvaluate;
    @BindView(R.id.recycler_evaluate)
    RecyclerView recyclerEvaluate;
    @BindView(R.id.iv_shop_img)
    AppCompatImageView ivShopImg;
    @BindView(R.id.tv_good_count)
    TextView tvGoodCount;
    @BindView(R.id.tv_good_satisfaction)
    TextView tvGoodSatisfaction;
    @BindView(R.id.tv_service_satisfaction)
    TextView tvServiceSatisfaction;
    @BindView(R.id.tv_logistics_satisfaction)
    TextView tvLogisticsSatisfaction;
    @BindView(R.id.sliding_tab)
    SlidingTabLayout slidingTab;
    @BindView(R.id.more_view_pager)
    ViewPagerForScrollView moreViewPager;
    @BindView(R.id.ll_more_goods)
    LinearLayout llMoreGoods;
    @BindView(R.id.tv_add)
    TextView tvAdd;
    @BindView(R.id.tv_buy)
    TextView tvBuy;
    @BindView(R.id.tv_evaluate_count)
    TextView tvEvaluateCount;

    private ImmersionBar mImmersionBar; //沉浸式
    private Unbinder unbinder;
    private LoadingDialog dialog;

    //评论列表adapter
    private EvaluateAdapter evaluateAdapter;
    //评论数据源
    private List<EvaluateBean> evaluateBeanList = new ArrayList<>();

    private int height;//banner高度

    //图片点击放大
    private ImageWatcherHelper iwHelper;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_detail);
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.init();
        unbinder = ButterKnife.bind(this);
        initView();
    }

    private void initView() {

        context = MyApplication.getContext();

        LoadingDialog.Builder loadBuilder = new LoadingDialog.Builder(this)
                .setMessage("加载中...")
                .setCancelable(true)
                .setCancelOutside(false);
        dialog = loadBuilder.create();

        //  **************  动态 addView   **************
        iwHelper = ImageWatcherHelper.with(this, new GlideSimpleLoader()) // 一般来讲， ImageWatcher 需要占据全屏的位置
                .setErrorImageRes(R.mipmap.error_picture);// 配置error图标 如果不介意使用lib自带的图标，并不一定要调用这个API

        initListeners();
        initEvaluateList();
        initMoreGoodsTab();
        initInfoTab();
    }

    private void initEvaluateList(){
        //初始化评论recyclerView

        evaluateBeanList.add(new EvaluateBean());
        evaluateBeanList.add(new EvaluateBean());

        recyclerEvaluate.setLayoutManager(new LinearLayoutManager(context));
        evaluateAdapter = new EvaluateAdapter(context , this , evaluateBeanList);
        recyclerEvaluate.setAdapter(evaluateAdapter);
    }

    private void initListeners() {
        //标题栏根据滑动的x 渐变
        ViewTreeObserver vto = banner.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                rlTitle.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                height = banner.getHeight();

                scrollview.setScrollViewListener(GoodsDetailActivity.this);
            }
        });
    }

    private void initInfoTab() {
        //初始化图文详情tab
        List<String> infoTabList = new ArrayList<>();
        infoTabList.add("商品介绍");
        infoTabList.add("规格参数");
        infoTabList.add("包装售后");
        GoodsInfoTabAdapter adapter = new GoodsInfoTabAdapter(getSupportFragmentManager(), infoTabList);
        infoViewpager.setAdapter(adapter);
        infoSlidingTab.setViewPager(infoViewpager);
    }

    private void initMoreGoodsTab() {
        //初始化更多商品tab
        List<String> moreTabList = new ArrayList<>();
        moreTabList.add("为你推荐");
        moreTabList.add("大家都在看");
        MoreGoodsTabAdapter adapter = new MoreGoodsTabAdapter(getSupportFragmentManager(), moreTabList);
        moreViewPager.setAdapter(adapter);
        slidingTab.setViewPager(moreViewPager);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mImmersionBar != null)
            mImmersionBar.destroy();  //必须调用该方法，防止内存泄漏，不调用该方法，如果界面bar发生改变，在不关闭app的情况下，退出此界面再进入将记忆最后一次bar改变的状态

        if (unbinder != null)
            unbinder.unbind();
    }

    @Override
    public void onScrollChanged(GradationScrollView scrollView, int x, int y, int oldx, int oldy) {
        if (y <= 10) {   //设置标题的背景颜色
            tvTitle.setBackgroundColor(Color.parseColor("#00000000"));
            rlTitle.setBackgroundColor(Color.parseColor("#00000000"));

        } else if (y > 0 && y <= height) { //滑动距离小于banner图的高度时，设置背景和字体颜色颜色透明度渐变
            float scale = (float) y / height;
            float alpha = (255 * scale);
            tvTitle.setTextColor(Color.argb((int) alpha, 255, 255, 255));
            rlTitle.setBackgroundColor(Color.argb((int) alpha, 144, 151, 166));
        }
//        else {    //滑动到banner下面设置普通颜色
//            tvTitle.setBackgroundColor(Color.argb((int) 255, 144, 151, 166));
//            rlTitle.setBackgroundColor(Color.argb((int) 255, 144, 151, 166));
//        }
    }

    @OnClick({R.id.ll_favorite, R.id.rl_support, R.id.rl_get_vouchers, R.id.rl_select
            , R.id.ll_evaluate, R.id.tv_go_shop, R.id.rl_service, R.id.rl_shop_cart
            , R.id.tv_add, R.id.tv_buy, R.id.iv_back, R.id.iv_share})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_favorite:
                //收藏
                break;
            case R.id.rl_support:
                //支持  例如包邮
                break;
            case R.id.rl_get_vouchers:
                //优惠券
                break;
            case R.id.rl_select:
                //打开sku的fragment
                break;
            case R.id.ll_evaluate:
                //查看全部评价
                break;
            case R.id.tv_go_shop:
                //进店逛逛
                break;
            case R.id.rl_service:
                //客服
                break;
            case R.id.rl_shop_cart:
                //购物车
                break;
            case R.id.tv_add:
                //加入购物车
                break;
            case R.id.tv_buy:
                //立即购买
                break;
            case R.id.iv_back:
                //返回
                onBackPressed();
                break;
            case R.id.iv_share:
                //分享
                break;
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
