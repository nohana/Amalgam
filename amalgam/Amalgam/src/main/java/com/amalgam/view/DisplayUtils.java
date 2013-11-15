package com.amalgam.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;

public final class DisplayUtils {
    private DisplayUtils() {}

    @SuppressLint("NewApi")
    public static final Point getDisplaySize(WindowManager manager) {
        Display display = manager.getDefaultDisplay();
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB_MR2) {
            Point size = new Point();
            display.getSize(size);
            return size;
        } else {
            Point size = new Point();
            size.x = getDisplayWidth(manager);
            size.y = getDisplayHeight(manager);
            return size;
        }
    }

    @SuppressLint("NewApi")
    @SuppressWarnings("deprecation")
    public static final int getDisplayWidth(WindowManager manager) {
        Display display = manager.getDefaultDisplay();
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB_MR2) {
            Point size = new Point();
            display.getSize(size);
            return size.x;
        } else {
            return display.getWidth();
        }

    }

    public static final int getDisplayWidth(Activity activity) {
        return getDisplayWidth(activity.getWindowManager());
    }

    public static final int getDisplayWidth(Context context) {
        return getDisplayWidth((WindowManager) context.getSystemService(Context.WINDOW_SERVICE));
    }

    @SuppressLint("NewApi")
    @SuppressWarnings("deprecation")
    public static final int getDisplayHeight(WindowManager manager) {
        Display display = manager.getDefaultDisplay();
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB_MR2) {
            Point size = new Point();
            display.getSize(size);
            return size.y;
        } else {
            return display.getWidth();
        }

    }

    public static final int getDisplayHeight(Activity activity) {
        return getDisplayHeight(activity.getWindowManager());
    }

    public static final int getDisplayHeight(Context context) {
        return getDisplayHeight((WindowManager) context.getSystemService(Context.WINDOW_SERVICE));
    }
}
