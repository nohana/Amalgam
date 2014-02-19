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

import java.io.IOException;
import java.io.InputStream;

/**
 * Print buffer onto android logcat on read stream for debugging.
 * @author KeithYokoma
 *
 */
@SuppressWarnings("unused") // public APIs
public class DebugInputStream extends InputStream {
    public static final String TAG = DebugInputStream.class.getSimpleName();
    private InputStream mStream;

    public DebugInputStream(InputStream stream) {
        mStream = stream;
    }

    @Override
    public int read() throws IOException {
        return mStream.read();
    }

    @Override
    public int read(byte[] buffer, int offset, int length) throws IOException {
        int ret = super.read(buffer, offset, length);
        if (ret > 0) {
            Log.v(TAG, new String(buffer, offset, ret, "UTF-8"));
        }
        return ret;
    }

    @Override
    public void close() throws IOException {
        mStream.close();
    }
}