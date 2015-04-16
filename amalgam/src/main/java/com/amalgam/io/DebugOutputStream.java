/*
 * Copyright (C) 2013 KeithYokoma. All rights reserved.
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
import java.io.OutputStream;

/**
 * Print buffer onto android logcat on read stream for debugging.
 * @author KeithYokoma
 */
@SuppressWarnings("unused") // public APIs
public class DebugOutputStream extends OutputStream {
    public static final String TAG = DebugOutputStream.class.getSimpleName();
    private OutputStream mStream;

    public DebugOutputStream(OutputStream stream) {
        mStream = stream;
    }

    @Override
    public void write(int oneByte) throws IOException {
        mStream.write(oneByte);
    }

    @Override
    public void write(byte[] buffer, int offset, int count) throws IOException {
        Log.w(TAG, new String(buffer, offset, count));
        super.write(buffer, offset, count);
    }
    @Override
    public void close() throws IOException {
        mStream.close();
    }
}