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
package com.amalgam.provider;

import android.net.Uri;
import android.provider.ContactsContract;

/**
 * Utility for the {@link android.provider.ContactsContract}.
 */
@SuppressWarnings("unused") // public APIs
public final class ContactsContractUtils {
    private ContactsContractUtils() {
        throw new AssertionError();
    }

    public static final class ContactsUtils {
        private ContactsUtils() {
            throw new AssertionError();
        }

        /**
         * Build a contact uri with the id.
         * @param contactId the id.
         * @return the full qualified contacts content uri.
         */
        public static Uri buildContactUri(long contactId) {
            return ContactsContract.Contacts.CONTENT_URI.buildUpon().appendPath(Long.toString(contactId)).build();
        }
    }
}