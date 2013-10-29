package com.amalgam.io;

import android.util.Log;

import java.io.Closeable;
import java.io.IOException;

/**
 */
public final class CloseableUtils {
    private static final String TAG = CloseableUtils.class.getSimpleName();
    private CloseableUtils() {}

    public static final void close(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e) {
            Log.e(TAG, "something went wrong on close", e);
        }
    }
}
