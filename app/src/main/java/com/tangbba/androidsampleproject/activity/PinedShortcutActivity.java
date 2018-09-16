package com.tangbba.androidsampleproject.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tangbba.androidsampleproject.R;

public class PinedShortcutActivity extends AppCompatActivity {

    public static Intent newIntent(Context context) {
        return new Intent(context, PinedShortcutActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pined_shortcut);
    }
}
