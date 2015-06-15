package com.amalgam.content.res;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.support.annotation.DrawableRes;

import static android.content.ContentResolver.SCHEME_ANDROID_RESOURCE;

/**
 * @author KeithYokoma
 */
public class ResourcesUtils {
    private ResourcesUtils() {
        throw new AssertionError();
    }

    public static Uri getResourceUri(Context context, @DrawableRes int resId) {
        Resources resources = context.getResources();
        return new Uri.Builder().scheme(SCHEME_ANDROID_RESOURCE)
                .authority(resources.getResourcePackageName(resId))
                .appendPath(resources.getResourceTypeName(resId))
                .appendPath(resources.getResourceEntryName(resId))
                .build();
    }

    public static Uri getExternalResourceUri(String packageName, @DrawableRes int resId) {
        return new Uri.Builder().scheme(SCHEME_ANDROID_RESOURCE)
                .authority(packageName)
                .appendPath(Integer.toString(resId))
                .build();
    }
}
