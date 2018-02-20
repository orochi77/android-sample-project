package com.tangbba.androidsampleproject;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;

/**
 * Created by orochi77 on 2018-02-19.
 */

public class MyTabLayout extends TabLayout {

    private OnScrollChangeListener mOnScrollChangeListener;

    public MyTabLayout(Context context) {
        super(context);
    }

    public MyTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public interface OnScrollChangeListener {
        void onScrollChange(HorizontalScrollView horizontalScrollView, int l, int t, int oldl, int oldt);
    }


}
