package com.tangbba.androidsampleproject.tab;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tangbba.androidsampleproject.R;
import com.tangbba.androidsampleproject.model.Product;

/**
 * Created by orochi77 on 2018-02-19.
 */

public class LabelTabView extends LinearLayout {

    private View mRootView;
    private TextView mLabelTextView;
    private ImageView mImageView;

    private Product mProduct;

    public LabelTabView(Context context) {
        this(context, null);
    }

    public LabelTabView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LabelTabView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeView();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        updateView();
    }

    private void initializeView() {
        mRootView = inflate(getContext(), R.layout.label_tab_layout, this);
        mLabelTextView = (TextView) mRootView.findViewById(R.id.tab_label_text_view);
        mImageView = (ImageView) mRootView.findViewById(R.id.tab_image_view);
    }

    private void updateView() {
        if (mRootView == null || mLabelTextView == null) {
            return;
        }

        if (mProduct == null) {
            return;
        }

        mLabelTextView.setText(mProduct.getName());
        Picasso.with(getContext()).load(mProduct.getImageUrl()).into(mImageView);
    }

    public Product getProduct() {
        return mProduct;
    }

    public void setProduct(Product product) {
        mProduct = product;
        updateView();
    }

    public TextView getLabelTextView() {
        return mLabelTextView;
    }
}
