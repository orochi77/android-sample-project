package com.tangbba.androidsampleproject;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.tangbba.androidsampleproject.views.DonutView;

public class MainActivity extends AppCompatActivity {

    private DonutView mDonutView;
    private ValueAnimator sweepAngleAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDonutView = findViewById(R.id.donut_view);

        sweepAngleAnimator = ValueAnimator.ofInt(0, 270);
        sweepAngleAnimator.setDuration(1000);
        sweepAngleAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        sweepAngleAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int animatedValue = (int) animation.getAnimatedValue();
                mDonutView.setSweepAngle(animatedValue);
                mDonutView.invalidate();
            }
        });

        sweepAngleAnimator.start();
    }
}
