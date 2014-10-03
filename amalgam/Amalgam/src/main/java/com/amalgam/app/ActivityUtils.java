package com.amalgam.app;

import android.app.Activity;
import android.view.View;

/**
 * Utility for the {@link android.app.Activity}
 */
public final class ActivityUtils {
    private ActivityUtils() {
        throw new AssertionError();
    }

    /**
     * Find the specific view from the activity.
     * Returning value type is bound to your variable type.
     *
     * @param activity the activity.
     * @param id the view id.
     * @param <V> the view class type parameter.
     * @return the view, null if not found.
     */
    @SuppressWarnings("unchecked") // we know that return value type is a child of view, and V is bound to a child of view.
    public static <V extends View> V findViewById(Activity activity, int id) {
        return (V) activity.findViewById(id);
    }
}
