package com.amalgam.database;

import android.database.Cursor;

/**
 */
public final class CursorUtils {
    private static final int TRUE = 1;

    private CursorUtils() {}

    public static final void close(Cursor cursor) {
        if (cursor == null) {
            return;
        }

        cursor.close();
    }

    public static final boolean getBoolean(Cursor cursor, String columnName) {
        if (cursor == null) {
            return false;
        }

        return cursor.getInt(cursor.getColumnIndex(columnName)) == TRUE;
    }
}
