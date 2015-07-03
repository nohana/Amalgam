package com.amalgam.content.res;

import android.content.res.AssetFileDescriptor;
import android.util.Log;

import java.io.IOException;

/**
 * Utility for the {@link android.content.res.AssetFileDescriptor}.
 */
@SuppressWarnings("unused") // public APIs
public final class AssetFileDescriptorUtils {
    public static final String TAG = AssetFileDescriptorUtils.class.getSimpleName();

    private AssetFileDescriptorUtils() {
        throw new AssertionError();
    }

    /**
     * Close the descriptor, and if the exception during close will be logged.
     * @param descriptor to close.
     */
    public static void close(AssetFileDescriptor descriptor) {
        if (descriptor == null) {
            return;
        }
        try {
            descriptor.close();
        } catch (IOException e) {
            Log.e(TAG, "something went wrong on close descriptor: ", e);
        }
    }
}