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

public final class ContactsContractUtils {
    private ContactsContractUtils() {}

    public static final class ContactsUtils {
        private ContactsUtils() {}

        public static final Uri buildContactUri(long contactId) {
            Uri uri = ContactsContract.Contacts.CONTENT_URI.buildUpon().appendPath(Long.toString(contactId)).build();
            return uri;
        }
    }
}