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

import java.io.Closeable;
import java.io.IOException;

/**
 * Utility for the {@link java.io.Closeable}.
 */
@SuppressWarnings("unused") // public APIs
public final class CloseableUtils {
    private static final String TAG = CloseableUtils.class.getSimpleName();
    private CloseableUtils() {}

    /**
     * Close closeable like i/o streams quietly.
     * Do NOT close {@link android.database.Cursor} with this method, or will cause crashing on some device.
     * @param closeable to close.
     */
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