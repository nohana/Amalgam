package com.amalgam.app;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.os.Build;

/**
 * @author KeithYokoma
 */
@SuppressWarnings("unused")
public final class FragmentUtils {
    private FragmentUtils() {
        throw new AssertionError();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static void invalidateOptionsMenu(android.app.Fragment fragment) {
        fragment.getActivity().invalidateOptionsMenu();
    }

    public static void supportInvalidateOptionsMenu(android.support.v4.app.Fragment fragment) {
        fragment.getActivity().supportInvalidateOptionsMenu();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public static ContentResolver getContentResolver(android.app.Fragment fragment) {
        return fragment.getActivity().getContentResolver();
    }

    public static ContentResolver getContentResolver(android.support.v4.app.Fragment fragment) {
        return fragment.getActivity().getContentResolver();
    }
}
