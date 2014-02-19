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

import android.database.Cursor;

/**
 */
@SuppressWarnings("unused") // public APIs
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
