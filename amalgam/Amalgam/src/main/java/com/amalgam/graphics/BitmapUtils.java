package com.amalgam.graphics;

import android.graphics.Bitmap;
import android.graphics.Matrix;

import com.amalgam.io.CloseableUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 */
public final class BitmapUtils {
    public static final String TAG = BitmapUtils.class.getSimpleName();

    private BitmapUtils() {}

    public static final void recycle(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        bitmap.recycle();
    }

    public static final byte[] toByteArray(Bitmap bitmap, Bitmap.CompressFormat format, int quality) {
        ByteArrayOutputStream out = null;
        try {
            out = new ByteArrayOutputStream();
            bitmap.compress(format, quality, out);
            return out.toByteArray();
        } finally {
            CloseableUtils.close(out);
        }
    }

    public static final Bitmap shrink(Bitmap bitmap, float scale) {
        if (scale >= 1.0f) {
            return bitmap.copy(bitmap.getConfig(), false);
        }

        Matrix matrix = new Matrix();
        matrix.postScale(scale, scale);

        return Bitmap.createBitmap(bitmap, 0, 0, (int) (scale * bitmap.getWidth()), (int) (scale * bitmap.getHeight()), matrix, true);
    }
}
