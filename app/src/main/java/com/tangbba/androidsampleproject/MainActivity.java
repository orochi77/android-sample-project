package com.tangbba.androidsampleproject;

import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import com.tangbba.androidsampleproject.model.Product;
import com.tangbba.androidsampleproject.tab.ImageTabView;
import com.tangbba.androidsampleproject.tab.LabelTabView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

//    private TabLayout mImageTabLayout;
    private TabLayout mLabelTabLayout;
    private RecyclerView mRecyclerView;
    private MyRecyclerViewAdapter mAdapter;

    private List<Product> mDataSource;
    private int mScroller;
    private int mScrollX;
    private int mScrollY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDataSource = Product.getProducts();

//        mImageTabLayout = (TabLayout) findViewById(R.id.image_tab_layout);
        mLabelTabLayout = (TabLayout) findViewById(R.id.label_tab_layout);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        setupRecyclerView();
        setupTab();
        bindTabEvent();
    }

    private void bindTabEvent() {
        mLabelTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                LabelTabView tabView = (LabelTabView) tab.getCustomView();
                int tabWidth = tabView.getWidth();
                int labelWidth = tabView.getLabelTextView().getWidth();
                Log.d("LABEL_WIDTH", "Width: " + labelWidth);

                int padding = (tabWidth - labelWidth) / 2;

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setupRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));;
        mAdapter = new MyRecyclerViewAdapter(this, Product.getProducts());
        mRecyclerView.setAdapter(mAdapter);
    }

    private void setupTab() {
        int loop = mDataSource.size();
        for (int i = 0; i < loop; i++) {
//            mImageTabLayout.addTab(mImageTabLayout.newTab().setCustomView(getImageTabView(mDataSource.get(i))));
            mLabelTabLayout.addTab(mLabelTabLayout.newTab().setCustomView(getLabelTabView(mDataSource.get(i))));
        }
        wrapTabIndicatorToTitle(mLabelTabLayout, 40, 40);
    }

    public void wrapTabIndicatorToTitle(TabLayout tabLayout, int externalMargin, int internalMargin) {
        View tabStrip = tabLayout.getChildAt(0);
        if (tabStrip instanceof ViewGroup) {
            ViewGroup tabStripGroup = (ViewGroup) tabStrip;
            int childCount = ((ViewGroup) tabStrip).getChildCount();
            for (int i = 0; i < childCount; i++) {
                View tabView = tabStripGroup.getChildAt(i);
                //set minimum width to 0 for instead for small texts, indicator is not wrapped as expected
                tabView.setMinimumWidth(0);
                // set padding to 0 for wrapping indicator as title
                tabView.setPadding(0, tabView.getPaddingTop(), 0, tabView.getPaddingBottom());
                // setting custom margin between tabs
                if (tabView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) tabView.getLayoutParams();
                    if (i == 0) {
                        // left
                        setMargin(layoutParams, externalMargin, internalMargin);
                    } else if (i == childCount - 1) {
                        // right
                        setMargin(layoutParams, internalMargin, externalMargin);
                    } else {
                        // internal
                        setMargin(layoutParams, internalMargin, internalMargin);
                    }
                }
            }

            tabLayout.requestLayout();
        }
    }

    private void setMargin(ViewGroup.MarginLayoutParams layoutParams, int start, int end) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            layoutParams.setMarginStart(start);
            layoutParams.setMarginEnd(end);
        } else {
            layoutParams.leftMargin = start;
            layoutParams.rightMargin = end;
        }
    }

    private ImageTabView getImageTabView(Product product) {
        ImageTabView tabView = new ImageTabView(this);
        tabView.setProduct(product);
        return tabView;
    }

    private LabelTabView getLabelTabView(Product product) {
        LabelTabView tabView = new LabelTabView(this);
        tabView.setProduct(product);
        return tabView;
    }
}
