package com.amalgam.os;

import android.os.ParcelFileDescriptor;
import android.util.Log;

import java.io.IOException;

/**
 * Utility for the {@link android.os.ParcelFileDescriptor}.
 */
@SuppressWarnings("unused") // public APIs
public final class ParcelFileDescriptorUtils {
    public static final String TAG = ParcelFileDescriptorUtils.class.getSimpleName();

    private ParcelFileDescriptorUtils() {
        throw new AssertionError();
    }

    /**
     * Close {@link android.os.ParcelFileDescriptor} with null checks.
     * Any exception during close is just logged.
     * @param descriptor to close.
     */
    public static void close(ParcelFileDescriptor descriptor) {
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
