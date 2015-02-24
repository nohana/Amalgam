package com.amalgam.lang.ref;

import java.lang.ref.WeakReference;

/**
 * @author KeithYokoma
 */
@SuppressWarnings("unused")
public final class WeakReferenceUtils {
    private WeakReferenceUtils() {
        throw new AssertionError();
    }

    public static <T> T tryGet(WeakReference<T> ref) {
            return ref != null ? ref.get() : null;
        }
}
