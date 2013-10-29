package com.amalgam.collection;

import java.util.Collection;

public final class CollectionUtils {
    private CollectionUtils() { }

    /**
     * Builds a string for a collection of objects.
     * Each element of the collection if stringified according to {@link String#valueOf(Object)}
     * rules.
     * @param collection the collection to stringify. can be null
     * @return a string representing the collection
     * @see String#valueOf(Object)
     */
    public static String toString(final Collection<?> collection) {
        if (collection == null) return String.valueOf(collection);
        //else
        final StringBuilder result = new StringBuilder().append("{");
        String elementSeparator = "";
        for (final Object element : collection) {
            result.append(elementSeparator);
            result.append(String.valueOf(element));
            elementSeparator = ",";
        }
        result.append("}");
        return result.toString();
    }
}