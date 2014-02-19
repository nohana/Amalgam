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
package com.amalgam.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;

@SuppressWarnings("unused") // public APIs
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
