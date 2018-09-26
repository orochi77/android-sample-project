package com.tangbba.androidsampleproject;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView0;
    private TextView mTextView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView0 = (TextView) findViewById(R.id.text_view_0);
        mTextView1 = (TextView) findViewById(R.id.text_view_1);

        setTexts();
    }

    private void setTexts() {
        String string0 = "동해물과 백두산이";
        String string1 = "동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리 나라 만세";

        Spannable spannable0 = new SpannableString(string0);
        spannable0.setSpan(new BackgroundColorSpan(Color.GRAY), 0, string0.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTextView0.setText(spannable0);

        Spannable spannable1 = new SpannableString(string1);
        spannable1.setSpan(new BackgroundColorSpan(Color.RED), 0, string1.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTextView1.setText(spannable1);

    }
}
