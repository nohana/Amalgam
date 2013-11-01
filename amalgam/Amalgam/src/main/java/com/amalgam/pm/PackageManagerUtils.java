package com.amalgam.pm;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;

/**
 */
public final class PackageManagerUtils {
    public static final String TAG = PackageManagerUtils.class.getSimpleName();
    private static final int FALLBACK_VERSION_CODE = 0;

    private PackageManagerUtils() {}

    public static final int getVersionCode(Context context) {
        return getVersionCode(context, FALLBACK_VERSION_CODE);
    }

    public static final int getVersionCode(Context context, int fallback) {
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            return info.versionCode;
        } catch (NameNotFoundException e) {
            Log.e(TAG, "no such package installed on the device: ", e);
        }
        return fallback;
    }

    public static final String getVersionName(Context context) {
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            return info.versionName;
        } catch (NameNotFoundException e) {
            throw new IllegalStateException("no such package installed on the device: ", e);
        }
    }
}