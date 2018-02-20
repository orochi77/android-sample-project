package com.tangbba.androidsampleproject;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
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
//        bindTabEvent();
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
    }

    private void bindTabEvent() {

//        mLabelTabLayout.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
//            @Override
//            public void onScrollChanged() {
//                mScroller = 0;
//                mImageTabLayout.setScrollX(mLabelTabLayout.getScrollX());
//            }
//        });
//        mImageTabLayout.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
//            @Override
//            public void onScrollChanged() {
//                mScroller = 1;
//                mLabelTabLayout.setScrollX(mImageTabLayout.getScrollX());
//
//            }
//        });
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
