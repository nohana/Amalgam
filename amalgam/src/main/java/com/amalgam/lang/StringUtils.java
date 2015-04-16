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
package com.amalgam.lang;

import java.util.Collection;
import java.util.Iterator;

/**
 * Utility for the {@link java.lang.String}.
 */
@SuppressWarnings("unused") // public APIs
public final class StringUtils {
    public static final String EMPTY = "";
    public static final String SPACE = " ";

    private StringUtils() {
        throw new AssertionError();
    }

    /**
     * Convert byte data to hex code string.
     *
     * @param data to convert.
     * @return the hex code of the byte array.
     */
    public static String byteToHex(byte[] data) {
        if (data == null) {
            return null;
        }
        final StringBuilder builder = new StringBuilder();
        for (final byte b : data) {
            builder.append(String.format("%02X", b));
        }
        return builder.toString();
    }

    public static String replaceLineBreaksWithSpace(String string) {
        return replaceLineBreaks(string, SPACE);
    }

    public static String collapseLineBreaks(String string) {
        return replaceLineBreaks(string, EMPTY);
    }

    public static String replaceLineBreaks(String string, String replace) {
        if (string == null)
            return null;
        return string.replaceAll("\\r\\n|\\r|\\n", replace);
    }

    public static String removeWhiteSpaces(String string) {
        if (string == null)
            return null;
        return string.replaceAll("\\s+", "");
    }

    public static String tryTrim(String string) {
        if (string == null)
            return null;
        return string.trim();
    }

    public static int getLevenshteinDistance(CharSequence s, CharSequence t) {
        if (s == null || t == null)
            throw new IllegalArgumentException("Strings must not be null");

        int n = s.length();
        int m = t.length();

        if (n == 0)
            return m;
        else if (m == 0)
            return n;

        if (n > m) {
            CharSequence tmp = s;
            s = t;
            t = tmp;
            n = m;
            m = t.length();
        }

        int p[] = new int[n + 1]; //'previous' cost array, horizontally
        int d[] = new int[n + 1]; // cost array, horizontally
        int pd[]; //placeholder to assist in swapping p and d

        // indexes into strings s and t
        int i; // iterates through s
        int j; // iterates through t

        for (i = 0; i <= n; i++)
            p[i] = i;

        int cost; // cost
        char tj; // jth character of t

        for (j = 1; j <= m; j++) {
            tj = t.charAt(j - 1);
            d[0] = j;

            for (i = 1; i <= n; i++) {
                cost = s.charAt(i - 1) == tj ? 0 : 1;
                // minimum of cell to the left+1, to the top+1, diagonally left and up +cost
                d[i] = Math.min(Math.min(d[i - 1] + 1, p[i] + 1), p[i - 1] + cost);
            }

            // copy current distance counts to 'previous row' distance counts
            pd = p;
            p = d;
            d = pd;
        }

        // our last action in the above loop was to switch d and p, so p now
        // actually has the most recent cost counts
        return p[n];
    }

    public static String join(Object[] array, char separator) {
        if (array == null) {
            return null;
        }

        return join(array, separator, 0, array.length);
    }

    public static String join(Object[] array, char separator, int startIndex, int endIndex) {
        if (array == null) {
            return null;
        }
        int bufSize = (endIndex - startIndex);
        if (bufSize <= 0) {
            return EMPTY;
        }

        bufSize *= ((array[startIndex] == null ? 16 : array[startIndex].toString().length()) + 1);
        StringBuilder buf = new StringBuilder(bufSize);

        for (int i = startIndex; i < endIndex; i++) {
            if (i > startIndex) {
                buf.append(separator);
            }
            if (array[i] != null) {
                buf.append(array[i]);
            }
        }
        return buf.toString();
    }


    public static <T> String join(Iterator<T> iterator, String separator) {
        // handle null, zero and one elements before building a buffer
        if (iterator == null) {
            return null;
        }
        if (!iterator.hasNext()) {
            return EMPTY;
        }
        Object first = iterator.next();
        if (!iterator.hasNext()) {
            return first != null ? first.toString() : null;
        }

        // two or more elements
        StringBuilder buf = new StringBuilder(256); // Java default is 16, probably too small
        if (first != null) {
            buf.append(first);
        }

        while (iterator.hasNext()) {
            if (separator != null) {
                buf.append(separator);
            }
            Object obj = iterator.next();
            if (obj != null) {
                buf.append(obj);
            }
        }
        return buf.toString();
    }

    public static <T> String join(Collection<T> collection, String separator) {
        if (collection == null) {
            return null;
        }
        return join(collection.iterator(), separator);
    }
}
