package com.amalgam.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public final class FileUtils {
    private FileUtils() {}

    public static final boolean makeDirsIfNeeded(File dir) {
        if (dir.exists()) {
            return false;
        }
        return dir.mkdirs();
    }

    public static final long copy(File source, File destination) throws FileNotFoundException, IOException {
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

    public static final long copy(FileInputStream in, FileOutputStream out) throws IOException {
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