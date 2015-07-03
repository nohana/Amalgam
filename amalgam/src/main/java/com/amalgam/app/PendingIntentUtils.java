package com.amalgam.app;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

/**
 * Utility for PendingIntent.
 * @author KeithYokoma
 */
public final class PendingIntentUtils {
    private PendingIntentUtils() {
        throw new AssertionError();
    }

    /**
     * Create a new {@link PendingIntent} clearing previously created {@link PendingIntent} that does not work properly due to application's re-installation.
     * Bugfix utility for this issue: https://code.google.com/p/android/issues/detail?id=61850
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static PendingIntent getActivities(Context context, int requestCode, Intent[] intents, int flags) {
        PendingIntent.getActivities(context, requestCode, intents, flags).cancel();
        return PendingIntent.getActivities(context, requestCode, intents, flags);
    }

    /**
     * Create a new {@link PendingIntent} clearing previously created {@link PendingIntent} that does not work properly due to application's re-installation.
     * Bugfix utility for this issue: https://code.google.com/p/android/issues/detail?id=61850
     */
    public static PendingIntent getActivity(Context context, int requestCode, Intent intent, int flags) {
        PendingIntent.getActivity(context, requestCode, intent, flags).cancel();
        return PendingIntent.getActivity(context, requestCode, intent, flags);
    }

    /**
     * Create a new {@link PendingIntent} clearing previously created {@link PendingIntent} that does not work properly due to application's re-installation.
     * Bugfix utility for this issue: https://code.google.com/p/android/issues/detail?id=61850
     */
    public static PendingIntent getBroadcast(Context context, int requestCode, Intent intent, int flags) {
        PendingIntent.getBroadcast(context, requestCode, intent, flags).cancel();
        return PendingIntent.getBroadcast(context, requestCode, intent, flags);
    }

    /**
     * Create a new {@link PendingIntent} clearing previously created {@link PendingIntent} that does not work properly due to application's re-installation.
     * Bugfix utility for this issue: https://code.google.com/p/android/issues/detail?id=61850
     */
    public static PendingIntent getService(Context context, int requestCode, Intent intent, int flags) {
        PendingIntent.getService(context, requestCode, intent, flags).cancel();
        return PendingIntent.getService(context, requestCode, intent, flags);
    }
}
