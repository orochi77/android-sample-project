package com.tangbba.androidsampleproject;

import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class BackgroundSpannableTextView extends AppCompatTextView {

    @ColorInt
    protected int mBackgroundColor;

    public BackgroundSpannableTextView(Context context) {
        super(context);
    }

    public BackgroundSpannableTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BackgroundSpannableTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public int getBackgroundColor() {
        return mBackgroundColor;
    }

    @Override
    public void setBackgroundColor(int backgroundColor) {
        mBackgroundColor = backgroundColor;
        invalidate();
    }
}
