/*
 * Copyright (C) 2013 nohana, Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.amalgam.graphics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Environment;
import android.util.Log;

import com.amalgam.io.CloseableUtils;
import com.amalgam.io.FileUtils;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

    public static final Bitmap expand(Bitmap bitmap, float scale) {
        if (scale <= 1.0f) {
            return bitmap.copy(bitmap.getConfig(), false);
        }

        Matrix matrix = new Matrix();
        matrix.postScale(scale, scale);

        return Bitmap.createBitmap(bitmap, 0, 0, (int) (scale * bitmap.getWidth()), (int) (scale * bitmap.getHeight()), matrix, true);
    }

    public static final File storeOnExternalStorage(Context context, Bitmap bitmap, String type, String path, String filename, Bitmap.CompressFormat format, int quality) {
        if (!Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            // we cannot save a bitmap on the external storage on media not mounted.
            return null;
        }
        File dir = new File(context.getExternalFilesDir(type), path);
        FileUtils.makeDirsIfNeeded(dir);
        File file = new File(dir, filename);
        if (!storeAsFile(bitmap, file, format, quality)) {
            return null;
        }
        return file;
    }

    public static final File storeOnCacheDir(Context context, Bitmap bitmap, String path, String filename, Bitmap.CompressFormat format, int quality) {
        File dir = new File(context.getCacheDir(), path);
        FileUtils.makeDirsIfNeeded(dir);
        File file = new File(dir, filename);
        if (!storeAsFile(bitmap, file, format, quality)) {
            return null;
        }
        return file;
    }

    public static final boolean storeOnApplicationPrivateDir(Context context, Bitmap bitmap, String filename, Bitmap.CompressFormat format, int quality) {
        OutputStream out = null;
        try {
            out = new BufferedOutputStream(context.openFileOutput(filename, Context.MODE_PRIVATE));
            return bitmap.compress(format, quality, out);
        } catch (FileNotFoundException e) {
            Log.e(TAG, "no such file for saving bitmap: ", e);
            return false;
        } finally {
            CloseableUtils.close(out);
        }
    }

    public static final boolean storeAsFile(Bitmap bitmap, File file, Bitmap.CompressFormat format, int quality) {
        OutputStream out = null;
        try {
            out = new BufferedOutputStream(new FileOutputStream(file));
            return bitmap.compress(format, quality, out);
        } catch (FileNotFoundException e) {
            Log.e(TAG, "no such file for saving bitmap: ", e);
            return false;
        } finally {
           CloseableUtils.close(out);
        }
    }
}