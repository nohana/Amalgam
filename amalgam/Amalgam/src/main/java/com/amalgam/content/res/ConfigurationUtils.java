package com.amalgam.content.res;

import android.content.res.Configuration;

/**
 * Utiity for the {@link android.content.res.Configuration}.
 */
@SuppressWarnings("unused") // public APIs
public final class ConfigurationUtils {
    private ConfigurationUtils() {
        throw new AssertionError();
    }

    /**
     * Checks if the current screen configuration is landscape.
     * @param configuration the configuration.
     * @return true if the screen is landscape.
     */
    public static boolean isLandscape(Configuration configuration) {
        return configuration.orientation == Configuration.ORIENTATION_LANDSCAPE;
    }

    /**
     * Checks if the current screen configuration is portrait.
     * @param configuration the configuration.
     * @return true if the screen is portrait.
     */
    public static boolean isPortrait(Configuration configuration) {
        return configuration.orientation == Configuration.ORIENTATION_PORTRAIT;
    }
}
