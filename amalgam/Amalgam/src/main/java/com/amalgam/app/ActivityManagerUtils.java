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

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Service;
import android.content.Context;

import java.util.List;

/**
 * Utility for activity manager.
 * @author KeithYokoma
 */
@SuppressWarnings("unused") // public APIs
public final class ActivityManagerUtils {
    /**
     * Do NOT instantiate this class.
     */
    private ActivityManagerUtils() {}

    /**
     * Checks if the specified service is currently running or not.
     * @param context
     * @param service
     * @return
     */
    public static final boolean isServiceRunning(Context context, Class<? extends Service> service) {
        return isServiceRunning(context, service, Integer.MAX_VALUE);
    }

    /**
     * Checks if the specified service is currently running or not.
     * @param context
     * @param service
     * @param maxCheckCount
     * @return
     */
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

    /**
     * Get package name of the process id.
     * @param context
     * @param pid
     * @return
     */
    public static final String getPackageNameFromPid(Context context, int pid) {
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
}