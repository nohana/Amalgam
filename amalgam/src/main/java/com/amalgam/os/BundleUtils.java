/*
 * Copyright (C) 2013 nohana, Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.amalgam.os;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

/**
 * Utility for the {@link android.os.Bundle}.
 */
@SuppressWarnings("unused") // public APIs
public final class BundleUtils {
    private BundleUtils() {
        throw new AssertionError();
    }

    /**
     * Build a custom bundle key name, to avoid conflict the bundle key name among the activities.
     * This is also useful to build a intent extra key name.
     *
     * @param clazz the class.
     * @param name the key name, in most case the name is UPPER_UNDERSCORE.
     * @return the full qualified key name.
     */
    public static String buildKey(Class<?> clazz, String name) {
        return new StringBuilder().append(clazz.getCanonicalName()).append(".").append(name).toString();
    }

    /**
     * Returns a optional {@link java.lang.Object} value. In other words, returns the value mapped by key if it exists and is a {@link java.lang.Object}.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return null.
     * @param key a key for the value.
     * @return a {@link java.lang.Object} value if exists, null otherwise.
     * @see android.os.Bundle#get(String)
     */
    @Nullable
    public static Object opt(@Nullable Bundle bundle, @Nullable String key) {
        return opt(bundle, key, null);
    }

    /**
     * Returns a optional {@link java.lang.Object} value. In other words, returns the value mapped by key if it exists and is a {@link java.lang.Object}.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return null.
     * @param key a key for the value.
     * @param fallback fallback value.
     * @return a {@link java.lang.Object} value if exists, null otherwise.
     * @see android.os.Bundle#get(String)
     */
    @Nullable
    public static Object opt(@Nullable Bundle bundle, @Nullable String key, @Nullable Object fallback) {
        if (bundle == null) {
            return fallback;
        }
        return bundle.get(key);
    }

    /**
     * Returns a optional {@link android.os.IBinder} value. In other words, returns the value mapped by key if it exists and is a {@link android.os.IBinder}.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return null.
     * @param key a key for the value.
     * @return a {@link android.os.IBinder} value if exists, null otherwise.
     * @see android.os.Bundle#getBinder(String)
     */
    @Nullable
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    public static IBinder optBinder(@Nullable Bundle bundle, @Nullable String key) {
        return optBinder(bundle, key, null);
    }

    /**
     * Returns a optional {@link android.os.IBinder} value. In other words, returns the value mapped by key if it exists and is a {@link android.os.IBinder}.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return null.
     * @param key a key for the value.
     * @param fallback fallback value.
     * @return a {@link android.os.IBinder} value if exists, null otherwise.
     * @see android.os.Bundle#getBinder(String)
     */
    @Nullable
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    public static IBinder optBinder(@Nullable Bundle bundle, @Nullable String key, @Nullable IBinder fallback) {
        if (bundle == null) {
            return fallback;
        }
        return bundle.getBinder(key);
    }

    /**
     * Returns a optional boolean value. In other words, returns the value mapped by key if it exists and is a boolean.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns false.
     * @param bundle a bundle. If the bundle is null, this method will return false.
     * @param key a key for the value.
     * @return a boolean value if exists, false otherwise.
     * @see android.os.Bundle#getBoolean(String)
     */
    public static boolean optBoolean(@Nullable Bundle bundle, @Nullable String key) {
        return optBoolean(bundle, key, false);
    }

    /**
     * Returns a optional boolean value. In other words, returns the value mapped by key if it exists and is a boolean.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns a fallback value.
     * @param bundle a bundle. If the bundle is null, this method will return a fallback value.
     * @param key a key for the value.
     * @param fallback fallback value.
     * @return a boolean value if exists, fallback value otherwise.
     * @see android.os.Bundle#getBoolean(String, boolean)
     */
    public static boolean optBoolean(@Nullable Bundle bundle, @Nullable String key, boolean fallback) {
        if (bundle == null) {
            return fallback;
        }
        return bundle.getBoolean(key, fallback);
    }

    /**
     * Returns a optional boolean array value. In other words, returns the value mapped by key if it exists and is a boolean array.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return a fallback value.
     * @param key a key for the value.
     * @return a boolean array value if exists, null otherwise.
     * @see android.os.Bundle#getBooleanArray(String)
     */
    @Nullable
    public static boolean[] optBooleanArray(@Nullable Bundle bundle, @Nullable String key) {
        return optBooleanArray(bundle, key, new boolean[0]);
    }

    /**
     * Returns a optional boolean array value. In other words, returns the value mapped by key if it exists and is a boolean array.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return a fallback value.
     * @param key a key for the value.
     * @param fallback fallback value.
     * @return a boolean array value if exists, null otherwise.
     * @see android.os.Bundle#getBooleanArray(String)
     */
    @Nullable
    public static boolean[] optBooleanArray(@Nullable Bundle bundle, @Nullable String key, @Nullable boolean[] fallback) {
        if (bundle == null) {
            return fallback;
        }
        return bundle.getBooleanArray(key);
    }

    /**
     * Returns a optional {@link android.os.Bundle} value. In other words, returns the value mapped by key if it exists and is a {@link android.os.Bundle}.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return a fallback value.
     * @param key a key for the value.
     * @return a {@link android.os.Bundle} value if exists, null otherwise.
     * @see android.os.Bundle#getBundle(String)
     */
    @Nullable
    public static Bundle optBundle(@Nullable Bundle bundle, @Nullable String key) {
        return optBundle(bundle, key, new Bundle());
    }

    /**
     * Returns a optional {@link android.os.Bundle} value. In other words, returns the value mapped by key if it exists and is a {@link android.os.Bundle}.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return a fallback value.
     * @param key a key for the value.
     * @param fallback fallback value.
     * @return a {@link android.os.Bundle} value if exists, null otherwise.
     * @see android.os.Bundle#getBundle(String)
     */
    @Nullable
    public static Bundle optBundle(@Nullable Bundle bundle, @Nullable String key, @Nullable Bundle fallback) {
        if (bundle == null) {
            return fallback;
        }
        return bundle.getBundle(key);
    }

    /**
     * Returns a optional byte value. In other words, returns the value mapped by key if it exists and is a byte.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns (byte) 0.
     * @param bundle a bundle. If the bundle is null, this method will return a fallback value.
     * @param key a key for the value.
     * @return a boolean value if exists, (byte) 0 otherwise.
     * @see android.os.Bundle#getByte(String)
     */
    public static byte optByte(@Nullable Bundle bundle, @Nullable String key) {
        return optByte(bundle, key, (byte) 0);
    }

    /**
     * Returns a optional byte value. In other words, returns the value mapped by key if it exists and is a byte.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns a fallback value.
     * @param bundle a bundle. If the bundle is null, this method will return a fallback value.
     * @param key a key for the value.
     * @param fallback fallback value.
     * @return a byte value if exists, fallback value otherwise.
     * @see android.os.Bundle#getByte(String, byte)
     */
    public static byte optByte(@Nullable Bundle bundle, @Nullable String key, byte fallback) {
        if (bundle == null) {
            return fallback;
        }
        return bundle.getByte(key, fallback);
    }

    /**
     * Returns a optional byte array value. In other words, returns the value mapped by key if it exists and is a byte array.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return a fallback value.
     * @param key a key for the value.
     * @return a byte array value if exists, null otherwise.
     * @see android.os.Bundle#getByteArray(String)
     */
    @Nullable
    public static byte[] optByteArray(@Nullable Bundle bundle, @Nullable String key) {
        return optByteArray(bundle, key, new byte[0]);
    }

    /**
     * Returns a optional byte array value. In other words, returns the value mapped by key if it exists and is a byte array.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return a fallback value.
     * @param key a key for the value.
     * @param fallback fallback value.
     * @return a byte array value if exists, null otherwise.
     * @see android.os.Bundle#getByteArray(String)
     */
    @Nullable
    public static byte[] optByteArray(@Nullable Bundle bundle, @Nullable String key, @Nullable byte[] fallback) {
        if (bundle == null) {
            return fallback;
        }
        return bundle.getByteArray(key);
    }

    /**
     * Returns a optional char value. In other words, returns the value mapped by key if it exists and is a char.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns (char) 0.
     * @param bundle a bundle. If the bundle is null, this method will return null.
     * @param key a key for the value.
     * @return a char value if exists, (char) 0 otherwise.
     * @see android.os.Bundle#getChar(String)
     */
    public static char optChar(@Nullable Bundle bundle, @Nullable String key) {
        return optChar(bundle, key, (char) 0);
    }

    /**
     * Returns a optional char value. In other words, returns the value mapped by key if it exists and is a char.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns a fallback value.
     * @param bundle a bundle. If the bundle is null, this method will return null.
     * @param key a key for the value.
     * @param fallback fallback value
     * @return a char value if exists, fallback value otherwise.
     * @see android.os.Bundle#getChar(String, char)
     */
    public static char optChar(@Nullable Bundle bundle, @Nullable String key, char fallback) {
        if (bundle == null) {
            return fallback;
        }
        return bundle.getChar(key, fallback);
    }

    /**
     * Returns a optional char array value. In other words, returns the value mapped by key if it exists and is a char array.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return null.
     * @param key a key for the value.
     * @return a char value if exists, null otherwise.
     * @see android.os.Bundle#getCharArray(String)
     */
    @Nullable
    public static char[] optCharArray(@Nullable Bundle bundle, @Nullable String key) {
        return optCharArray(bundle, key, new char[0]);
    }

    /**
     * Returns a optional char array value. In other words, returns the value mapped by key if it exists and is a char array.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return null.
     * @param key a key for the value.
     * @param fallback fallback value.
     * @return a char value if exists, null otherwise.
     * @see android.os.Bundle#getCharArray(String)
     */
    @Nullable
    public static char[] optCharArray(@Nullable Bundle bundle, @Nullable String key, @Nullable char[] fallback) {
        if (bundle == null) {
            return fallback;
        }
        return bundle.getCharArray(key);
    }

    /**
     * Returns a optional {@link CharSequence} value. In other words, returns the value mapped by key if it exists and is a {@link CharSequence}.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return null.
     * @param key a key for the value.
     * @return a {@link CharSequence} value if exists, null otherwise.
     * @see android.os.Bundle#getCharSequence(String)
     */
    @Nullable
    public static CharSequence optCharSequence(@Nullable Bundle bundle, @Nullable String key) {
        return optCharSequence(bundle, key, null);
    }

    /**
     * Returns a optional {@link CharSequence} value. In other words, returns the value mapped by key if it exists and is a {@link CharSequence}.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns a fallback value.
     * @param bundle a bundle. If the bundle is null, this method will return a fallback value.
     * @param key a key for the value.
     * @param fallback fallback value.
     * @return a {@link CharSequence} value if exists, fallback value otherwise.
     * @see android.os.Bundle#getCharSequence(String, CharSequence)
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    public static CharSequence optCharSequence(@Nullable Bundle bundle, @Nullable String key, @Nullable CharSequence fallback) {
        if (bundle == null) {
            return fallback;
        }
        return bundle.getCharSequence(key, fallback);
    }

    /**
     * Returns a optional {@link CharSequence} array value. In other words, returns the value mapped by key if it exists and is a {@link CharSequence} array.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return null.
     * @param key a key for the value.
     * @return a {@link CharSequence} array value if exists, null otherwise.
     * @see android.os.Bundle#getCharSequenceArray(String)
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    @Nullable
    public static CharSequence[] optCharSequenceArray(@Nullable Bundle bundle, @Nullable String key) {
        return optCharSequenceArray(bundle, key, new CharSequence[0]);
    }

    /**
     * Returns a optional {@link CharSequence} array value. In other words, returns the value mapped by key if it exists and is a {@link CharSequence} array.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return null.
     * @param key a key for the value.
     * @param fallback fallback value.
     * @return a {@link CharSequence} array value if exists, null otherwise.
     * @see android.os.Bundle#getCharSequenceArray(String)
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    @Nullable
    public static CharSequence[] optCharSequenceArray(@Nullable Bundle bundle, @Nullable String key, @Nullable CharSequence[] fallback) {
        if (bundle == null) {
            return fallback;
        }
        return bundle.getCharSequenceArray(key);
    }

    /**
     * Returns a optional {@link CharSequence} {@link ArrayList} value. In other words, returns the value mapped by key if it exists and is a {@link CharSequence} {@link ArrayList}.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return null.
     * @param key a key for the value.
     * @return a {@link CharSequence} {@link ArrayList} value if exists, null otherwise.
     * @see android.os.Bundle#getCharSequenceArrayList(String)
     */
    // Since Bundle#getCharSequenceArrayList returns concrete ArrayList type, so this method follows that implementation.
    @TargetApi(Build.VERSION_CODES.FROYO)
    @Nullable
    public static ArrayList<CharSequence> optCharSequenceArrayList(@Nullable Bundle bundle, @Nullable String key) {
        return optCharSequenceArrayList(bundle, key, new ArrayList<CharSequence>());
    }

    /**
     * Returns a optional {@link CharSequence} {@link ArrayList} value. In other words, returns the value mapped by key if it exists and is a {@link CharSequence} {@link ArrayList}.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return null.
     * @param key a key for the value.
     * @param fallback fallback value.
     * @return a {@link CharSequence} {@link ArrayList} value if exists, null otherwise.
     * @see android.os.Bundle#getCharSequenceArrayList(String)
     */
    // Since Bundle#getCharSequenceArrayList returns concrete ArrayList type, so this method follows that implementation.
    @TargetApi(Build.VERSION_CODES.FROYO)
    @Nullable
    public static ArrayList<CharSequence> optCharSequenceArrayList(@Nullable Bundle bundle, @Nullable String key, @Nullable ArrayList<CharSequence> fallback) {
        if (bundle == null) {
            return fallback;
        }
        return bundle.getCharSequenceArrayList(key);
    }

    /**
     * Returns a optional double value. In other words, returns the value mapped by key if it exists and is a double.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns 0.0.
     * @param bundle a bundle. If the bundle is null, this method will return 0.0.
     * @param key a key for the value.
     * @return a double value if exists, 0.0 otherwise.
     * @see android.os.Bundle#getDouble(String)
     */
    public static double optDouble(@Nullable Bundle bundle, @Nullable String key) {
        return optDouble(bundle, key, 0.d);
    }

    /**
     * Returns a optional double value. In other words, returns the value mapped by key if it exists and is a double.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns a fallback value.
     * @param bundle a bundle. If the bundle is null, this method will return a fallback value.
     * @param key a key for the value.
     * @param fallback fallback value.
     * @return a double value if exists, fallback value otherwise.
     * @see android.os.Bundle#getDouble(String, double)
     */
    public static double optDouble(@Nullable Bundle bundle, @Nullable String key, double fallback) {
        if (bundle == null) {
            return 0.d;
        }
        return bundle.getDouble(key, fallback);
    }

    /**
     * Returns a optional double array value. In other words, returns the value mapped by key if it exists and is a double array.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return null.
     * @param key a key for the value.
     * @return a double array value if exists, null otherwise.
     * @see android.os.Bundle#getDoubleArray(String)
     */
    @Nullable
    public static double[] optDoubleArray(@Nullable Bundle bundle, @Nullable String key) {
        return optDoubleArray(bundle, key, new double[0]);
    }

    /**
     * Returns a optional double array value. In other words, returns the value mapped by key if it exists and is a double array.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return null.
     * @param key a key for the value.
     * @param fallback fallback value.
     * @return a double array value if exists, null otherwise.
     * @see android.os.Bundle#getDoubleArray(String)
     */
    @Nullable
    public static double[] optDoubleArray(@Nullable Bundle bundle, @Nullable String key, @Nullable double[] fallback) {
        if (bundle == null) {
            return fallback;
        }
        return bundle.getDoubleArray(key);
    }

    /**
     * Returns a optional float value. In other words, returns the value mapped by key if it exists and is a float.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns 0.0.
     * @param bundle a bundle. If the bundle is null, this method will return 0.0.
     * @param key a key for the value.
     * @return a float value if exists, 0.0 otherwise.
     * @see android.os.Bundle#getFloat(String)
     */
    public static float optFloat(@Nullable Bundle bundle, @Nullable String key) {
        return optFloat(bundle, key, 0.f);
    }

    /**
     * Returns a optional float value. In other words, returns the value mapped by key if it exists and is a float.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns a fallback value.
     * @param bundle a bundle. If the bundle is null, this method will return a fallback value.
     * @param key a key for the value.
     * @param fallback fallback value.
     * @return a float value if exists, fallback value otherwise.
     * @see android.os.Bundle#getFloat(String, float)
     */
    public static float optFloat(@Nullable Bundle bundle, @Nullable String key, float fallback) {
        if (bundle == null) {
            return fallback;
        }
        return bundle.getFloat(key, fallback);
    }

    /**
     * Returns a optional float array value. In other words, returns the value mapped by key if it exists and is a float array.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return null.
     * @param key a key for the value.
     * @return a float array value if exists, null otherwise.
     * @see android.os.Bundle#getFloatArray(String)
     */
    @Nullable
    public static float[] optFloatArray(@Nullable Bundle bundle, @Nullable String key) {
        return optFloatArray(bundle, key, new float[0]);
    }

    /**
     * Returns a optional float array value. In other words, returns the value mapped by key if it exists and is a float array.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return null.
     * @param key a key for the value.
     * @param fallback fallback value.
     * @return a float array value if exists, null otherwise.
     * @see android.os.Bundle#getFloatArray(String)
     */
    @Nullable
    public static float[] optFloatArray(@Nullable Bundle bundle, @Nullable String key, @Nullable float[] fallback) {
        if (bundle == null) {
            return fallback;
        }
        return bundle.getFloatArray(key);
    }

    /**
     * Returns a optional int value. In other words, returns the value mapped by key if it exists and is a int.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns 0.
     * @param bundle a bundle. If the bundle is null, this method will return 0.
     * @param key a key for the value.
     * @return a int value if exists, 0 otherwise.
     * @see android.os.Bundle#getInt(String)
     */
    public static int optInt(@Nullable Bundle bundle, @Nullable String key) {
        return optInt(bundle, key, 0);
    }

    /**
     * Returns a optional int value. In other words, returns the value mapped by key if it exists and is a int.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns a fallback value.
     * @param bundle a bundle. If the bundle is null, this method will return a fallback value.
     * @param key a key for the value.
     * @param fallback fallback value.
     * @return a int value if exists, fallback value otherwise.
     * @see android.os.Bundle#getInt(String, int)
     */
    public static int optInt(@Nullable Bundle bundle, @Nullable String key, int fallback) {
        if (bundle == null) {
            return fallback;
        }
        return bundle.getInt(key, fallback);
    }

    /**
     * Returns a optional int array value. In other words, returns the value mapped by key if it exists and is a int array.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return null.
     * @param key a key for the value.
     * @return a int array value if exists, null otherwise.
     * @see android.os.Bundle#getIntArray(String)
     */
    @Nullable
    public static int[] optIntArray(@Nullable Bundle bundle, @Nullable String key) {
        return optIntArray(bundle, key, new int[0]);
    }

    /**
     * Returns a optional int array value. In other words, returns the value mapped by key if it exists and is a int array.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return null.
     * @param key a key for the value.
     * @param fallback fallback value.
     * @return a int array value if exists, null otherwise.
     * @see android.os.Bundle#getIntArray(String)
     */
    @Nullable
    public static int[] optIntArray(@Nullable Bundle bundle, @Nullable String key, @Nullable int[] fallback) {
        if (bundle == null) {
            return fallback;
        }
        return bundle.getIntArray(key);
    }

    /**
     * Returns a optional {@link java.lang.Integer} {@link java.util.ArrayList}. In other words, returns the value mapped by key if it exists and is a {@link java.lang.Integer} {@link java.util.ArrayList}.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return null.
     * @param key a key for the value.
     * @return a {@link java.lang.Integer} {@link java.util.ArrayList} value if exists, null otherwise.
     * @see android.os.Bundle#getIntegerArrayList(String)
     */
    // Since Bundle#getIntegerArrayList returns concrete ArrayList type, so this method follows that implementation.
    @Nullable
    public static ArrayList<Integer> optIntegerArrayList(@Nullable Bundle bundle, @Nullable String key) {
        return optIntegerArrayList(bundle, key, new ArrayList<Integer>());
    }

    /**
     * Returns a optional {@link java.lang.Integer} {@link java.util.ArrayList}. In other words, returns the value mapped by key if it exists and is a {@link java.lang.Integer} {@link java.util.ArrayList}.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return null.
     * @param key a key for the value.
     * @param fallback fallback value.
     * @return a {@link java.lang.Integer} {@link java.util.ArrayList} value if exists, null otherwise.
     * @see android.os.Bundle#getIntegerArrayList(String)
     */
    // Since Bundle#getIntegerArrayList returns concrete ArrayList type, so this method follows that implementation.
    @Nullable
    public static ArrayList<Integer> optIntegerArrayList(@Nullable Bundle bundle, @Nullable String key, @Nullable ArrayList<Integer> fallback) {
        if (bundle == null) {
            return fallback;
        }
        return bundle.getIntegerArrayList(key);
    }

    /**
     * Returns a optional long value. In other words, returns the value mapped by key if it exists and is a long.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns 0.
     * @param bundle a bundle. If the bundle is null, this method will return 0.
     * @param key a key for the value.
     * @return a long value if exists, 0 otherwise.
     * @see android.os.Bundle#getLong(String)
     */
    public static long optLong(@Nullable Bundle bundle, @Nullable String key) {
        return optLong(bundle, key, 0L);
    }

    /**
     * Returns a optional long value. In other words, returns the value mapped by key if it exists and is a long.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns a fallback value.
     * @param bundle a bundle. If the bundle is null, this method will return a fallback value.
     * @param key a key for the value.
     * @param fallback fallback value.
     * @return a long value if exists, fallback value otherwise.
     * @see android.os.Bundle#getLong(String, long)
     */
    public static long optLong(@Nullable Bundle bundle, @Nullable String key, long fallback) {
        if (bundle == null) {
            return fallback;
        }
        return bundle.getLong(key, fallback);
    }

    /**
     * Returns a optional long array value. In other words, returns the value mapped by key if it exists and is a long array.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return null.
     * @param key a key for the value.
     * @return a long array value if exists, null otherwise.
     * @see android.os.Bundle#getInt(String, int)
     */
    @Nullable
    public static long[] optLongArray(@Nullable Bundle bundle, @Nullable String key) {
        return optLongArray(bundle, key, new long[0]);
    }

    /**
     * Returns a optional long array value. In other words, returns the value mapped by key if it exists and is a long array.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return null.
     * @param key a key for the value.
     * @param fallback fallback value.
     * @return a long array value if exists, null otherwise.
     * @see android.os.Bundle#getInt(String, int)
     */
    @Nullable
    public static long[] optLongArray(@Nullable Bundle bundle, @Nullable String key, @Nullable long[] fallback) {
        if (bundle == null) {
            return fallback;
        }
        return bundle.getLongArray(key);
    }

    /**
     * Returns a optional {@link android.os.Parcelable} value. In other words, returns the value mapped by key if it exists and is a {@link android.os.Parcelable}.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return null.
     * @param key a key for the value.
     * @return a {@link android.os.Parcelable} value if exists, null otherwise.
     * @see android.os.Bundle#getParcelable(String)
     */
    @Nullable
    public static <T extends Parcelable> T optParcelable(@Nullable Bundle bundle, @Nullable String key) {
        return optParcelable(bundle, key, null);
    }

    /**
     * Returns a optional {@link android.os.Parcelable} value. In other words, returns the value mapped by key if it exists and is a {@link android.os.Parcelable}.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return null.
     * @param key a key for the value.
     * @param fallback fallback value.
     * @return a {@link android.os.Parcelable} value if exists, null otherwise.
     * @see android.os.Bundle#getParcelable(String)
     */
    @Nullable
    public static <T extends Parcelable> T optParcelable(@Nullable Bundle bundle, @Nullable String key, @Nullable T fallback) {
        if (bundle == null) {
            return fallback;
        }
        return bundle.getParcelable(key);
    }

    /**
     * Returns a optional {@link android.os.Parcelable} array value. In other words, returns the value mapped by key if it exists and is a {@link android.os.Parcelable} array.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return null.
     * @param key a key for the value.
     * @return a {@link android.os.Parcelable} array value if exists, null otherwise.
     * @see android.os.Bundle#getParcelableArray(String)
     */
    @Nullable
    public static Parcelable[] optParcelableArray(@Nullable Bundle bundle, @Nullable String key) {
        return optParcelableArray(bundle, key, null);
    }

    /**
     * Returns a optional {@link android.os.Parcelable} array value. In other words, returns the value mapped by key if it exists and is a {@link android.os.Parcelable} array.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return null.
     * @param key a key for the value.
     * @param fallback fallback value.
     * @return a {@link android.os.Parcelable} array value if exists, null otherwise.
     * @see android.os.Bundle#getParcelableArray(String)
     */
    @Nullable
    public static Parcelable[] optParcelableArray(@Nullable Bundle bundle, @Nullable String key, @Nullable Parcelable[] fallback) {
        if (bundle == null) {
            return fallback;
        }
        return bundle.getParcelableArray(key);
    }

    /**
     * Returns a optional {@link android.os.Parcelable} {@link java.util.ArrayList}. In other words, returns the value mapped by key if it exists and is a {@link android.os.Parcelable} {@link java.util.ArrayList}.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return null.
     * @param key a key for the value.
     * @return a {@link android.os.Parcelable} {@link java.util.ArrayList} value if exists, null otherwise.
     * @see android.os.Bundle#getParcelableArrayList(String)
     */
    @Nullable
    // Since Bundle#getParcelableArrayList returns concrete ArrayList type, so this method follows that implementation.
    public static <T extends Parcelable> ArrayList<T> optParcelableArrayList(@Nullable Bundle bundle, @Nullable String key) {
        return optParcelableArrayList(bundle, key, new ArrayList<T>());
    }

    /**
     * Returns a optional {@link android.os.Parcelable} {@link java.util.ArrayList}. In other words, returns the value mapped by key if it exists and is a {@link android.os.Parcelable} {@link java.util.ArrayList}.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return null.
     * @param key a key for the value.
     * @param fallback fallback value.
     * @return a {@link android.os.Parcelable} {@link java.util.ArrayList} value if exists, null otherwise.
     * @see android.os.Bundle#getParcelableArrayList(String)
     */
    @Nullable
    // Since Bundle#getParcelableArrayList returns concrete ArrayList type, so this method follows that implementation.
    public static <T extends Parcelable> ArrayList<T> optParcelableArrayList(@Nullable Bundle bundle, @Nullable String key, @Nullable ArrayList<T> fallback) {
        if (bundle == null) {
            return fallback;
        }
        return bundle.getParcelableArrayList(key);
    }

    /**
     * Returns a optional {@link java.io.Serializable}. In other words, returns the value mapped by key if it exists and is a {@link java.io.Serializable}.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return null.
     * @param key a key for the value.
     * @return a {@link java.io.Serializable} {@link java.util.ArrayList} value if exists, null otherwise.
     * @see android.os.Bundle#getSerializable(String)
     */
    @Nullable
    @SuppressWarnings("unchecked") // Bundle#getSerializable(String) returns Serializable object so it is safe to cast to a type which extends Serializable.
    public static <T extends Serializable> T optSerializable(@Nullable Bundle bundle, @Nullable String key) {
        return optSerializable(bundle, key, null);
    }

    /**
     * Returns a optional {@link java.io.Serializable}. In other words, returns the value mapped by key if it exists and is a {@link java.io.Serializable}.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return null.
     * @param key a key for the value.
     * @param fallback fallback value.
     * @return a {@link java.io.Serializable} {@link java.util.ArrayList} value if exists, null otherwise.
     * @see android.os.Bundle#getSerializable(String)
     */
    @Nullable
    @SuppressWarnings("unchecked") // Bundle#getSerializable(String) returns Serializable object so it is safe to cast to a type which extends Serializable.
    public static <T extends Serializable> T optSerializable(@Nullable Bundle bundle, @Nullable String key, @Nullable T fallback) {
        if (bundle == null) {
            return fallback;
        }
        return (T) bundle.getSerializable(key);
    }


    /**
     * Returns a optional short value. In other words, returns the value mapped by key if it exists and is a short.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns (short) 0.
     * @param bundle a bundle. If the bundle is null, this method will return (short) 0.
     * @param key a key for the value.
     * @return a short value if exists, (short) 0 otherwise.
     * @see android.os.Bundle#getShort(String)
     */
    public static short optShort(@Nullable Bundle bundle, @Nullable String key) {
        return optShort(bundle, key, (short) 0);
    }

    /**
     * Returns a optional short value. In other words, returns the value mapped by key if it exists and is a short.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns a fallback value.
     * @param bundle a bundle. If the bundle is null, this method will return a fallback value.
     * @param key a key for the value.
     * @param fallback fallback value.
     * @return a short value if exists, fallback value otherwise.
     * @see android.os.Bundle#getShort(String, short)
     */
    public static short optShort(@Nullable Bundle bundle, @Nullable String key, short fallback) {
        if (bundle == null) {
            return fallback;
        }
        return bundle.getShort(key, fallback);
    }

    /**
     * Returns a optional short array value. In other words, returns the value mapped by key if it exists and is a short array.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return null.
     * @param key a key for the value.
     * @return a short array value if exists, null otherwise.
     * @see android.os.Bundle#getShort(String, short)
     */
    @Nullable
    public static short[] optShortArray(@Nullable Bundle bundle, @Nullable String key) {
        return optShortArray(bundle, key, new short[0]);
    }

    /**
     * Returns a optional short array value. In other words, returns the value mapped by key if it exists and is a short array.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return null.
     * @param key a key for the value.
     * @return a short array value if exists, null otherwise.
     * @see android.os.Bundle#getShort(String, short)
     */
    @Nullable
    public static short[] optShortArray(@Nullable Bundle bundle, @Nullable String key, @Nullable short[] fallback) {
        if (bundle == null) {
            return fallback;
        }
        return bundle.getShortArray(key);
    }

    /**
     * Returns a optional {@link android.util.Size} value. In other words, returns the value mapped by key if it exists and is a {@link android.util.Size}.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return null.
     * @param key a key for the value.
     * @return a {@link android.util.Size} value if exists, null otherwise.
     * @see android.os.Bundle#getSize(String)
     */
    @Nullable
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static Size optSize(@Nullable Bundle bundle, @Nullable String key) {
        return optSize(bundle, key, null);
    }

    /**
     * Returns a optional {@link android.util.Size} value. In other words, returns the value mapped by key if it exists and is a {@link android.util.Size}.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return null.
     * @param key a key for the value.
     * @param fallback fallback value.
     * @return a {@link android.util.Size} value if exists, null otherwise.
     * @see android.os.Bundle#getSize(String)
     */
    @Nullable
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static Size optSize(@Nullable Bundle bundle, @Nullable String key, @Nullable Size fallback) {
        if (bundle == null) {
            return fallback;
        }
        return bundle.getSize(key);
    }

    /**
     * Returns a optional {@link android.util.SizeF} value. In other words, returns the value mapped by key if it exists and is a {@link android.util.SizeF}.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return null.
     * @param key a key for the value.
     * @return a {@link android.util.SizeF} value if exists, null otherwise.
     * @see android.os.Bundle#getSizeF(String)
     */
    @Nullable
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static SizeF optSizeF(@Nullable Bundle bundle, @Nullable String key) {
        return optSizeF(bundle, key, null);
    }

    /**
     * Returns a optional {@link android.util.SizeF} value. In other words, returns the value mapped by key if it exists and is a {@link android.util.SizeF}.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return null.
     * @param key a key for the value.
     * @param fallback fallback value.
     * @return a {@link android.util.SizeF} value if exists, null otherwise.
     * @see android.os.Bundle#getSizeF(String)
     */
    @Nullable
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static SizeF optSizeF(@Nullable Bundle bundle, @Nullable String key, @Nullable SizeF fallback) {
        if (bundle == null) {
            return fallback;
        }
        return bundle.getSizeF(key);
    }

    /**
     * Returns a optional {@link android.util.SparseArray} value. In other words, returns the value mapped by key if it exists and is a {@link android.util.SparseArray}.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return null.
     * @param key a key for the value.
     * @return a {@link android.util.SparseArray} value if exists, null otherwise.
     * @see android.os.Bundle#getSparseParcelableArray(String)
     */
    @Nullable
    public static <T extends Parcelable> SparseArray<T> optSparseParcelableArray(@Nullable Bundle bundle, @Nullable String key) {
        return optSparseParcelableArray(bundle, key, new SparseArray<T>());
    }

    /**
     * Returns a optional {@link android.util.SparseArray} value. In other words, returns the value mapped by key if it exists and is a {@link android.util.SparseArray}.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return null.
     * @param key a key for the value.
     * @param fallback fallback value.
     * @return a {@link android.util.SparseArray} value if exists, null otherwise.
     * @see android.os.Bundle#getSparseParcelableArray(String)
     */
    @Nullable
    public static <T extends Parcelable> SparseArray<T> optSparseParcelableArray(@Nullable Bundle bundle, @Nullable String key, @Nullable SparseArray<T> fallback) {
        if (bundle == null) {
            return fallback;
        }
        return bundle.getSparseParcelableArray(key);
    }

    /**
     * Returns a optional {@link java.lang.String} value. In other words, returns the value mapped by key if it exists and is a {@link java.lang.String}.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return null.
     * @param key a key for the value.
     * @return a {@link java.lang.String} value if exists, null otherwise.
     * @see android.os.Bundle#getString(String)
     */
    @Nullable
    public static String optString(@Nullable Bundle bundle, @Nullable String key) {
        return optString(bundle, key, null);
    }

    /**
     * Returns a optional {@link java.lang.String} value. In other words, returns the value mapped by key if it exists and is a {@link java.lang.String}.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns a fallback value.
     * @param bundle a bundle. If the bundle is null, this method will return a fallback value.
     * @param key a key for the value.
     * @param fallback fallback value.
     * @return a {@link java.lang.String} value if exists, fallback value otherwise.
     * @see android.os.Bundle#getString(String, String)
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static String optString(@Nullable Bundle bundle, @Nullable String key, @Nullable String fallback) {
        if (bundle == null) {
            return fallback;
        }
        return bundle.getString(key, fallback);
    }

    /**
     * Returns a optional {@link java.lang.String} array value. In other words, returns the value mapped by key if it exists and is a {@link java.lang.String} array.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return null.
     * @param key a key for the value.
     * @return a {@link java.lang.String} array value if exists, null otherwise.
     * @see android.os.Bundle#getStringArray(String)
     */
    @Nullable
    public static String[] optStringArray(@Nullable Bundle bundle, @Nullable String key) {
        return optStringArray(bundle, key, new String[0]);
    }

    /**
     * Returns a optional {@link java.lang.String} array value. In other words, returns the value mapped by key if it exists and is a {@link java.lang.String} array.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return null.
     * @param key a key for the value.
     * @param fallback fallback value.
     * @return a {@link java.lang.String} array value if exists, null otherwise.
     * @see android.os.Bundle#getStringArray(String)
     */
    @Nullable
    public static String[] optStringArray(@Nullable Bundle bundle, @Nullable String key, @Nullable String[] fallback) {
        if (bundle == null) {
            return fallback;
        }
        return bundle.getStringArray(key);
    }

    /**
     * Returns a optional {@link java.lang.String} {@link java.util.ArrayList}. In other words, returns the value mapped by key if it exists and is a {@link java.lang.String} {@link java.util.ArrayList}.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return null.
     * @param key a key for the value.
     * @return a {@link java.lang.String} array value if exists, empty list if bundle is null, null otherwise.
     * @see android.os.Bundle#getStringArrayList(String)
     */
    @Nullable
    public static ArrayList<String> optStringArrayList(@Nullable Bundle bundle, @Nullable String key) {
        return optStringArrayList(bundle, key, new ArrayList<String>());
    }

    /**
     * Returns a optional {@link java.lang.String} {@link java.util.ArrayList}. In other words, returns the value mapped by key if it exists and is a {@link java.lang.String} {@link java.util.ArrayList}.
     * The bundle argument is allowed to be {@code null}. If the bundle is null, this method returns null.
     * @param bundle a bundle. If the bundle is null, this method will return null.
     * @param key a key for the value.
     * @param fallback fallback value.
     * @return a {@link java.lang.String} array value if exists, null otherwise.
     * @see android.os.Bundle#getStringArrayList(String)
     */
    @Nullable
    public static ArrayList<String> optStringArrayList(@Nullable Bundle bundle, @Nullable String key, @Nullable ArrayList<String> fallback) {
        if (bundle == null) {
            return fallback;
        }
        return bundle.getStringArrayList(key);
    }

    /**
     * Returns a bundle size.
     * @param bundle a bundle.
     * @return size of bundle, 0 if bundle is null or empty.
     * @see android.os.Bundle#size()
     */
    public static int size(@Nullable Bundle bundle) {
        if (bundle == null) {
            return 0;
        }
        return bundle.size();
    }

    /**
     * Checks if the bundle is empty or not.
     * If bundle is null, this method will return true;
     * @param bundle a bundle.
     * @return true if bundle is null or empty, false otherwise.
     * @see android.os.Bundle#isEmpty()
     */
    public static boolean isEmpty(@Nullable Bundle bundle) {
        return bundle == null || bundle.isEmpty();
    }

    /**
     * Checks if the bundle contains a specified key or not.
     * If bundle is null, this method will return false;
     * @param bundle a bundle.
     * @param key a key.
     * @return true if bundle is not null and the key exists in the bundle, false otherwise.
     * @see android.os.Bundle#containsKey(String)
     */
    public static boolean containsKey(@Nullable Bundle bundle, @Nullable String key) {
        return bundle != null && bundle.containsKey(key);
    }

    /**
     * Returns a set of keys in the bundle.
     * @param bundle a bundle.
     * @return a set of keys in the bundle. Empty set if bundle is null.
     * @see android.os.Bundle#keySet()
     */
    @NonNull
    public static Set<String> keySet(@Nullable Bundle bundle) {
        if (bundle == null) {
            return Collections.emptySet();
        }
        return bundle.keySet();
    }
}