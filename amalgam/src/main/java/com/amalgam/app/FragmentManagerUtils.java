package com.amalgam.app;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;

/**
 * Utility for the {@link android.app.FragmentManager} and {@link android.support.v4.app.FragmentManager}.
 * @author KeithYokoma
 */
public final class FragmentManagerUtils {
    private FragmentManagerUtils() {
        throw new AssertionError();
    }

    /**
     * Find a fragment that is under {@link android.app.FragmentManager}'s control by the id.
     * @param manager the fragment manager.
     * @param id the fragment id.
     * @param <F> the concrete fragment class parameter.
     * @return the fragment.
     */
    @SuppressWarnings("unchecked") // we know that the returning fragment is child of fragment.
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static <F extends android.app.Fragment> F findFragmentById(android.app.FragmentManager manager, int id) {
        return (F) manager.findFragmentById(id);
    }

    /**
     * Find a fragment that is under {@link android.support.v4.app.FragmentManager}'s control by the id.
     * @param manager the fragment manager.
     * @param id the fragment id.
     * @param <F> the concrete fragment class parameter.
     * @return the fragment.
     */
    @SuppressWarnings("unchecked") // we know that the returning fragment is child of fragment.
    public static <F extends android.support.v4.app.Fragment> F supportFindFragmentById(android.support.v4.app.FragmentManager manager, int id) {
        return (F) manager.findFragmentById(id);
    }

    /**
     * Find a fragment that is under {@link android.app.FragmentManager}'s control.
     * @param manager the fragment manager.
     * @param tag the fragment tag.
     * @param <F> the concrete fragment class parameter.
     * @return the fragment.
     */
    @SuppressWarnings("unchecked") // we know that the returning fragment is child of fragment by the tag string.
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static <F extends android.app.Fragment> F findFragmentByTag(android.app.FragmentManager manager, String tag) {
        return (F) manager.findFragmentByTag(tag);
    }

    /**
     * Find a fragment that is under {@link android.support.v4.app.FragmentManager}'s control by the tag string.
     * @param manager the fragment manager.
     * @param tag the fragment tag.
     * @param <F> the concrete fragment class parameter.
     * @return the fragment.
     */
    @SuppressWarnings("unchecked") // we know that the returning fragment is child of fragment.
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static <F extends android.support.v4.app.Fragment> F supportFindFragmentByTag(android.support.v4.app.FragmentManager manager, String tag) {
        return (F) manager.findFragmentByTag(tag);
    }
}
