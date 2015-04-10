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
package com.amalgam.widget;

import com.amalgam.os.HandlerUtils;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

/**
 * Utility for the {@link android.widget.Toast}.
 */
@SuppressWarnings("unused") // public APIs
public final class ToastUtils {
    private ToastUtils() {
        throw new AssertionError();
    }

    /**
     * Show toast on the UI thread.
     * @param applicationContext the application context.
     * @param stringResId to show.
     * @param duration the display duration.
     */
    public static void showOnUiThread(Context applicationContext, int stringResId, int duration) {
        Handler handler = HandlerUtils.getMainHandler();
        showOnUiThread(applicationContext, stringResId, duration, handler);
    }

    /**
     * Show toast on the UI thread.
     * @param applicationContext the application context.
     * @param stringResId to show.
     * @param duration the display duration.
     * @param handler the main handler.
     */
    public static void showOnUiThread(Context applicationContext, int stringResId, int duration, Handler handler) {
        showOnUiThread(applicationContext, applicationContext.getString(stringResId), duration, handler);
    }

    /**
     * Show toast on the UI thread.
     * @param applicationContext the application context.
     * @param message the message to show.
     * @param duration the display duration.
     */
    public static void showOnUiThread(Context applicationContext, String message, int duration) {
        Handler handler = HandlerUtils.getMainHandler();
        showOnUiThread(applicationContext, message, duration, handler);
    }

    /**
     * Show toast on the UI thread.
     * @param applicationContext the application context.
     * @param message the message to show.
     * @param duration the display duration.
     * @param handler the main handler.
     */
    public static void showOnUiThread(final Context applicationContext, final String message, final int duration, Handler handler) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(applicationContext, message, duration).show();
            }
        });
    }
}