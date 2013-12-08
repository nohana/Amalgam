package com.amalgam.os;

import android.os.ParcelFileDescriptor;
import android.util.Log;

import java.io.IOException;

public final class ParcelFileDescriptorUtils {
    public static final String TAG = ParcelFileDescriptorUtils.class.getSimpleName();

    private ParcelFileDescriptorUtils() {}

    public static final void close(ParcelFileDescriptor descriptor) {
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
