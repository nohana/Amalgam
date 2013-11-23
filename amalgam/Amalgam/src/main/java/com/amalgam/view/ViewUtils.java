package com.amalgam.view;

import android.content.Context;
import android.content.res.Resources;
import android.hardware.display.DisplayManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.amalgam.content.ContextUtils;

public final class ViewUtils {
    private ViewUtils() {}

    public static int dipToPixel(Context context, int dip) {
        return dipToPixel(context.getResources(), dip);
    }

    /**
     * Convert the dips to pixels, based on density scale
     *
     * @param resources application resources
     * @param dip to be converted value
     * @return converted value(px)
     */
    public static int dipToPixel(Resources resources, int dip) {
        final float scale = resources.getDisplayMetrics().density;
        // add 0.5f to round the figure up to the nearest whole number
        return (int) (dip * scale + 0.5f);
    }

    public static float pixelToDip(Context context, int pixel) {
        return pixelToDip(ContextUtils.getWindowManager(context), pixel);
    }

    /**
     * Convert the pixels to dips, based on density scale
     * @param windowManager the window manager of the display to use the scale density of
     * @param pixel
     * @return converted value(dip)
     */
    public static float pixelToDip(WindowManager windowManager, int pixel) {
        DisplayMetrics metrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(metrics);
        return metrics.scaledDensity * pixel;
    }

    public static float sipToPixel(Context context, float sip) {
        return sipToPixel(context.getResources(), sip);
    }

    public static float sipToPixel(Resources resources, float sip) {
        float density = resources.getDisplayMetrics().scaledDensity;
        return sip * density;
    }

    public static float pixelToSip(Context context, float pixels) {
        DisplayMetrics metrics = new DisplayMetrics();
        float scaledDensity = metrics.scaledDensity;
        if (pixels == 0 || scaledDensity == 0) {
            return 1;
        }
        return pixels/scaledDensity;
    }
}