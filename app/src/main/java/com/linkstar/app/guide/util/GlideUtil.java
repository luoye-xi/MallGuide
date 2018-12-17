package com.linkstar.app.guide.util;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.linkstar.app.guide.R;
import com.linkstar.app.guide.util.glide.GlideCircleTransform;
import com.linkstar.app.guide.util.glide.GlideRoundTransform;

public class GlideUtil {

    private static GlideCircleTransform circleTransform;
    private static GlideRoundTransform roundTransform;

    /**
     * 初始化transform
     *
     * @param context context
     * @return transform
     */
    public static GlideCircleTransform transform(Context context) {
        if (circleTransform == null) {
            circleTransform = new GlideCircleTransform();
        }
        return circleTransform;
    }

    /**
     * 初始化transform
     *
     * @param context context
     * @return transform
     */
    public static GlideRoundTransform transform(Context context, int dp) {
        if (roundTransform == null) {
            roundTransform = new GlideRoundTransform(context, dp);
        }
        return roundTransform;
    }

    /**
     * 加载圆角缩略图
     *
     * @param activity  activity
     * @param url       url
     * @param imageView view
     * @param dp        圆角dp
     */
    public static void loadRound(Activity activity, String url, ImageView imageView, int dp) {

        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.img_linkstar_blank)  //加载成功之前占位图
                .error(R.drawable.img_linkstar_blank)    //加载错误之后的错误图
                .override(400, 400)  //指定图片的尺寸
                //指定图片的缩放类型为fitCenter （等比例缩放图片，宽或者是高等于ImageView的宽或者是高。）
                .fitCenter()
                //指定图片的缩放类型为centerCrop （等比例缩放图片，直到图片的狂高都大于等于ImageView的宽度，然后截取中间的显示。）
                .transform(transform(activity, dp))
                .skipMemoryCache(true)  //跳过内存缓存
                .diskCacheStrategy(DiskCacheStrategy.ALL)   //缓存所有版本的图像
                .diskCacheStrategy(DiskCacheStrategy.NONE)  //跳过磁盘缓存
                .diskCacheStrategy(DiskCacheStrategy.DATA)  //只缓存原来分辨率的图片
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)  //只缓存最终的图片
                ;

        Glide.with(activity)
                .load(url == null ? "" : url)
                .apply(options)
                .into(imageView);
    }

    /**
     * 加载头像url
     *
     * @param context   context
     * @param url       url
     * @param imageView view
     */
    public static void loadHead(Context context, String url, ImageView imageView) {

        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.personal_img)  //加载成功之前占位图
                .error(R.drawable.personal_img)    //加载错误之后的错误图
                .override(400, 400)  //指定图片的尺寸
                //指定图片的缩放类型为fitCenter （等比例缩放图片，宽或者是高等于ImageView的宽或者是高。）
                .fitCenter()
                .circleCrop()//指定图片的缩放类型为centerCrop （圆形）
                .transform(transform(context))
                .skipMemoryCache(true)  //跳过内存缓存
                .diskCacheStrategy(DiskCacheStrategy.ALL)   //缓存所有版本的图像
                .diskCacheStrategy(DiskCacheStrategy.NONE)  //跳过磁盘缓存
                .diskCacheStrategy(DiskCacheStrategy.DATA)  //只缓存原来分辨率的图片
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)  //只缓存最终的图片
                ;


        Glide.with(context)
                .load(url == null ? "" : url)
                .apply(options)
                .into(imageView);
    }

    /**
     * 加载正方形缩略图
     *
     * @param activity  activity
     * @param url       url
     * @param imageView view
     */
    public static void load(Activity activity, String url, ImageView imageView) {

        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.img_linkstar_blank)  //加载成功之前占位图
                .error(R.drawable.img_linkstar_blank)    //加载错误之后的错误图
                .override(400, 400)  //指定图片的尺寸
                //指定图片的缩放类型为fitCenter （等比例缩放图片，宽或者是高等于ImageView的宽或者是高。）
                .fitCenter()
                .skipMemoryCache(true)  //跳过内存缓存
                .diskCacheStrategy(DiskCacheStrategy.ALL)   //缓存所有版本的图像
                .diskCacheStrategy(DiskCacheStrategy.NONE)  //跳过磁盘缓存
                .diskCacheStrategy(DiskCacheStrategy.DATA)  //只缓存原来分辨率的图片
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)  //只缓存最终的图片
                ;

        Glide.with(activity)
                .load(url == null ? "" : url)
                .apply(options)
                .into(imageView);
    }

    /**
     * 加载长方形缩略图
     *
     * @param activity  activity
     * @param url       url
     * @param imageView view
     */
    public static void loadRectangle(Activity activity, String url, ImageView imageView) {

        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.img_linkstar_blank)  //加载成功之前占位图
                .error(R.drawable.img_linkstar_blank)    //加载错误之后的错误图
                .override(400, 400)  //指定图片的尺寸
                //指定图片的缩放类型为fitCenter （等比例缩放图片，宽或者是高等于ImageView的宽或者是高。）
                .fitCenter()
                .skipMemoryCache(true)  //跳过内存缓存
                .diskCacheStrategy(DiskCacheStrategy.ALL)   //缓存所有版本的图像
                .diskCacheStrategy(DiskCacheStrategy.NONE)  //跳过磁盘缓存
                .diskCacheStrategy(DiskCacheStrategy.DATA)  //只缓存原来分辨率的图片
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)  //只缓存最终的图片
                ;

        Glide.with(activity)
                .load(url == null ? "" : url)
                .apply(options)
                .into(imageView);
    }

}
