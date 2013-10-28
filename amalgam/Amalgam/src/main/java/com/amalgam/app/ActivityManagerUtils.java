package com.amalgam.app;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.Service;
import android.content.Context;

import java.util.List;

/**
 * Utility for activity manager.
 * @author KeithYokoma
 */
public final class ActivityManagerUtils {
    private ActivityManagerUtils() {}

    public static final boolean isServiceRunning(Context context, Class<? extends Service> service) {
        return isServiceRunning(context, service, Integer.MAX_VALUE);
    }

    public static final boolean isServiceRunning(Context context, Class<? extends Service> service, int maxCheckCount) {
        if (context == null || service == null) {
            return false;
        }

        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<RunningServiceInfo> list = manager.getRunningServices(maxCheckCount);
        for (RunningServiceInfo info : list) {
            if (service.getCanonicalName().equals(info.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}