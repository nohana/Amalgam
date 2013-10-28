package com.amalgam.database;

import android.database.sqlite.SQLiteDatabase;

/**
 */
public final class SQLiteDatabaseUtils {
    private  SQLiteDatabaseUtils() {}

    public static final void close(SQLiteDatabase db) {
        if (db == null) {
            return;
        }
        db.close();
    }

    public static final void endTransaction(SQLiteDatabase db) {
        if (db == null) {
            return;
        }
        db.endTransaction();
    }
}
