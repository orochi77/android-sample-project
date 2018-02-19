package com.tangbba.androidsampleproject.util;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.View;

import com.tangbba.androidsampleproject.R;

/**
 * Created by orochi77 on 2018-02-07.
 */

public class DrawableUtil {

    public static Drawable setTintBackground(Context context, View view, int color) {
        Drawable inputDrawable = view.getBackground();

        Drawable wrapDrawable = DrawableCompat.wrap(inputDrawable);
        DrawableCompat.setTint(wrapDrawable, color);
        return wrapDrawable;
    }

    public static Drawable setTintColor(Context context, int drawableRes, int colorRes) {

        Drawable originalDrawable;
        int tintColor;

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            originalDrawable = context.getResources().getDrawable(drawableRes);
            tintColor = context.getResources().getColor(colorRes);
        } else {
            originalDrawable = context.getResources().getDrawable(drawableRes, context.getTheme());
            tintColor = context.getResources().getColor(colorRes, context.getTheme());
        }

        Drawable wrapDrawable = DrawableCompat.wrap(originalDrawable);
        DrawableCompat.setTint(wrapDrawable, tintColor);

        return wrapDrawable;

    }

    /**
     * 지정한 뷰의 배경을 duration동안 지정한 컬러로 애니메이션 하는 메소드
     * @param context
     * @param view
     * @param fromColorResId
     * @param toColorResId
     * @param duration
     */
    public static void animationBackgroundColor(Context context, View view, @ColorRes int fromColorResId, @ColorRes int toColorResId, int duration) {
        ObjectAnimator animator = ObjectAnimator.ofInt(
                view,
                "backgroundColor",
                ContextCompat.getColor(context, fromColorResId),
                ContextCompat.getColor(context, toColorResId))
                .setDuration(duration);
        animator.setEvaluator(new ArgbEvaluator());
        animator.start();
    }

    private void transitionBottomSheetBackgroundColor(Context context, View view, @ColorRes int colorFrom, @ColorRes int colorTo,  float slideOffset) {
        view.setBackgroundColor(interpolateColor(slideOffset,
                colorFrom, colorTo));
    }

    private int interpolateColor(float fraction, int startValue, int endValue) {
        int startA = (startValue >> 24) & 0xff;
        int startR = (startValue >> 16) & 0xff;
        int startG = (startValue >> 8) & 0xff;
        int startB = startValue & 0xff;
        int endA = (endValue >> 24) & 0xff;
        int endR = (endValue >> 16) & 0xff;
        int endG = (endValue >> 8) & 0xff;
        int endB = endValue & 0xff;
        return ((startA + (int) (fraction * (endA - startA))) << 24) |
                ((startR + (int) (fraction * (endR - startR))) << 16) |
                ((startG + (int) (fraction * (endG - startG))) << 8) |
                ((startB + (int) (fraction * (endB - startB))));
    }

}
