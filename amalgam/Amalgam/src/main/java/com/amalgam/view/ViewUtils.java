package com.amalgam.view;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public final class ViewUtils {
    private ViewUtils() {}

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

    /**
     * Convert the pixels to dips, based on density scale
     * @param windowManager the window manager of the display to use the scale density of
     * @param pixel
     * @return converted value(dip)
     */
    public static float pixelToDip(WindowManager windowManager, int pixel) {
        float dip = 0;
        DisplayMetrics metrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(metrics);
        dip = metrics.scaledDensity * pixel;
        return dip;
    }
}