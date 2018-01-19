package com.tangbba.androidsampleproject.widget;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;

/**
 * Created by orochi77 on 2018-01-19.
 */

public class BrandSearchView extends ClearEditText {

    private OnSearchViewTextChangeListener mOnSearchViewTextChangeListener;

    public BrandSearchView(Context context) {
        super(context);
    }

    public BrandSearchView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BrandSearchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        super.beforeTextChanged(s, start, count, after);
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        super.onTextChanged(s, start, before, count);

    }

    @Override
    public void afterTextChanged(Editable s) {
        super.afterTextChanged(s);
        if (mOnSearchViewTextChangeListener != null) {
            mOnSearchViewTextChangeListener.onChangeText(s);
        }
    }

    public OnSearchViewTextChangeListener getOnSearchViewTextChangeListener() {
        return mOnSearchViewTextChangeListener;
    }

    public void setOnSearchViewTextChangeListener(OnSearchViewTextChangeListener onSearchViewTextChangeListener) {
        mOnSearchViewTextChangeListener = onSearchViewTextChangeListener;
    }

    public interface OnSearchViewTextChangeListener {
        void onChangeText(CharSequence s);
    }
}
