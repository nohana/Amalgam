package com.amalgam.io;

import android.util.Log;

import com.amalgam.io.CloseableUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public final class InputStreamUtils {
    public static final String TAG = InputStreamUtils.class.getSimpleName();

    private InputStreamUtils() {}

    public static byte[] toByteArray(InputStream is) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int len = 0;

        try {
            while ((len = is.read(buffer)) > 0) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException exp) {
            Log.e(TAG, "something wrong with i/o while converting an input stream to byte array", exp);
            return null;
        } finally {
            CloseableUtils.close(is);
        }

        return bos.toByteArray();
    }

    public static String toString(InputStream is) {
        return new String(toByteArray(is));
    }
}