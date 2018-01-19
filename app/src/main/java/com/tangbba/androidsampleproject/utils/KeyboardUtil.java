package com.tangbba.androidsampleproject.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by orochi77 on 2018-01-19.
 */

public class KeyboardUtil {
    public static void showSoftKeyboard(View view) {
        InputMethodManager mgr = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.showSoftInput(view, InputMethodManager.SHOW_FORCED);
    }

    public static void showImplicitSoftKeyboard(View view) {
        InputMethodManager mgr = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
    }

    public static void hideSoftKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
    public static void hideSoftKeyboardChangeFlag(Activity activity) {
        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    public static void toggleSoftKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            imm.toggleSoftInput(0, 0);
        } else {
            imm.toggleSoftInputFromWindow(view.getWindowToken(), InputMethodManager.SHOW_FORCED, 0);
        }
    }
}
