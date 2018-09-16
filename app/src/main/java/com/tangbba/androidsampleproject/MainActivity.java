package com.tangbba.androidsampleproject;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.pm.ShortcutInfoCompat;
import android.support.v4.content.pm.ShortcutManagerCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.graphics.drawable.IconCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tangbba.androidsampleproject.activity.PinedShortcutActivity;
import com.tangbba.androidsampleproject.util.DrawableUtil;

public class MainActivity extends AppCompatActivity {

    public static final String ACTION_PIN_SHORTCUT_ACCEPTED = "com.tangbba.ACTION_PIN_SHORTCUT_ACCEPTED";

    private Button mAddPinShortcutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAddPinShortcutButton = (Button) findViewById(R.id.add_pin_shortcut_button);
        mAddPinShortcutButton.setOnClickListener(mAddPinShortcutButtonClickListener);
    }

    private View.OnClickListener mAddPinShortcutButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (ShortcutManagerCompat.isRequestPinShortcutSupported(MainActivity.this)) {
                Context context = MainActivity.this;
                final Intent intent = new Intent(ACTION_PIN_SHORTCUT_ACCEPTED);
                intent.setComponent(new ComponentName(context, PinedShortcutActivity.class));

                Drawable foreground = ContextCompat.getDrawable(context, R.mipmap.ic_shortcut_offlinepayment_foreground);
                Drawable background = ContextCompat.getDrawable(context, R.color.ic_shortcut_background);

                AdaptiveIconDrawable adaptiveIconDrawable = new AdaptiveIconDrawable(background, foreground);

                Bitmap iconBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_shortcut_offlinepayment_foreground);

                ShortcutInfoCompat shortcutInfoCompat = new ShortcutInfoCompat.Builder(context, "PinedShortcut")
                        .setShortLabel(getString(R.string.offline_payment))
                        .setLongLabel(getString(R.string.offline_payment))
//                        .setIcon(IconCompat.createWithAdaptiveBitmap(iconBitmap))
                        .setIcon(IconCompat.createWithResource(context, R.mipmap.ic_offline_payment))
//                        .setIcon(IconCompat.createWithAdaptiveBitmap(DrawableUtil.drawableToBitmap(adaptiveIconDrawable)))
                        .setIntent(intent)
                        .build();

                Intent callbackIntent = ShortcutManagerCompat.createShortcutResultIntent(context, shortcutInfoCompat);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(context,
                        0,
                        callbackIntent,
                        0);
                ShortcutManagerCompat.requestPinShortcut(context, shortcutInfoCompat, pendingIntent.getIntentSender());

            }
        }
    };
}
