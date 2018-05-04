package com.tangbba.androidsampleproject.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Region;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class DonutView extends View {

    private static final int DEFAULT_FOREGROUND_COLOR = 0xffff0000;
    private static final int DEFAULT_BACKGROUND_COLOR = 0xffa0a0a0;

    private static final int START_ANGLE = 135;
    private static final int SWEEP_ANGLE = 360;

    private final Paint foregroundPaint;
    private int mSweepAngle;

    private final Paint centerCirclePaint;

    private final RectF mOval;
    private final RectF mClipOval;
    private final Path mClipPath;


    public DonutView(Context context) {
        this(context, null);
    }

    public DonutView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DonutView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        foregroundPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        foregroundPaint.setColor(DEFAULT_FOREGROUND_COLOR);
        foregroundPaint.setStyle(Paint.Style.FILL);
        foregroundPaint.setAntiAlias(true);

        centerCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        centerCirclePaint.setColor(0xffffffff);
        centerCirclePaint.setStyle(Paint.Style.FILL);
        centerCirclePaint.setAntiAlias(true);

        mOval = new RectF();
        mClipOval = new RectF();
        mClipPath = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int circleSize = Math.min(getWidth(), getHeight());
        int clipSize = (int) (circleSize * 0.85);
        int clipPosition = (circleSize - clipSize) / 2;

        mOval.left = 0;
        mOval.top = 0;
        mOval.right = circleSize;
        mOval.bottom = circleSize;

        mClipOval.left = clipPosition * 2;
        mClipOval.top = clipPosition * 2;
        mClipOval.right = clipSize;
        mClipOval.bottom = clipSize;

//        mClipPath.addArc(mClipOval, START_ANGLE, SWEEP_ANGLE);

        canvas.save();
        canvas.clipPath(mClipPath, Region.Op.XOR);
//        canvas.drawArc(mClipOval, START_ANGLE, mSweepAngle, true, centerCirclePaint);
        canvas.drawArc(mOval, START_ANGLE, mSweepAngle, true, foregroundPaint);
        canvas.drawCircle(circleSize / 2, circleSize / 2, clipSize / 2, centerCirclePaint);
        canvas.restore();

        super.onDraw(canvas);
    }

    public int getSweepAngle() {
        return mSweepAngle;
    }

    public void setSweepAngle(int sweepAngle) {
        mSweepAngle = sweepAngle;
    }
}
