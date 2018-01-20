package com.tangbba.androidsampleproject.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by orochi77 on 2018-01-20.
 */

public class CategoryRecyclerView extends LinearLayout {

    private static final String TAG = "CategoryRecyclerView";

    private View mRootView;
    private RecyclerView mRecyclerView;

    public CategoryRecyclerView(Context context) {
        this(context, null);
    }

    public CategoryRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CategoryRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeView();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        updateView();
    }

    private void initializeView() {

    }

    private void updateView() {

    }
}
