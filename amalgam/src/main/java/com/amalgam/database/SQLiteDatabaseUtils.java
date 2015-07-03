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

import android.database.sqlite.SQLiteDatabase;

/**
 * Utility for the {@link android.database.sqlite.SQLiteDatabase}.
 */
@SuppressWarnings("unused") // public APIs
public final class SQLiteDatabaseUtils {
    private  SQLiteDatabaseUtils() {
        throw new AssertionError();
    }

    /**
     * Close with null checks.
     * @param db to close.
     */
    public static void close(SQLiteDatabase db) {
        if (db == null) {
            return;
        }
        db.close();
    }

    /**
     * Ensure to finish transaction with null checks.
     * @param db to finish transaction.
     */
    public static void endTransaction(SQLiteDatabase db) {
        if (db == null) {
            return;
        }
        db.endTransaction();
    }
}
