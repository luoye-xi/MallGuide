package com.linkstar.app.guide.util;

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;

/**
 * Toast工具类
 */
public class ToastUtil {

    static Toast toast = null;

    /**
     * 显示短时间的Toast
     *
     * @param context context
     * @param msg     提示内容
     */
    public static void showShortToast(Context context, String msg) {

        try {
            if (toast != null) {
                toast.setText(msg);
            } else {
                toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
            }
            toast.show();
        } catch (Exception e) {
            //解决在子线程中调用Toast的异常情况处理
            Looper.prepare();
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
            Looper.loop();
        }

//        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 显示短时间的Toast
     *
     * @param context context
     * @param resId   提示内容id
     */
    public static void showShortToast(Context context, int resId) {
        Toast.makeText(context, context.getString(resId), Toast.LENGTH_SHORT).show();
    }

    public static void show(Context context, String info) {
        Toast.makeText(context, info, Toast.LENGTH_LONG).show();
    }

    public static void show(Context context, int info) {
        Toast.makeText(context, info, Toast.LENGTH_LONG).show();
    }


}
