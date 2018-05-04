package com.tangbba.androidsampleproject.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class BarChart extends View {

    private Paint mXAxisPaint;
    private int mXAxisColor = 0xff000000;
    private int mXAxisStrokeWidth = 4;

    private Paint mBarPaint;
    private int mBarColor = 0xffFF4081;
    private int mBarWidth = 40;

    private int mYDivide = 10;
    private int mXGap;

    private List<Integer> mDataProvider = new ArrayList<>();

    public BarChart(Context context) {
        this(context, null);
    }

    public BarChart(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BarChart(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeView();
    }

    private void initializeView() {
        setupDataProvider();

        mXAxisPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mXAxisPaint.setColor(mXAxisColor);
        mXAxisPaint.setStyle(Paint.Style.FILL);
        mXAxisPaint.setStrokeWidth(mXAxisStrokeWidth);

        mBarPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBarPaint.setColor(mBarColor);
        mBarPaint.setStyle(Paint.Style.FILL);
        mBarPaint.setStrokeWidth(mBarWidth);
    }

    private void calculatePosition() {
        List<Point> startPositions = new ArrayList<>();

        int itemCount = mDataProvider.size();
        int gap = getWidth() / itemCount;
        int halfGap = gap / 2;
        int barVerticalSizeUnit = getHeight() / mYDivide;

        for (int i = 0; i < itemCount; i++) {
            int startX = halfGap + (gap * i);
            int startY = getHeight();
            Point point = new Point(startX, startY);
            startPositions.add(point);
        }
    }

    private void setupDataProvider() {
        mDataProvider = new ArrayList<>();
        mDataProvider.add(3);
        mDataProvider.add(5);
        mDataProvider.add(7);
        mDataProvider.add(2);
        mDataProvider.add(9);
        mDataProvider.add(10);
        mDataProvider.add(0);
        mDataProvider.add(1);
        mDataProvider.add(4);
        mDataProvider.add(7);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        List<Point> startPositions = new ArrayList<>();

        int itemCount = mDataProvider.size();
        int gap = getWidth() / itemCount;
        int halfGap = gap / 2;
        int barVerticalSizeUnit = getHeight() / mYDivide;

        for (int i = 0; i < itemCount; i++) {
            int startX = halfGap + (gap * i);
            int startY = getHeight();
//            Point point = new Point(startX, startY);
//            startPositions.add(point);

            canvas.drawLine(startX, startY, startX, (barVerticalSizeUnit * (mYDivide - mDataProvider.get(i))), mBarPaint);
        }

        canvas.drawLine(0, getHeight(), getWidth(), getHeight(), mXAxisPaint);
    }
}
