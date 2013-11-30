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