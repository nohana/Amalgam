package com.amalgam.content;

/**
 */
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
}