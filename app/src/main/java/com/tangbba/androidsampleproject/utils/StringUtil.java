package com.tangbba.androidsampleproject.utils;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;

/**
 * Created by orochi77 on 2018-01-20.
 */

public class StringUtil {

    public static SpannableStringBuilder getHighlightText(String originalText, String highlightText, int color) {
        if (highlightText == null) {
            return new SpannableStringBuilder(originalText);
        }

        int startIndex = originalText.toLowerCase().indexOf(highlightText.toLowerCase());

        if (startIndex == -1) {
            return new SpannableStringBuilder(originalText);
        }

        int endIndex = highlightText.length();

        SpannableStringBuilder sb = new SpannableStringBuilder(originalText);
        sb.setSpan(new ForegroundColorSpan(color), startIndex, startIndex + endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return sb;
    }

}
