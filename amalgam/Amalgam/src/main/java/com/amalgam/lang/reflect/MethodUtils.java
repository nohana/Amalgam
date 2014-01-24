package com.amalgam.lang.reflect;

/**
 * @author keishin.yokomaku
 */
@SuppressWarnings("unused") // public APIs
public final class MethodUtils {
    public static final String TAG = MethodUtils.class.getSimpleName();

    public static <T> void ensureArgumentNotNull(T arg) {
        if (arg == null) {
            throw new NullPointerException("the argument should not be null");
        }
    }
}