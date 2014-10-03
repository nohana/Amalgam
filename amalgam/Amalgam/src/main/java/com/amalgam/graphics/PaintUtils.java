package com.amalgam.graphics;

import android.graphics.Paint;

/**
 * @author KeithYokoma
 */
@SuppressWarnings("unused")
public final class PaintUtils {
    private PaintUtils() {
        throw new AssertionError();
    }

    public static Paint createFillPaint(int color) {
        Paint paint = new Paint();
        paint.setColor(color);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        return paint;
    }

    public static Paint createStrokePaint(int color, int strokeWidth) {
        Paint paint = new Paint();
        paint.setColor(color);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokeWidth);
        paint.setAntiAlias(true);
        return paint;
    }
}
