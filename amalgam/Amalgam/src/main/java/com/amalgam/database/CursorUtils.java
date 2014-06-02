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
package com.amalgam.database;

import android.annotation.TargetApi;
import android.database.Cursor;
import android.os.Build;

/**
 * Utility for the {@link android.database.Cursor}
 */
@SuppressWarnings("unused") // public APIs
public final class CursorUtils {
    private static final int TRUE = 1;

    private CursorUtils() {
        throw new AssertionError();
    }

    /**
     * Close with null checks.
     * @param cursor to close.
     */
    public static void close(Cursor cursor) {
        if (cursor == null) {
            return;
        }

        cursor.close();
    }

    /**
     * Read the boolean data for the column.
     * @see android.database.Cursor#getColumnIndex(String).
     * @param cursor the cursor.
     * @param columnName the column name.
     * @return the boolean value.
     */
    public static boolean getBoolean(Cursor cursor, String columnName) {
        return cursor != null && cursor.getInt(cursor.getColumnIndex(columnName)) == TRUE;
    }

    /**
     * Read the int data for the column.
     * @see android.database.Cursor#getInt(int).
     * @see android.database.Cursor#getColumnIndex(String).
     * @param cursor the cursor.
     * @param columnName the column name.
     * @return the int value.
     */
    public static int getInt(Cursor cursor, String columnName) {
        if (cursor == null) {
            return -1;
        }

        return cursor.getInt(cursor.getColumnIndex(columnName));
    }

    /**
     * Read the String data for the column.
     * @see android.database.Cursor#getString(int).
     * @see android.database.Cursor#getColumnIndex(String).
     * @param cursor the cursor.
     * @param columnName the column name.
     * @return the String value.
     */
    public static String getString(Cursor cursor, String columnName) {
        if (cursor == null) {
            return null;
        }

        return cursor.getString(cursor.getColumnIndex(columnName));
    }

    /**
     * Read the short data for the column.
     * @see android.database.Cursor#getShort(int).
     * @see android.database.Cursor#getColumnIndex(String).
     * @param cursor the cursor.
     * @param columnName the column name.
     * @return the short value.
     */
    public static short getShort(Cursor cursor, String columnName) {
        if (cursor == null) {
            return -1;
        }

        return cursor.getShort(cursor.getColumnIndex(columnName));
    }

    /**
     * Read the long data for the column.
     * @see android.database.Cursor#getLong(int).
     * @see android.database.Cursor#getColumnIndex(String).
     * @param cursor the cursor.
     * @param columnName the column name.
     * @return the long value.
     */
    public static long getLong(Cursor cursor, String columnName) {
        if (cursor == null) {
            return -1;
        }

        return cursor.getLong(cursor.getColumnIndex(columnName));
    }

    /**
     * Read the double data for the column.
     * @see android.database.Cursor#getDouble(int).
     * @see android.database.Cursor#getColumnIndex(String).
     * @param cursor the cursor.
     * @param columnName the column name.
     * @return the double value.
     */
    public static double getDouble(Cursor cursor, String columnName) {
        if (cursor == null) {
            return -1;
        }

        return cursor.getDouble(cursor.getColumnIndex(columnName));
    }

    /**
     * Read the float data for the column.
     * @see android.database.Cursor#getFloat(int).
     * @see android.database.Cursor#getColumnIndex(String).
     * @param cursor the cursor.
     * @param columnName the column name.
     * @return the float value.
     */
    public static float getFloat(Cursor cursor, String columnName) {
        if (cursor == null) {
            return -1;
        }

        return cursor.getFloat(cursor.getColumnIndex(columnName));
    }

    /**
     * Read the blob data for the column.
     * @see android.database.Cursor#getBlob(int).
     * @see android.database.Cursor#getColumnIndex(String).
     * @param cursor the cursor.
     * @param columnName the column name.
     * @return the blob value.
     */
    public static byte[] getBlob(Cursor cursor, String columnName) {
        if (cursor == null) {
            return null;
        }

        return cursor.getBlob(cursor.getColumnIndex(columnName));
    }

    /**
     * Checks the type of the column.
     * @see android.database.Cursor#getType(int).
     * @see android.database.Cursor#getColumnIndex(String).
     * @param cursor the cursor.
     * @param columnName the column name.
     * @return the type of the column.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static int getType(Cursor cursor, String columnName) {
        if (cursor == null) {
            return Cursor.FIELD_TYPE_NULL;
        }

        return cursor.getType(cursor.getColumnIndex(columnName));
    }

    /**
     * Checks if the column value is null or not.
     * @see android.database.Cursor#isNull(int).
     * @see android.database.Cursor#getColumnIndex(String).
     * @param cursor the cursor.
     * @param columnName the column name.
     * @return true if the column value is null.
     */
    public static boolean isNull(Cursor cursor, String columnName) {
        return cursor != null && cursor.isNull(cursor.getColumnIndex(columnName));

    }
}
