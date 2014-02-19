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

import android.os.Parcel;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("unused") // public APIs
public final class ParcelUtils {
    private static final int FALSE = 0;
    private static final int TRUE = 1;
    private static final byte MARKER_NO_ELEMENT_STORED = 0;
    private static final byte MARKER_AN_ELEMENT_STORED = 1;

    private ParcelUtils() {}

    public static void writeBoolean(Parcel dest, boolean bool) {
        dest.writeInt(bool ? TRUE : FALSE);
    }

    public static boolean readBoolean(Parcel source) {
        return source.readInt() == TRUE;
    }

    /**
     * Writes a date to a parcel at its current position.
     * More efficient than writing it as a {@link Serializable}.
     * Deals nicely with a null date, as long as {@link #readDate(Parcel)} is used to retrieve it
     * afterwards.
     * @param parcel the parcel to write the date to. Must be non-null.
     * @param date the date to write to the parcel. Can be null.
     * @see #readDate(Parcel)
     */
    public static void writeDate (final Parcel parcel, final Date date) {
        if (parcel == null) return;
        parcel.writeByte(date == null ? MARKER_NO_ELEMENT_STORED : MARKER_AN_ELEMENT_STORED);
        if (date != null) parcel.writeLong(date.getTime());
    }

    /**
     * Reads a date from a parcel from its current position.
     * Use this to retrieve dates stored with {@link #writeDate(Parcel, Date)}.
     * @return the stored date if any, or null otherwise
     * @see #writeDate(Parcel, Date)
     */
    public static Date readDate (final Parcel parcel) {
        final byte isADateStored = parcel.readByte();
        return (isADateStored == MARKER_AN_ELEMENT_STORED) ? new Date(parcel.readLong()) : null;
    }
}