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

@SuppressWarnings("unused") // Public APIs
public final class BitmapUtils {
    public static final String TAG = BitmapUtils.class.getSimpleName();

    private BitmapUtils() {}

    public static void recycle(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        bitmap.recycle();
    }

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

    public static Point getSize(File path) {
        return getSize(path.getAbsolutePath());
    }

    public static Point getSize(String path) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);
        int width = options.outWidth;
        int height = options.outHeight;
        return new Point(width, height);
    }

    public static Point getSize(byte[] byteArray) {
        return getSize(byteArray, 0, byteArray.length);
    }

    public static Point getSize(byte[] byteArray, int offset, int length) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(byteArray, offset, length, options);
        int width = options.outWidth;
        int height = options.outHeight;
        return new Point(width, height);
    }

    public static Point getSize(Context context, int resId) {
        return getSize(context.getResources(), resId);
    }

    public static Point getSize(Resources res, int resId) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);
        int width = options.outWidth;
        int height = options.outHeight;
        return new Point(width, height);
    }

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

    public static Bitmap shrink(Bitmap bitmap, float scale) {
        if (scale >= 1.0f) {
            return bitmap.copy(bitmap.getConfig(), false);
        }

        Matrix matrix = new Matrix();
        matrix.postScale(scale, scale);

        return Bitmap.createBitmap(bitmap, 0, 0, (int) (scale * bitmap.getWidth()), (int) (scale * bitmap.getHeight()), matrix, true);
    }

    public static Bitmap expand(Bitmap bitmap, float scale) {
        if (scale <= 1.0f) {
            return bitmap.copy(bitmap.getConfig(), false);
        }

        Matrix matrix = new Matrix();
        matrix.postScale(scale, scale);

        return Bitmap.createBitmap(bitmap, 0, 0, (int) (scale * bitmap.getWidth()), (int) (scale * bitmap.getHeight()), matrix, true);
    }

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

    public static File storeOnCacheDir(Context context, Bitmap bitmap, String path, String filename, Bitmap.CompressFormat format, int quality) {
        File dir = new File(context.getCacheDir(), path);
        FileUtils.makeDirsIfNeeded(dir);
        File file = new File(dir, filename);
        if (!storeAsFile(bitmap, file, format, quality)) {
            return null;
        }
        return file;
    }

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