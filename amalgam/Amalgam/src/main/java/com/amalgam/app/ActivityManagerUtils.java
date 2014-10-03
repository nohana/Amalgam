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

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;

import java.util.List;

/**
 * Utility for {@link android.app.ActivityManager}.
 * @author KeithYokoma
 */
@SuppressWarnings("unused") // public APIs
public final class ActivityManagerUtils {
    /**
     * Do NOT instantiate this class.
     */
    private ActivityManagerUtils() {
        throw new AssertionError();
    }

    /**
     * Checks if the specified service is currently running or not.
     * @param context the context.
     * @param service the {@link java.lang.Class} of the service.
     * @return true if the service is running, false otherwise.
     */
    public static boolean isServiceRunning(Context context, Class<? extends Service> service) {
        return isServiceRunning(context, service, Integer.MAX_VALUE);
    }

    /**
     * Checks if the specified service is currently running or not.
     * @param context the context.
     * @param service the {@link java.lang.Class} of the service.
     * @param maxCheckCount maximum value of the running service count for this check.
     * @return true if the service is running, false otherwise.
     */
    public static boolean isServiceRunning(Context context, Class<? extends Service> service, int maxCheckCount) {
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

    public static boolean isApplicationRunning(Context context, String packageName) {
        return isApplicationRunning(context, packageName, Integer.MAX_VALUE);
    }

    public static boolean isApplicationRunning(Context context, String packageName, int maxCheckCount) {
        if (TextUtils.isEmpty(packageName)) {
            return false;
        }

        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> list = manager.getRunningTasks(maxCheckCount);
        for (ActivityManager.RunningTaskInfo info : list) {
            if (packageName.equals(info.baseActivity.getPackageName())) {
                return true;
            }
        }
        return false;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static void moveTaskToFront(ActivityManager manager, ActivityManager.RunningTaskInfo info) {
        manager.moveTaskToFront(info.id, 0x10000000);
    }

    /**
     * Get package name of the process id.
     * @param context the context.
     * @param pid the process id.
     * @return the package name for the process id. {@code null} if no process found.
     */
    public static String getPackageNameFromPid(Context context, int pid) {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<RunningAppProcessInfo> processes = am.getRunningAppProcesses();
        for (RunningAppProcessInfo info : processes) {
            if (info.pid == pid) {
                String[] packages = info.pkgList;
                if (packages.length > 0) {
                    return packages[0];
                }
                break;
            }
        }
        return null;
    }

    public static ComponentName getCurrentActivity(Context context) {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);

        // get the info from the currently running task
        List<ActivityManager.RunningTaskInfo> taskInfo = am.getRunningTasks(1);
        if (taskInfo == null || taskInfo.size() <= 0) {
            return null;
        }

        return taskInfo.get(0).topActivity;
    }
}