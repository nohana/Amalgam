/*
 * Copyright (C) 2013 nohana, Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.amalgam.app;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Utility for {@link android.app.Application}.
 */
@SuppressWarnings("unused") // public APIs
public final class ApplicationUtils {
    private static final String[] INTERNAL_PATH = new String[] { "/data", "/system" };

    private ApplicationUtils() {
        throw new AssertionError();
    }

    /**
     * Get the {@link android.app.Application} of the {@link android.content.Context}.
     * @param context the context.
     * @return the {@link android.app.Application}.
     */
    public static Application getApplication(Context context) {
        return (Application) context.getApplicationContext();
    }

    /**
     * Checks if the {@link android.app.Application} is debuggable or not.
     * @param context the context.
     * @return true if debuggable, false otherwise.
     */
    public static boolean isDebuggable(Context context) {
        return isDebuggable((Application) context.getApplicationContext());
    }

    /**
     * Checks if the application is running as debug mode or not.
     * @param app the application to check
     * @return true if debuggable, false otherwise.
     */
    public static boolean isDebuggable(Application app) {
        ApplicationInfo info = app.getApplicationInfo();
        return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
    }

    /**
     * Checks if the application is installed on external storage, in most case on the SD card.
     * @param context the context.
     * @return true if the application is installed on external storage, false otherwise.
     */
    public static boolean isInstalledOnSDCard(Context context) {
        return isInstalledOnSDCard(getApplication(context));
    }

    /**
     * Checks if the application is installed on external storage, in most case on the SD card.
     * @param app the application to check.
     * @return true if the application is installed on external storage, false otherwise.
     */
    public static boolean isInstalledOnSDCard(Application app) {
        try {
            String packageName = app.getPackageName();
            PackageInfo info = app.getPackageManager().getPackageInfo(packageName, 0);
            String dir = info.applicationInfo.sourceDir;

            for (String path : INTERNAL_PATH) {
                if (path.equals(dir.substring(0, path.length())))
                    return false;
            }
        } catch (PackageManager.NameNotFoundException exp) {
            throw new IllegalArgumentException(exp);
        }
        return true;
    }
}