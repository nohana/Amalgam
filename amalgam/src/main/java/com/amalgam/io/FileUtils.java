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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * Utility for the {@link java.io.File}.
 */
@SuppressWarnings("unused") // public APIs
public final class FileUtils {
    private FileUtils() {}

    /**
     * Create a new directory if not exists.
     * @param dir to create.
     * @return true if already exists, or newly created.
     */
    public static boolean makeDirsIfNeeded(File dir) {
        return dir.exists() || dir.mkdirs();
    }

    /**
     * Copy the file from the source to the destination.
     * @param source the source file to be copied.
     * @param destination the destination file to copy.
     * @see java.nio.channels.FileChannel#transferTo(long, long, java.nio.channels.WritableByteChannel).
     * @return the transferred byte count.
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static long copy(File source, File destination) throws FileNotFoundException, IOException {
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream(source);
            out = new FileOutputStream(destination);
            return copy(in, out);
        } finally {
            CloseableUtils.close(in);
            CloseableUtils.close(out);
        }
    }

    /**
     * Copy the file using streams.
     * @param in source.
     * @param out destination.
     * @see java.nio.channels.FileChannel#transferTo(long, long, java.nio.channels.WritableByteChannel)
     * @return the transferred byte count.
     * @throws IOException
     */
    public static long copy(FileInputStream in, FileOutputStream out) throws IOException {
        FileChannel source = null;
        FileChannel destination = null;
        try {
            source = in.getChannel();
            destination = out.getChannel();
            return source.transferTo(0, source.size(), destination);
        } finally {
            CloseableUtils.close(source);
            CloseableUtils.close(destination);
        }
    }
}