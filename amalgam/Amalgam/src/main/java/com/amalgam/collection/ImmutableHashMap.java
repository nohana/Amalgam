package com.amalgam.collection;

import java.util.HashMap;
import java.util.Map;

/**
 *  ImmutableHashMap
 *  The purpose of this class that define immutable this class instance for clarity.
 * @param <K>
 * @param <V>
 */
public class ImmutableHashMap <K, V> extends AbstractImmutableMap<K, V> {
    public ImmutableHashMap(Map<K, V> map) {
        super(new HashMap<K, V>(map));
    }
}