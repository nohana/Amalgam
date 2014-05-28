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

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Log;

import com.amalgam.io.CloseableUtils;
import com.amalgam.io.FileUtils;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Utility for the {@link android.graphics.Bitmap}.
 */
@SuppressWarnings("unused") // Public APIs
public final class BitmapUtils {
    public static final String TAG = BitmapUtils.class.getSimpleName();

    private BitmapUtils() {
        throw new AssertionError();
    }

    /**
     * Recycle the bitmap with null checks.
     * If the bitmap is already recycled, do nothing.
     * @param bitmap to recycle.
     */
    public static void recycle(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        bitmap.recycle();
    }

    /**
     * Get width and height of the bitmap specified with the {@link android.net.Uri}.
     * @param resolver the resolver.
     * @param uri the uri that points to the bitmap.
     * @return the size.
     */
    public static Point getSize(ContentResolver resolver, Uri uri) {
        InputStream is = null;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            is = resolver.openInputStream(uri);
            BitmapFactory.decodeStream(is, null, options);
            int width = options.outWidth;
            int height = options.outHeight;
            return new Point(width, height);
        } catch (FileNotFoundException e) {
            Log.e(TAG, "target file (" + uri + ") does not exist.", e);
            return null;
        } finally {
            CloseableUtils.close(is);
        }
    }

    /**
     * Get width and height of the bitmap specified with the {@link java.io.File}.
     * @param path the bitmap file path.
     * @return the size.
     */
    public static Point getSize(File path) {
        return getSize(path.getAbsolutePath());
    }

    /**
     * Get width and height of the bitmap specified with the file path.
     * @param path the bitmap file path.
     * @return the size.
     */
    public static Point getSize(String path) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);
        int width = options.outWidth;
        int height = options.outHeight;
        return new Point(width, height);
    }

    /**
     * Get width and height of the bitmap specified with the byte array.
     * @param byteArray the bitmap itself.
     * @return the size.
     */
    public static Point getSize(byte[] byteArray) {
        return getSize(byteArray, 0, byteArray.length);
    }

    /**
     * Get width and height of the bitmap specified with the byte array.
     * @param byteArray the bitmap itself.
     * @param offset offset index.
     * @param length array length.
     * @return the size.
     */
    public static Point getSize(byte[] byteArray, int offset, int length) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(byteArray, offset, length, options);
        int width = options.outWidth;
        int height = options.outHeight;
        return new Point(width, height);
    }

    /**
     * Get width and height of the bitmap specified with the resource id.
     * @param context the context.
     * @param resId the resource id of the drawable.
     * @return the drawable bitmap size.
     */
    public static Point getSize(Context context, int resId) {
        return getSize(context.getResources(), resId);
    }

    /**
     * Get width and height of the bitmap specified with the resource id.
     * @param res resource accessor.
     * @param resId the resource id of the drawable.
     * @return the drawable bitmap size.
     */
    public static Point getSize(Resources res, int resId) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);
        int width = options.outWidth;
        int height = options.outHeight;
        return new Point(width, height);
    }

    /**
     * Compress the bitmap to the byte array as the specified format and quality.
     * @param bitmap to compress.
     * @param format the format.
     * @param quality the quality of the compressed bitmap.
     * @return the compressed bitmap byte array.
     */
    public static byte[] toByteArray(Bitmap bitmap, Bitmap.CompressFormat format, int quality) {
        ByteArrayOutputStream out = null;
        try {
            out = new ByteArrayOutputStream();
            bitmap.compress(format, quality, out);
            return out.toByteArray();
        } finally {
            CloseableUtils.close(out);
        }
    }

    /**
     * Shrink the bitmap to the specified scale.
     * @param bitmap to shrink.
     * @param scale the shrink scale, must be < 1.0.
     * @return the shrunk bitmap.
     */
    public static Bitmap shrink(Bitmap bitmap, float scale) {
        if (scale >= 1.0f) {
            return bitmap.copy(bitmap.getConfig(), false);
        }

        Matrix matrix = new Matrix();
        matrix.postScale(scale, scale);

        return Bitmap.createBitmap(bitmap, 0, 0, (int) (scale * bitmap.getWidth()), (int) (scale * bitmap.getHeight()), matrix, true);
    }

    /**
     * Expand the bitmap to the specified scale.
     * @param bitmap to expand.
     * @param scale the expand scale, must be > 1.0.
     * @return the expanded bitmap.
     */
    public static Bitmap expand(Bitmap bitmap, float scale) {
        if (scale <= 1.0f) {
            return bitmap.copy(bitmap.getConfig(), false);
        }

        Matrix matrix = new Matrix();
        matrix.postScale(scale, scale);

        return Bitmap.createBitmap(bitmap, 0, 0, (int) (scale * bitmap.getWidth()), (int) (scale * bitmap.getHeight()), matrix, true);
    }

    /**
     * Store the bitmap on the external storage path.
     * @param context the context.
     * @param bitmap to store.
     * @param type type of the bitmap.
     * @param path file path.
     * @param filename file name.
     * @param format bitmap format.
     * @param quality the quality of the compressed bitmap.
     * @return the compressed bitmap file.
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public static File storeOnExternalStorage(Context context, Bitmap bitmap, String type, String path, String filename, Bitmap.CompressFormat format, int quality) {
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

    /**
     * Store the bitmap on the cache directory path.
     * @param context the context.
     * @param bitmap to store.
     * @param path file path.
     * @param filename file name.
     * @param format bitmap format.
     * @param quality the quality of the compressed bitmap.
     * @return the compressed bitmap file.
     */
    public static File storeOnCacheDir(Context context, Bitmap bitmap, String path, String filename, Bitmap.CompressFormat format, int quality) {
        File dir = new File(context.getCacheDir(), path);
        FileUtils.makeDirsIfNeeded(dir);
        File file = new File(dir, filename);
        if (!storeAsFile(bitmap, file, format, quality)) {
            return null;
        }
        return file;
    }

    /**
     * Store the bitmap on the application private directory path.
     * @param context the context.
     * @param bitmap to store.
     * @param filename file name.
     * @param format bitmap format.
     * @param quality the quality of the compressed bitmap.
     * @return the compressed bitmap file.
     */
    public static boolean storeOnApplicationPrivateDir(Context context, Bitmap bitmap, String filename, Bitmap.CompressFormat format, int quality) {
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

    /**
     * Store the bitmap as a file.
     * @param bitmap to store.
     * @param format bitmap format.
     * @param quality the quality of the compressed bitmap.
     * @return the compressed bitmap file.
     */
    public static boolean storeAsFile(Bitmap bitmap, File file, Bitmap.CompressFormat format, int quality) {
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