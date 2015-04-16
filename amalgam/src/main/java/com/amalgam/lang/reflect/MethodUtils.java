package com.amalgam.lang.reflect;

import java.lang.reflect.Method;

/**
 * Utility for the {@link java.lang.reflect.Method}.
 * @author KeithYokoma
 */
@SuppressWarnings("unused") // public APIs
public final class MethodUtils {
    public static final String TAG = MethodUtils.class.getSimpleName();

    private MethodUtils() {
        throw new AssertionError();
    }

    /**
     * Precondition checks to ensure the argument is not null.
     * @param arg to check.
     * @param <T> any type.
     * @throws java.lang.NullPointerException if the argument is null.
     */
    public static <T> void ensureArgumentNotNull(T arg) {
        if (arg == null) {
            throw new NullPointerException("the argument should not be null");
        }
    }
}