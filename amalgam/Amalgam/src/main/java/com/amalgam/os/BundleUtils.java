package com.amalgam.os;

public final class BundleUtils {
    private BundleUtils() {}

    public static final String buildKey(Class<?> clazz, String name) {
        return new StringBuilder().append(clazz.getCanonicalName()).append(".").append(name).toString();
    }
}