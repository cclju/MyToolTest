package com.mytooltest.progress.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;


public class RoundCornerImageView extends android.support.v7.widget.AppCompatImageView {

    private float mRadius = 18;
    private Path mClipPath = new Path();
    private RectF mRect = new RectF();

    public RoundCornerImageView(Context context) {
        super(context);
    }

    public RoundCornerImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RoundCornerImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setRadiusDp(float dp) {
        mRadius = dp2px(dp, getResources());
        postInvalidate();
    }

    public void setRadiusPx(int px) {
        mRadius = px;
        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mRect.set(0, 0, this.getWidth(), this.getHeight());
        mClipPath.reset(); // 每次绘制都切割一次圆角 记得调用Path.reset()方法
        mClipPath.addRoundRect(mRect, mRadius, mRadius, Path.Direction.CW); // 沿顺时针方向绘制
        canvas.clipPath(mClipPath);
        super.onDraw(canvas);
    }

    private float dp2px(float value, Resources resources) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, resources.getDisplayMetrics());
    }
}
