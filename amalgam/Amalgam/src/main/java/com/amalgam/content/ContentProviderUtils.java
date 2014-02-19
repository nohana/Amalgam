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
package com.amalgam.content;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;

/**
 */
@SuppressWarnings("unused") // public APIs
public final class ContentProviderUtils {
    private static final String PLURAL_MIME_TYPE = "vnd.android.cursor.dir";
    private static final String SINGULAR_MIME_TYPE = "vnd.android.cursor.item";
    private ContentProviderUtils() {}

    public static final String buildPluralMimeType(String subType) {
        return PLURAL_MIME_TYPE + "/" + subType;
    }

    public static final String buildSingularMimeType(String subType) {
        return SINGULAR_MIME_TYPE + "/" + subType;
    }

    public static final void notifyChange(ContentProvider provider, Uri uri, ContentObserver observer) {
        notifyChange(provider.getContext(), uri, observer);
    }

    public static final void notifyChange(Context context, Uri uri, ContentObserver observer) {
        ContentResolver resolver = context.getContentResolver();
        resolver.notifyChange(uri, observer);
    }
}