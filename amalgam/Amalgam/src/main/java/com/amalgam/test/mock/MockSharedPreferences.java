package com.amalgam.test.mock;

import android.content.SharedPreferences;

import java.util.Map;
import java.util.Set;

/**
 * Mock implementation for {@link SharedPreferences}.
 * All of the method call will throw {@link UnsupportedOperationException}.
 * @author keishin.yokomaku
 */
public class MockSharedPreferences implements SharedPreferences {
    @Override
    public boolean contains(String key) {
        throw new UnsupportedOperationException();
    }
    @Override
    public Editor edit() {
        throw new UnsupportedOperationException();
    }
    @Override
    public Map<String, ?> getAll() {
        throw new UnsupportedOperationException();
    }
    @Override
    public boolean getBoolean(String key, boolean defValue) {
        throw new UnsupportedOperationException();
    }
    @Override
    public float getFloat(String key, float defValue) {
        throw new UnsupportedOperationException();
    }
    @Override
    public int getInt(String key, int defValue) {
        throw new UnsupportedOperationException();
    }
    @Override
    public long getLong(String key, long defValue) {
        throw new UnsupportedOperationException();
    }
    @Override
    public String getString(String key, String defValue) {
        throw new UnsupportedOperationException();
    }
    @Override
    public Set<String> getStringSet(String arg0, Set<String> arg1) {
        throw new UnsupportedOperationException();
    }
    @Override
    public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {
        throw new UnsupportedOperationException();
    }
    @Override
    public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {
        throw new UnsupportedOperationException();
    }
    public static class MockEditor implements Editor {
        @Override
        public void apply() {
            throw new UnsupportedOperationException();
        }
        @Override
        public Editor clear() {
            throw new UnsupportedOperationException();
        }
        @Override
        public boolean commit() {
            throw new UnsupportedOperationException();
        }
        @Override
        public Editor putBoolean(String key, boolean value) {
            throw new UnsupportedOperationException();
        }
        @Override
        public Editor putFloat(String key, float value) {
            throw new UnsupportedOperationException();
        }
        @Override
        public Editor putInt(String key, int value) {
            throw new UnsupportedOperationException();
        }
        @Override
        public Editor putLong(String key, long value) {
            throw new UnsupportedOperationException();
        }
        @Override
        public Editor putString(String key, String value) {
            throw new UnsupportedOperationException();
        }
        @Override
        public Editor putStringSet(String arg0, Set<String> arg1) {
            throw new UnsupportedOperationException();
        }
        @Override
        public Editor remove(String key) {
            throw new UnsupportedOperationException();
        }
    }
}