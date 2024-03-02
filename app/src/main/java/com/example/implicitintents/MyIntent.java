package com.example.implicitintents;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;

public class MyIntent extends Intent {

    public static final String ACTION_VIEW =
            "android.intent.action.VIEW";

    public MyIntent(String action, Uri webpage) {
        super(action);
        setData(webpage);
    }

    @Override
    public ComponentName resolveActivity(PackageManager packageManager) {
        return super.resolveActivity(packageManager);
    }
}