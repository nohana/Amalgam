package com.amalgam.collection;

import java.util.Map;
import java.util.WeakHashMap;

/**
 *  ImmutableWeakHashMap
 *  The purpose of this class that define immutable this class instance for clarity.
 *
 * @param <K>
 * @param <V>
 */
public class ImmutableWeakHashMap<K, V> extends AbstractImmutableMap<K, V> {
    public ImmutableWeakHashMap(Map<K, V> map) {
        super(new WeakHashMap<K, V>(map));
    }
}
