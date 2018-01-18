package com.tangbba.androidsampleproject.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;

import com.tangbba.androidsampleproject.R;

public class BottomSheetBasicActivity extends Activity {

    private AnchoredBottomSheetBehavior mBottomSheetBehavior;
    private View mBottomSheet;
    private View mCoverView;

    private int mPeekHeight;

    final private DisplayMetrics mDisplayMetrics = new DisplayMetrics();

    public static Intent newIntent(Context context) {
        return new Intent(context, BottomSheetBasicActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet_basic);

        mPeekHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 56.0f, getResources().getDisplayMetrics());
        mBottomSheet = findViewById(R.id.bottom_sheet);
        mCoverView = findViewById(R.id.cover_view);
        mBottomSheetBehavior = AnchoredBottomSheetBehavior.from(mBottomSheet);
        mBottomSheetBehavior.setState(AnchoredBottomSheetBehavior.STATE_ANCHORED);
        setupButtonEvent();
        setupBottomSheetEvent();

    }

    private void setupBottomSheetEvent() {
        mBottomSheetBehavior.addBottomSheetCallback(new AnchoredBottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                if (slideOffset > 0) {
                    mCoverView.setVisibility(View.VISIBLE);
                } else {
                    mCoverView.setVisibility(View.GONE);
                }
            }
        });
    }



    private void setupButtonEvent() {

        mCoverView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBottomSheetBehavior.setState(AnchoredBottomSheetBehavior.STATE_COLLAPSED);
            }
        });

        findViewById(R.id.show_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBottomSheetBehavior.setState(AnchoredBottomSheetBehavior.STATE_COLLAPSED);
            }
        });

        findViewById(R.id.hide_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBottomSheetBehavior.isHideable()) {
                    mBottomSheetBehavior.setState(AnchoredBottomSheetBehavior.STATE_HIDDEN);
                }
            }
        });

        findViewById(R.id.extend_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBottomSheetBehavior.setState(AnchoredBottomSheetBehavior.STATE_EXPANDED);
            }
        });

        findViewById(R.id.anchor_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBottomSheetBehavior.setState(AnchoredBottomSheetBehavior.STATE_ANCHORED);
            }
        });
    }
}
