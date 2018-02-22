package com.tangbba.androidsampleproject;

import android.content.Intent;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.tangbba.androidsampleproject.util.DrawableUtil;

public class MainActivity extends AppCompatActivity {

    private View mHeroView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHeroView = findViewById(R.id.hero_background_view);

        findViewById(R.id.primary_color_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewCompat.setBackground(mHeroView, DrawableUtil.setTintColor(
                        MainActivity.this,
                        R.drawable.top_edge_round_rect,
                        R.color.colorPrimary
                ));
            }
        });

        findViewById(R.id.accent_color_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewCompat.setBackground(mHeroView, DrawableUtil.setTintColor(
                        MainActivity.this,
                        R.drawable.top_edge_round_rect,
                        R.color.colorAccent
                ));
            }
        });

        findViewById(R.id.open_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = ListActivity.newIntent(MainActivity.this);
                startActivity(intent);
            }
        });
    }
}
