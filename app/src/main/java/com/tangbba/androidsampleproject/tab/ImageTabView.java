package com.tangbba.androidsampleproject.tab;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;
import com.tangbba.androidsampleproject.R;
import com.tangbba.androidsampleproject.model.Product;

/**
 * Created by orochi77 on 2018-02-19.
 */

public class ImageTabView extends LinearLayout {

    private View mRootView;
    private ImageView mTabImageView;

    private Product mProduct;

    public ImageTabView(Context context) {
        this(context, null);
    }

    public ImageTabView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ImageTabView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeView();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        updateView();
    }

    private void initializeView() {
        mRootView = inflate(getContext(), R.layout.image_tab_layout, this);
        mTabImageView = (ImageView) mRootView.findViewById(R.id.tab_image_view);
    }

    private void updateView() {
        if (mRootView == null || mTabImageView == null) {
            return;
        }

        if (mProduct == null) {
            return;
        }

        Picasso.with(getContext()).load(mProduct.getImageUrl()).into(mTabImageView);
    }

    public Product getProduct() {
        return mProduct;
    }

    public void setProduct(Product product) {
        mProduct = product;
        updateView();
    }
}
