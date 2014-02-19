package com.amalgam.content.res;

import android.content.res.AssetFileDescriptor;
import android.util.Log;

import java.io.IOException;

/**
 */
@SuppressWarnings("unused") // public APIs
public final class AssetFileDescriptorUtils {
    public static final String TAG = AssetFileDescriptorUtils.class.getSimpleName();

    private AssetFileDescriptorUtils() {}

    public static final void close(AssetFileDescriptor descriptor) {
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