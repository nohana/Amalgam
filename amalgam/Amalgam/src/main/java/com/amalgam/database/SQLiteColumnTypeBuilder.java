/*
 * Copyright (C) 2014 nohana, Inc. All rights reserved.
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

/**
 * Convenient utility to declare SQLiteDatabase table column.
 *
 * @author KeithYokoma
 */
@SuppressWarnings("unused")
public final class SQLiteColumnTypeBuilder {
    private static final String STATEMENT_PRIMARY_KEY = "PRIMARY KEY";
    private static final String STATEMENT_AUTO_INCREMENT = "AUTOINCREMENT";
    private static final String STATEMENT_NOT_NULL = "NOT NULL";
    private static final String DELIMITER = " ";
    private final StringBuilder mBuilder;

    public SQLiteColumnTypeBuilder() {
        mBuilder = new StringBuilder();
    }

    public SQLiteColumnTypeBuilder asPrimaryKey() {
        if (mBuilder.indexOf(STATEMENT_PRIMARY_KEY) != -1) {
            throw new IllegalStateException("This method should not be called more than once.");
        }
        mBuilder.append(STATEMENT_PRIMARY_KEY).append(DELIMITER);
        return this;
    }

    public SQLiteColumnTypeBuilder asAutoIncrement() {
        if (mBuilder.indexOf(STATEMENT_AUTO_INCREMENT) != -1) {
            throw new IllegalStateException("This method should not be called more than once.");
        }
        mBuilder.append(STATEMENT_AUTO_INCREMENT).append(DELIMITER);
        return this;
    }

    public SQLiteColumnTypeBuilder asNotNull() {
        if (mBuilder.indexOf(STATEMENT_NOT_NULL) != -1) {
            throw new IllegalStateException("This method should not be called more than once.");
        }
        mBuilder.append(STATEMENT_NOT_NULL).append(DELIMITER);
        return this;
    }

    public SQLiteColumnTypeBuilder dataType(DataType type) {
        String statement = type.name();
        if (mBuilder.indexOf(statement) != -1) {
            // XXX This is a light-weight verification. We need more precise verification to prevent declaring multiple data type.
            throw new IllegalStateException("This method should not be called more than once.");
        }
        mBuilder.append(statement).append(DELIMITER);
        return this;
    }

    /**
     * Fix statement.
     *
     * @return fixed statement.
     */
    @Override
    public String toString() {
        return mBuilder.toString();
    }

    public static enum DataType {
        INTEGER, TEXT, REAL, NUMERIC, NONE
    }
}
