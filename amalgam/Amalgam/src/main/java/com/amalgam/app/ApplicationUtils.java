package com.amalgam.app;

import android.app.Application;
import android.content.pm.ApplicationInfo;

/**
 * Utility for application object.
 */
public final class ApplicationUtils {
    private ApplicationUtils() {}

    /**
     * Checks if the application is running as debug mode or not.
     * @param app the application to check
     * @return true if debuggable, false otherwise.
     */
    public static final boolean isDebuggable(Application app) {
        ApplicationInfo info = app.getApplicationInfo();
        return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
    }
}