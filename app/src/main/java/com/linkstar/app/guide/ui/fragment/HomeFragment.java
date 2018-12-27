package com.linkstar.app.guide.ui.fragment;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.linkstar.app.guide.R;
import com.linkstar.app.guide.base.BaseFragment;
import com.linkstar.app.guide.model.entity.HomeGoodsBean;
import com.linkstar.app.guide.ui.activity.GoodsDetailActivity;
import com.linkstar.app.guide.ui.adapter.HomeGoodsAdapter;
import com.linkstar.app.guide.util.GlideUtil;
import com.linkstar.app.guide.util.StartActivityUtil;
import com.linkstar.app.guide.widget.LoadingView;
import com.linkstar.app.guide.widget.SpaceItemDecoration;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeFragment extends BaseFragment implements BaseQuickAdapter.RequestLoadMoreListener
        , SwipeRefreshLayout.OnRefreshListener , BaseQuickAdapter.OnItemChildClickListener , BaseQuickAdapter.OnItemClickListener{

    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.load_view)
    LoadingView loadView;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;

    //数据源
    private List<HomeGoodsBean> list = new ArrayList<>();

    //图片数据源
    private List<String> imgList = new ArrayList<>();

    //adapter
    private HomeGoodsAdapter adapter;

    private int page = 1;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView() {

        imgList.add("http://pic.58pic.com/58pic/17/29/00/39658PICknp_1024.jpg");
        imgList.add("http://pic65.nipic.com/file/20150425/13839354_210311767000_2.jpg");
        imgList.add("http://img.zcool.cn/community/013d5b56fe13946ac725794803ca4e.jpg");

        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light
                , android.R.color.holo_orange_light, android.R.color.holo_green_light);

        initAdapter();

        setBanner();
    }

    @Override
    protected void loadData() {

    }

    private void initAdapter(){
        for (int i = 0 ; i < 5 ; i ++){
            list.add(new HomeGoodsBean(1));
        }

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new SpaceItemDecoration(10));
        adapter = new HomeGoodsAdapter(R.layout.item_home_goods , list);
        recyclerView.setAdapter(adapter);
        adapter.openLoadAnimation();
        adapter.setOnLoadMoreListener(this, recyclerView);
        adapter.setOnItemChildClickListener(this);
        adapter.setOnItemClickListener(this);
//        adapter.disableLoadMoreIfNotFullPage();
    }

    private void setBanner(){
        //设置内置样式，共有六种可以点入方法内逐一体验使用。
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器，图片加载器在下方
        banner.setImageLoader(new BannerLoader());
        //设置图片网址或地址的集合
        banner.setImages(imgList);
        //设置轮播的动画效果，内含多种特效，可点入方法内查找后内逐一体验
        banner.setBannerAnimation(Transformer.Default);
        //设置轮播间隔时间
        banner.setDelayTime(3000);
        //设置是否为自动轮播，默认是“是”。
        banner.isAutoPlay(true);
        //设置指示器的位置，小点点，左中右。
        banner.setIndicatorGravity(BannerConfig.CENTER).start();
    }

    @Override
    public void onLoadMoreRequested() {
        //加载更过回调
        refreshLayout.setEnabled(false);

        if(page < 2 ){

            List<HomeGoodsBean> data = new ArrayList<>();
            for (int i = 0 ; i < 5 ; i ++){
                data.add(new HomeGoodsBean(1));
            }

            adapter.addData(data);
            adapter.loadMoreComplete();
            page ++ ;
        }else {
            adapter.loadMoreEnd();
        }

        refreshLayout.setEnabled(true);
    }

    @Override
    public void onRefresh() {
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        //列表item子view点击事件   在此即分享的点击事件
        ShareFragment fragment = new ShareFragment();
        fragment.show(getChildFragmentManager() , "1");
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        //item 点击事件 跳转到商品详情页面
        StartActivityUtil.start(getActivity() , GoodsDetailActivity.class);
    }

    //自定义的图片加载器
    private class BannerLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            GlideUtil.load( getActivity() , (String) path , imageView );
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (banner == null) return;
        if (isVisibleToUser) {
            banner.startAutoPlay();
        } else {
            banner.stopAutoPlay();
        }
    }

}
