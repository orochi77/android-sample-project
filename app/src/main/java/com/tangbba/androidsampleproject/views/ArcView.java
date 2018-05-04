package com.tangbba.androidsampleproject.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class ArcView extends View {

    private static final int START_ANGLE = 135;
    private int mSweepAngle = 270;

    private int[] colors = {
            Color.RED,
            Color.WHITE,
            Color.GREEN,
            Color.BLACK,
            Color.YELLOW,
            Color.BLUE
    };
    private float[] positions = {
            0.0f, 0.2f, 0.4f, 0.6f, 0.8f, 1.0f
    };
    private final Paint arcPaint;
    private final Paint centerCirclePaint;
    private final RectF mOval;
    private final RectF mClipOval;
    private final Path mClipPath;

    public ArcView(Context context) {
        this(context, null);
    }

    public ArcView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        arcPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        arcPaint.setStyle(Paint.Style.STROKE);
        arcPaint.setStrokeWidth(40);
        arcPaint.setStrokeCap(Paint.Cap.ROUND);

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
        int circleSize = Math.min(getWidth() - 20, getHeight() - 20);
        int clipSize = (int) (circleSize * 0.85);
        int clipPosition = (circleSize - clipSize) / 2;

        mOval.left = 20;
        mOval.top = 20;
        mOval.right = circleSize;
        mOval.bottom = circleSize;

        mClipOval.left = clipPosition * 2;
        mClipOval.top = clipPosition * 2;
        mClipOval.right = clipSize;
        mClipOval.bottom = clipSize;

        arcPaint.setShader(new LinearGradient(0, 0, getWidth(), 0, colors, positions, Shader.TileMode.CLAMP));

        canvas.save();
//        canvas.clipPath(mClipPath, Region.Op.XOR);
//        canvas.drawArc(mClipOval, START_ANGLE, mSweepAngle, true, centerCirclePaint);
        canvas.drawArc(mOval, START_ANGLE, mSweepAngle, false, arcPaint);
//        canvas.drawCircle(circleSize / 2, circleSize / 2, clipSize / 2 + 10, centerCirclePaint);
        canvas.restore();
    }
}
