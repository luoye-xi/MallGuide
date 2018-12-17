package com.linkstar.app.guide.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * 正方形的ImageView
 *
 * @author Uncle Liu
 * @since 2018/04/19
 */
public class SquareImageView extends AppCompatImageView {
    public SquareImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public SquareImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareImageView(Context context) {
        super(context);
    }

    @Override
    public void setImageBitmap(Bitmap bm) {
        super.setImageBitmap(bm);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(getDefaultSize(0, widthMeasureSpec), getDefaultSize(0, heightMeasureSpec));

        int childWidthSize = getMeasuredWidth();
        //高度和宽度一样
        heightMeasureSpec = widthMeasureSpec = MeasureSpec.makeMeasureSpec(childWidthSize, MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}


