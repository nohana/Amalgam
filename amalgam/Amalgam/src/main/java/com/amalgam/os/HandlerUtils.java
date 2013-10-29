package com.amalgam.os;

import android.os.Handler;
import android.os.Looper;

public final class HandlerUtils {
    private HandlerUtils() {}

    public static final Handler getMainHandler() {
        return new Handler(Looper.getMainLooper());
    }
}