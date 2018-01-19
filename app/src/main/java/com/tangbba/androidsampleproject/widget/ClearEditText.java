package com.tangbba.androidsampleproject.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.tangbba.androidsampleproject.R;

/**
 * Created by orochi77 on 2018-01-19.
 */

public class ClearEditText extends AppCompatEditText implements View.OnTouchListener, View.OnFocusChangeListener, TextWatcher {
    private static final String TAG = "ClearEditText";

    private Drawable mClearButtonDrawable;
    private OnFocusChangeListener mOnFocusChangeListener;
    private OnTouchListener mOnTouchListener;

    public ClearEditText(Context context) {
        super(context);
        setupAttributeSet();
        initializeView();
    }

    public ClearEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupAttributeSet();
        initializeView();
    }

    public ClearEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setupAttributeSet();
        initializeView();
    }

    private void setupAttributeSet() {
        TypedArray typedArray = getContext().obtainStyledAttributes(R.styleable.ClearEditText);

        try {
            Drawable tempDrawable = typedArray.getDrawable(R.styleable.ClearEditText_clearButtonDrawable);
            if (tempDrawable == null) {
                tempDrawable = ContextCompat.getDrawable(getContext(), R.drawable.ic_erase);
            }
            mClearButtonDrawable = DrawableCompat.wrap(tempDrawable);
            mClearButtonDrawable.setBounds(
                    0,
                    0,
                    mClearButtonDrawable.getIntrinsicWidth(),
                    mClearButtonDrawable.getIntrinsicHeight());
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        } finally {
            typedArray.recycle();
        }
    }

    private void initializeView() {
        setVisibleClearButton(false);
        super.setOnTouchListener(this);
        super.setOnFocusChangeListener(this);
        addTextChangedListener(this);
    }

    private void setVisibleClearButton(boolean visible) {
        if (mClearButtonDrawable == null) {
            return;
        }
        mClearButtonDrawable.setVisible(visible, false);
        Drawable[] compoundDrawables = getCompoundDrawables();
        setCompoundDrawables(
                compoundDrawables[0],
                compoundDrawables[1],
                visible ? mClearButtonDrawable : null,
                compoundDrawables[3]
        );
    }

    @Override
    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        mOnFocusChangeListener = onFocusChangeListener;
    }

    @Override
    public void setOnTouchListener(OnTouchListener onTouchListener) {
        mOnTouchListener = onTouchListener;
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int x = (int) event.getX();

        if (mClearButtonDrawable.isVisible() &&
                x > getWidth() - getPaddingRight() - mClearButtonDrawable.getIntrinsicWidth()) {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                setText("");
                requestFocus();
                setVisibleClearButton(false);
            }
            return true;
        }

        if (mOnTouchListener != null) {
            return mOnTouchListener.onTouch(v, event);
        } else {
            return false;
        }
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {
            if (getText().length() > 0) {
                setVisibleClearButton(true);
            } else {
                setVisibleClearButton(false);
            }
        }

        if (mOnFocusChangeListener != null) {
            mOnFocusChangeListener.onFocusChange(v, hasFocus);
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (s.length() > 0) {
            setVisibleClearButton(true);
        } else {
            setVisibleClearButton(false);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
