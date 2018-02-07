package com.tangbba.androidsampleproject.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.google.common.collect.Lists;
import com.tangbba.androidsampleproject.R;
import com.tangbba.androidsampleproject.adapter.CategoryRecyclerViewAdapter;
import com.tangbba.androidsampleproject.model.Category;

/**
 * Created by orochi77 on 2018-01-20.
 */

public class CategoryView extends LinearLayout {

    private static final String TAG = "CategoryRecyclerView";

    private View mRootView;
    private RecyclerView mRecyclerView;
    private CategoryRecyclerViewAdapter mAdapter;
    private GridLayoutManager mGridLayoutManager;
    private OnCategoryListener mOnCategoryListener;

    public CategoryView(Context context) {
        this(context, null);
    }

    public CategoryView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CategoryView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeView();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setupRecyclerView();
        updateView();
    }

    private void initializeView() {
        mRootView = (LinearLayout) inflate(getContext(), R.layout.category_list_view, this);
        mRecyclerView = (RecyclerView) mRootView.findViewById(R.id.category_recycler_view);
    }

    private void setupRecyclerView() {
        mGridLayoutManager = new GridLayoutManager(getContext(), 4);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        mAdapter = new CategoryRecyclerViewAdapter(getContext(), Lists.newArrayList(Category.getCategory()));
        mAdapter.setOnCategoryItemListener(new CategoryRecyclerViewAdapter.OnCategoryItemListener() {
            @Override
            public void onClickCategoryItem(String categoryName) {
                if (getOnCategoryListener() != null) {
                    getOnCategoryListener().onSelectCategoryName(categoryName);
                }
            }
        });
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setSelectedCategoryName("전체");
        requestLayout();
    }

    private void updateView() {

    }

    public OnCategoryListener getOnCategoryListener() {
        return mOnCategoryListener;
    }

    public void setOnCategoryListener(OnCategoryListener onCategoryListener) {
        mOnCategoryListener = onCategoryListener;
    }

    public interface OnCategoryListener {
        void onSelectCategoryName(String categoryName);
    }
}
