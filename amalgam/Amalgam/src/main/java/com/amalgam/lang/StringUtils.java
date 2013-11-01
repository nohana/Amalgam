package com.amalgam.lang;

/**
 * Created by keishin.yokomaku on 2013/11/01.
 */
public final class StringUtils {
    private StringUtils() {}

    public static final String byteToHex(byte[] data) {
        if (data == null) {
            return null;
        }
        final StringBuilder builder = new StringBuilder();
        for (final byte b : data) {
            builder.append(String.format("%02X", b));
        }
        return builder.toString();
    }
}
