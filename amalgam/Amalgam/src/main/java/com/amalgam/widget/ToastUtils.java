package com.amalgam.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

public final class ToastUtils {
    private ToastUtils() {}

    public static final void showOnUiThread(Context applicationContext, int stringResId, int duration) {
        Handler handler = new Handler(Looper.getMainLooper());
        showOnUiThread(applicationContext, stringResId, duration, handler);
    }

    public static final void showOnUiThread(Context applicationContext, int stringResId, int duration, Handler handler) {
        showOnUiThread(applicationContext, applicationContext.getString(stringResId), duration, handler);
    }

    public static final void showOnUiThread(Context applicationContext, String message, int duration) {
        Handler handler = new Handler(Looper.getMainLooper());
        showOnUiThread(applicationContext, message, duration, handler);
    }

    public static final void showOnUiThread(final Context applicationContext, final String message, final int duration, Handler handler) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(applicationContext, message, duration).show();
            }
        });
    }
}