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

    /**
     * Calculates the index of the last entry in the collection.
     * @return the last entry index.
     */
    public static int getLastIndex(final Collection<?> collection) {
        if (isEmptry(collection)) {
            return 0;
        }
        return collection.size() - 1;
    }
}
