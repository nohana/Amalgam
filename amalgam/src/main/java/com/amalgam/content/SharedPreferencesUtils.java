package com.amalgam.content;

import android.content.SharedPreferences;
import android.text.TextUtils;

/**
 * Utility for the {@link android.content.SharedPreferences}.
 * @author KeishinYokomaku
 */
@SuppressWarnings("unused")
public final class SharedPreferencesUtils {
    private SharedPreferencesUtils() {
        throw new AssertionError();
    }

    /**
     * Retrieve a double value from the preferences.
     * @param preferences the preferences
     * @param key the key
     * @param defaultValue default value if the key is not present
     * @return the double value.
     */
    public static double getDouble(SharedPreferences preferences, String key, double defaultValue) {
        String stored = preferences.getString(key, null);
        if (TextUtils.isEmpty(stored)) {
            return defaultValue;
        }
        return Double.parseDouble(stored);
    }

    /**
     * Set a double value in the preferences editor.
     * @see android.content.SharedPreferences.Editor
     * @param editor the editor
     * @param key The name of the preference to modify.
     * @param value The new value for the preference.
     * @return the editor.
     */
    public static SharedPreferences.Editor putDouble(SharedPreferences.Editor editor, String key, double value) {
        return editor.putString(key, String.valueOf(value));
    }
}
