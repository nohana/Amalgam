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

import com.amalgam.content.ContextUtils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

/**
 * Utility for the {@link android.view.View}.
 */
@SuppressWarnings("unused") // public APIs
public final class ViewUtils {
    private ViewUtils() {
        throw new AssertionError();
    }

    /**
     * Convert the dips to pixels, based on density scale.
     *
     * @param context the context.
     * @param dip to be converted value.
     * @return converted value(px).
     */
    public static int dipToPixel(Context context, int dip) {
        return dipToPixel(context.getResources(), dip);
    }

    /**
     * Convert the dips to pixels, based on density scale.
     *
     * @param resources application resources.
     * @param dip to be converted value.
     * @return converted value(px).
     */
    public static int dipToPixel(Resources resources, int dip) {
        final float scale = resources.getDisplayMetrics().density;
        // add 0.5f to round the figure up to the nearest whole number
        return (int) (dip * scale + 0.5f);
    }

    /**
     * Convert the pixels to dips, based on density scale.
     * @param context the context.
     * @param pixel to be converted value.
     * @return converted value(dip)
     */
    public static float pixelToDip(Context context, int pixel) {
        return pixelToDip(ContextUtils.getWindowManager(context), pixel);
    }

    /**
     * Convert the pixels to dips, based on density scale
     * @param windowManager the window manager of the display to use the scale density of.
     * @param pixel to be converted value.
     * @return converted value(dip).
     */
    public static float pixelToDip(WindowManager windowManager, int pixel) {
        DisplayMetrics metrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(metrics);
        return metrics.scaledDensity * pixel;
    }

    /**
     * Convert the sip to pixels, based on density scale.
     * @param context the context.
     * @param sip to be converted value.
     * @return converted value(px)
     */
    public static float sipToPixel(Context context, float sip) {
        return sipToPixel(context.getResources(), sip);
    }

    /**
     * Convert the sip to pixels, based on density scale.
     * @param resources application resources.
     * @param sip to be converted value.
     * @return converted value(px)
     */
    public static float sipToPixel(Resources resources, float sip) {
        float density = resources.getDisplayMetrics().scaledDensity;
        return sip * density;
    }

    /**
     * Convert the pixels to sips, based on density scale.
     * @param context the context.
     * @param pixels to be converted value.
     * @return converted value(sip)
     */
    public static float pixelToSip(Context context, float pixels) {
        DisplayMetrics metrics = new DisplayMetrics();
        float scaledDensity = metrics.scaledDensity;
        if (pixels == 0 || scaledDensity == 0) {
            return 1;
        }
        return pixels/scaledDensity;
    }

    /**
     * Toggle visibility of a {@link android.view.View}.
     * Status of invisible is applied by the parameter of hidingPolicy.
     * @param view to toggle
     * @param hidingPolicy {@link android.view.View#INVISIBLE} or {@link android.view.View#GONE}
     */
    public static void toggleVisibility(View view, int hidingPolicy) {
        int current = view.getVisibility();
        view.setVisibility(current == View.VISIBLE ? hidingPolicy : View.VISIBLE);
    }

    /**
     * Find the specific view from the view as traversal root.
     * Returning value type is bound to your variable type.
     *
     * @param view the root view to find the view.
     * @param id the view id.
     * @param <V> the view class type parameter.
     * @return the view, null if not found.
     */
    @SuppressWarnings("unchecked") // we know that return value type is a child of view, and V is bound to a child of view.
    public static <V extends View> V findViewById(View view, int id) {
        return (V) view.findViewById(id);
    }
}