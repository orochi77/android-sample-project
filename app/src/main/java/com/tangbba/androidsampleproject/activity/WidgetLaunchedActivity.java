package com.tangbba.androidsampleproject.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.support.v4.content.pm.ShortcutInfoCompat;
import android.support.v4.content.pm.ShortcutManagerCompat;
import android.support.v4.graphics.drawable.IconCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tangbba.androidsampleproject.R;

public class WidgetLaunchedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget_launched);

        final Intent intent = getIntent();
        final String action = intent.getAction();

        if (Intent.ACTION_CREATE_SHORTCUT.equals(action)) {
            intent.setComponent(new ComponentName(this, WidgetLaunchedActivity.class));

            ShortcutInfoCompat shortcutInfoCompat = new ShortcutInfoCompat.Builder(this, "mealTicketWidget")
                    .setShortLabel(getString(R.string.meal_ticket))
                    .setLongLabel(getString(R.string.meal_ticket))
                    .setIcon(IconCompat.createWithResource(this, R.mipmap.ic_shortcut_meal_ticket))
                    .setIntent(intent)
                    .build();

            Intent shortcutIntent = ShortcutManagerCompat.createShortcutResultIntent(this, shortcutInfoCompat);
            setResult(Activity.RESULT_OK, shortcutIntent);
            finish();
            return;
        }
    }
}
