package com.amalgam.content.res;

import android.content.res.Configuration;

/**
 */
public final class ConfigurationUtils {
    private ConfigurationUtils() {}

    public static final boolean isLandscape(Configuration configuration) {
        return configuration.orientation == Configuration.ORIENTATION_LANDSCAPE;
    }

    public static final boolean isPortrait(Configuration configuration) {
        return configuration.orientation == Configuration.ORIENTATION_PORTRAIT;
    }
}
