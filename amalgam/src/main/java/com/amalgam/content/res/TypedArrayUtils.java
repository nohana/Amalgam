package com.amalgam.content.res;

import android.content.res.TypedArray;

/**
 * @author KeithYokoma
 */
@SuppressWarnings("unused") // public APIs
public final class TypedArrayUtils {
    private TypedArrayUtils() {
        throw new AssertionError();
    }

    public static void recycle(TypedArray array) {
        if (array == null)
            return;
        array.recycle();
    }
}
