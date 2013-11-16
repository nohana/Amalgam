package com.amalgam.io;

import java.io.File;

/**
 * Created by yokomakukeishin on 2013/11/16.
 */
public final class FileUtils {
    private FileUtils() {}

    public static final boolean makeDirsIfNeeded(File dir) {
        if (dir.exists()) {
            return false;
        }
        return dir.mkdirs();
    }
}
