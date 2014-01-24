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
package com.amalgam.io;

import android.util.Log;

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